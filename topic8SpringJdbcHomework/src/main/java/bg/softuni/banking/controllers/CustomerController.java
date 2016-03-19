package bg.softuni.banking.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.entities.Account;
import bg.softuni.banking.entities.Currency;
import bg.softuni.banking.entities.Operation;
import bg.softuni.banking.security.User;
import bg.softuni.banking.services.AccountService;
import bg.softuni.banking.services.BankOperationService;
import bg.softuni.banking.utility.UserUtils;

@Controller
public class CustomerController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BankOperationService bankService;
	
	@RequestMapping(value="addAccount", method = RequestMethod.POST)
	public String addCustomer(Model model, @ModelAttribute("account") Account account, HttpServletRequest request) {
		String accountNumber = account.getAccountNumber();
		if (accountNumber == null) return "home";
		
		if (accountService.getAccount(accountNumber) == null) {
			account.setId(accountService.getMaxIndexFromTable("tAccount")+1);
			account.setUser(UserUtils.getUser());
			account.setCurrency(accountService.getCurrencyByName(request.getParameter("account.currency.name")));
		} else {
			account.getErrors().add(BankOperationService.ERROR_ACCOUNT_NUMBER_ALREADY_EXISTS.replace("{0}", accountNumber));
		}
		
		if (account.getInitialAmount().signum() == -1) {
			account.getErrors().add(BankOperationService.ERROR_WITHDRAW_GREATER_THAN_ZERO.replace("{0}", accountNumber));
		}
		
		if (((account.getTotalAmount() != null) && (account.getTotalAmount().signum() == 0)) && (account.getInitialAmount() != null)) {
			account.setTotalAmount(account.getInitialAmount());
		}
		
		if ((account.getErrors() != null) && (account.getErrors().isEmpty())) {
			accountService.addAccount(account);
			account.setUser(UserUtils.getUser());
			model.addAttribute(Constants.ACCOUNT, account);
			return "home";
		} else {
			return "register";
		}
		
		
	}
	
	@RequestMapping(value="addOperation", method = RequestMethod.POST)
	public String addOperation(Model model, @ModelAttribute("operation") Operation operation, HttpServletRequest request) {
		if ((operation == null) || (operation.getAccount() == null)) return "home";
		operation.getAccount().getErrors().clear();
		
		if (accountService.getAccount(operation.getAccount().getAccountNumber()) == null) {
			operation.getAccount().getErrors().add(BankOperationService.ERROR_ACCOUNT_NUMBER_NOT_FOUND.replace("{0}", operation.getAccount().getAccountNumber()));
			return "operation";
		} else {
			operation.setAccount(accountService.getAccount(operation.getAccount().getAccountNumber()));
		} 
		
		operation.setUser(UserUtils.getUser());
		List<String> errors = bankService.validateOperation(operation); 
		operation.getAccount().setErrors(errors);
		
		if ((errors != null) && (errors.isEmpty())) {
			if (bankService.calculateAmount(operation)) {
				model.addAttribute("account", operation.getAccount());
				operation.setId(accountService.getMaxIndexFromTable("tOperation")+1);
			}
		} else {
			return "operation";
		}
		return "home";
	}
	
	//@Secured("ROLE_USER")
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String getCustomer (Model model, String accountNumber, HttpServletRequest request) {
		User user = UserUtils.getUser();
		if (Constants.ROLE_USER.equals(user.getAuthorities().iterator().next().getAuthority())) {
			Account initialAccount = accountService.getAccountByCreationByUserId(accountService.getUserByUsername(user.getUsername()).getId());
			accountNumber = initialAccount.getAccountNumber();
		}
		Account account = accountService.getAccount(accountNumber);
		request.getSession().setAttribute("accountNumber", account.getAccountNumber());
		model.addAttribute(Constants.ACCOUNT, account);
		return "home";
	}
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView navigateToRegister(Model model, @ModelAttribute("account") Account account) {
		return new ModelAndView("register", "account", account);
	}
	
	@RequestMapping(value="operation", method=RequestMethod.GET)
	public String navigateToOperation() {
		return "operation";
	}
}
