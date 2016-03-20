package bg.softuni.courses.web.development.lection3.homework.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String username = "admin";
		String password = "admin123";
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		if (httpRequest.getSession().getAttribute("username") == null && !httpRequest.getRequestURI().endsWith("login.jsp")) {
 			((HttpServletResponse)response).sendRedirect("login.jsp");
		}
		
		if ((username.equals(request.getParameter("username")) && (password.equals(request.getParameter("password"))))) {
			httpRequest.getSession().setAttribute("username", request.getParameter("username"));
			((HttpServletResponse)response).sendRedirect("home.jsp");
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
