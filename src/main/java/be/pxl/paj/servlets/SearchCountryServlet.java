package be.pxl.paj.servlets;

import be.pxl.paj.servlets.domain.Country;
import org.springframework.web.client.RestTemplate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchCountry", value = "/SearchCountry")
public class SearchCountryServlet extends HttpServlet {

	private final RestTemplate restTemplate;

	public SearchCountryServlet(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Country[] countries = restTemplate.getForEntity(String.format("http://restcountries.eu/rest/v2/capital/%s", req.getParameter("capital")), Country[].class).getBody();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Country information</h1>");
			out.println("<table border='1'>");
			for(Country country : countries) {
				out.println("<tr><td>Name:</td><td>" + country.getName() + "</td></tr>");
				out.println("<tr><td>Code:</td><td>" + country.getAlpha2Code() + "</td></tr>");
				out.println("<tr><td>Native name:</td><td>" + country.getNativeName() + "</td></tr>");
			}

			out.println("</table");
			out.println("</body>");
			out.println("</html>");
		}

	}
}
