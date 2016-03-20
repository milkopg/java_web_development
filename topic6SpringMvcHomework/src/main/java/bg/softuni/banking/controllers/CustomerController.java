package bg.softuni.banking.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.softuni.banking.constants.Constants;
import bg.softuni.banking.entities.Customer;
import bg.softuni.banking.entities.Operation;
import bg.softuni.banking.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="addCustomer", method = RequestMethod.GET)
	public String addCustomer(Model model, @ModelAttribute("operation") Operation operation,  BindingResult result, HttpServletRequest request) {
		Customer customer= operation.getCustomer();
		return "addCustomer";
	}
	
	@RequestMapping(value="operation", method = RequestMethod.GET)
	public String getCustomer (String accountNumber, Model model) {
		Customer customer = customerService.getCustomer(accountNumber);
		model.addAttribute(Constants.CUSTOMER, customer);
		return "operation";
	}
}
