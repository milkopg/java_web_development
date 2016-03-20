package bg.softuni.courses.web.development.lection2.homework.problem3.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(createHtmlTableFromServlet());
	}
	
	private String createHtmlTableFromServlet() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("<html>");
		builder.append("<head><title>").append("Table Servlet").append("</title></head>");
		builder.append("<body>");
		builder.append("<table border=1>");
		builder.append("<thead><tr>");
		builder.append("<th>Topic</th>");
		builder.append("<th>Date</th>");
		builder.append("<thead><tr>");
		builder.append("<tbody><tr>");
		builder.append("<td>Web Basics</td>");
		builder.append("<td>" + new Date() + "</td>");
		builder.append("</tbody></tr>");
		builder.append("</table>");
		builder.append("</body></html>");
		
		return builder.toString();
	}

}
