package bg.softuni.courses.web.development.lection2.homework.problem3.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(createHtmlForm());
		
	}
	
	public String createHtmlForm() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head></head>");
		builder.append("<body>");
		builder.append("<form>");
		builder.append("<label>ID:</label><input type=\"text\" name=\"firstname\"></br>");
		builder.append("<label>Topic:</label><input type=\"text\" name=\"topic\"></br>");
		builder.append("<label>Date:</label><input type=\"date\" name=\"date\"></br>");
		builder.append("<input type=\"submit\" value=\"Submit\">");
		builder.append("<input type=\"reset\" value=\"Reset\">");
		builder.append("</form>");
		builder.append("</body>");
		builder.append("</html>");
		
		return builder.toString();
	}

}
