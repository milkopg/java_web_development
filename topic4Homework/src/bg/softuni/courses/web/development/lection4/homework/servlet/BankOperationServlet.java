package bg.softuni.courses.web.development.lection4.homework.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.softuni.courses.web.development.lection4.homework.ejb.session.BankOperationsStateFull;
import bg.softuni.courses.web.development.lection4.homework.ejb.session.BankOperationsStateless;
import bg.softuni.courses.web.development.lection4.homework.ejb.singleton.UserGlobalDataCollection;
import bg.softuni.courses.web.development.lection4.homework.ejb.singleton.UserGlobalDataCollectionImpl;
import bg.softuni.courses.web.development.lection4.homework.model.Customer;

/**
 * Servlet implementation class BankOperationServlet
 */
@WebServlet("/bank")
public class BankOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String accountNumber;
	private String fullName;
	private String depositType;
	private boolean isDeposit;
	private BigDecimal amountToChange;
	private String activeCurrency;
    
	public static final String TYPE_DEPOSIT = "deposit";
	public static final String TYPE_WITHDRAW = "withdraw";
	
	@EJB
	private UserGlobalDataCollection userGlobalDataCollection;
	
	@EJB
	private BankOperationsStateless bankOperationsStateless;
	
	@EJB
	private BankOperationsStateFull bankOperationsStateFull;
	
	private Customer customer;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		accountNumber = request.getParameter("accountNumber"); 
		activeCurrency = request.getParameter("currencies");
		fullName = request.getParameter("fullName");
		try {
			amountToChange = new BigDecimal(request.getParameter("amount")).multiply(new BigDecimal(UserGlobalDataCollectionImpl.getCurrencies().get(activeCurrency)));
		} catch (NumberFormatException nfe) {
			amountToChange = new BigDecimal(0);
		}
		
		depositType = request.getParameter("depositType"); 
		if (TYPE_DEPOSIT.equals(depositType)) {
			isDeposit = true;
		} else if (TYPE_WITHDRAW.equals(depositType)) {
			isDeposit = false;
		}
		
		if (!userGlobalDataCollection.checkIfCustomerExists(accountNumber)) {
			customer = bankOperationsStateless.createCustomer(accountNumber);
		} else {
			customer = userGlobalDataCollection.getUserByAccountNumber(accountNumber);
		}
		
		customer.setAmount(amountToChange);
		customer.setFullName(fullName);
		
		
		customer.setErrors(bankOperationsStateFull.validateUserAndReturnErrorList(customer, isDeposit));
		if ((customer.getErrors() != null) && (customer.getErrors().isEmpty())) {
			bankOperationsStateless.withdrawMoney(customer, amountToChange, isDeposit, activeCurrency);
			bankOperationsStateless.saveUser(customer, isDeposit);
			
		}
		request.getSession().setAttribute("customer", customer);
		response.sendRedirect("home.jsp");

		
//		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("home.jsp");
//		rd.forward(request, response);
	}
}
