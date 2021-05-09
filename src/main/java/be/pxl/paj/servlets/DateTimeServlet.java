package be.pxl.paj.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/DateTimeServlet")
public class DateTimeServlet extends HttpServlet {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		LocalDateTime dateTime = LocalDateTime.now();
		writer.println("<html>" +
				"<body>" +
				"<h1 style=\"text-align:center\">Today is...</h1><p>" +
				FORMATTER.format(dateTime) +
				"</p></body>" +
				"</html>");

	}
}
