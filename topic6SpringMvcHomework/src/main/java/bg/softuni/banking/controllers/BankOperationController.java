package bg.softuni.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bg.softuni.banking.services.BankOperationService;

@Controller
public class BankOperationController {
	@Autowired
	BankOperationService bankOperationService;
	
	
	
}
