package bg.jwd.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BankController {
	@RequestMapping(value = "/bankRegister", method = RequestMethod.GET)
	public String getRegister() {
		return "bankRegister";
	}
}
