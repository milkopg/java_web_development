package bg.softuni.courses.web.development.lection4.homework.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bg.softuni.courses.web.development.lection4.homework.ejb.singleton.UserGlobalDataCollection;
import bg.softuni.courses.web.development.lection4.homework.ejb.singleton.UserGlobalDataCollectionImpl;

/**
 * Application Lifecycle Listener implementation class SessionCreationListener
 *
 */
@WebListener
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
         event.getSession().setAttribute("currencies", UserGlobalDataCollectionImpl.getCurrencies());
         event.getSession().setAttribute("selected", UserGlobalDataCollection.CURRENCY_BGL);
         
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
    	 event.getSession().removeAttribute("userGlobalDataCollectionImpl");
    }
	
}
