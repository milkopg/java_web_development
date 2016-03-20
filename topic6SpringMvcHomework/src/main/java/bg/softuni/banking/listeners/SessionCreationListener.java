package bg.softuni.banking.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bg.softuni.banking.services.BankOperationServiceImpl;

/**
 * Application Lifecycle Listener implementation class SessionCreationListener
 *
 */
public class SessionCreationListener implements HttpSessionListener {

	/**
     * Default constructor. 
     */
    public SessionCreationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
         event.getSession().setAttribute("currencies", BankOperationServiceImpl.fillCurrencies());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
    	 event.getSession().removeAttribute("currencies");
    }
	
}
