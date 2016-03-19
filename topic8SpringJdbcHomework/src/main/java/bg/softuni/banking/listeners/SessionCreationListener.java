package bg.softuni.banking.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bg.softuni.banking.dao.AccountDaoImpl;

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
    public void sessionCreated(HttpSessionEvent se)  { 
        se.getSession().setAttribute("currencies", AccountDaoImpl.fillCurrencies());
   }

	/**
    * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
    */
   public void sessionDestroyed(HttpSessionEvent se)  { 
        se.getSession().removeAttribute("currencies");
   }
	
}
