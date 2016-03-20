package bg.softuni.courses.web.development.lection3.homework.listener;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestLoggerListener
 *
 */
@WebListener
public class RequestLoggerListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestLoggerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent request)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)  {
    	 HttpServletRequest httpRequest = (HttpServletRequest) event.getServletRequest();
         String ipAddress = event.getServletRequest().getLocalAddr();
         String sessionId = httpRequest.getSession().getId();
         String requestType = httpRequest.getMethod();
         String dateTime = new Date().toString();
         
         System.out.println("IP Address: " + ipAddress + ", sessionId: " + sessionId + ", RequestType: " + requestType + ", Date and Time of Request: " + dateTime);
        		 
    }
	
}
