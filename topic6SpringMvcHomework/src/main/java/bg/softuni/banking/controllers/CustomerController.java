package bg.softuni.banking.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.entities.Customer;
import bg.softuni.banking.entities.Operation;
import bg.softuni.banking.services.BankOperationService;
import bg.softuni.banking.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BankOperationService bankService;
	
	@RequestMapping(value="addCustomer", method = RequestMethod.GET)
	public String addCustomer(Model model, @ModelAttribute("operation") Operation operation, HttpServletRequest request) {
		Customer customer;
		String accountNumber = request.getParameter("accountNumber");
		String fullName = request.getParameter("fullName");
		String depositType = request.getParameter("depositType");
		String activeCurrency = request.getParameter("currencies");
		String amountStr = request.getParameter("amount");
		BigDecimal amount = null;
		
		
		try {
			if (amountStr != null) {
				amount = new BigDecimal(request.getParameter("amount"));
			} else {
				amount = new BigDecimal(0);
			}
		} catch (NumberFormatException nfe) {
			amount = new BigDecimal(0);
		}
		
		if (accountNumber == null) return "opertion";
		
		if (customerService.getCustomer(accountNumber) == null) {
			customer = new Customer();
			customer.setAccountNumber(accountNumber);
		} else {
			customer = customerService.getCustomer(accountNumber);
		}
		customer.setFullName(fullName);
		operation.setActiveCurrency(activeCurrency);
		operation.setCustomer(customer);
		operation.setAmount(amount);
		operation.setDepositType(depositType);
		
		List<String> errors = bankService.validateOperation(operation); 
		operation.setErrors(errors);
		
		if ((errors != null) && (errors.isEmpty())) {
			if(bankService.withdrawOrDeposit(operation)) {
				model.addAttribute("operation", operation);
				model.addAttribute("customer", customer);
			}
		}
		return "operation";
	}
	
	@RequestMapping(value="operation", method = RequestMethod.POST)
	public String getCustomer (String accountNumber, Model model) {
		Customer customer = customerService.getCustomer(accountNumber);
		model.addAttribute(Constants.CUSTOMER, customer);
		return "operation";
	}
}
