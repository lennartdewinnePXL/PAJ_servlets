package be.pxl.paj.servlets;

import be.pxl.paj.servlets.domain.Country;
import be.pxl.paj.servlets.domain.Phonebook;
import be.pxl.paj.servlets.service.PhoneBookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/phonebook.get")
public class PhonebookGetServet extends HttpServlet {
    private final PhoneBookService phoneBookService;

    public PhonebookGetServet(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Phonebook> phonebookList = phoneBookService.getPhoneNumbers();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Country information</h1>");
            out.println("<table border='1'>");
            for (Phonebook country : phonebookList) {
                if (req.getParameter("filter").equals(country.getLastName()) || req.getParameter("filter").equals(country.getName())) {
                    out.println("<tr><td>Name:</td><td>" + country.getName() + "</td></tr>");
                    out.println("<tr><td>Code:</td><td>" + country.getLastName() + "</td></tr>");
                    out.println("<tr><td>Native name:</td><td>" + country.getPhoneNumber() + "</td></tr>");
                }
            }

            out.println("</table");
            out.println("</body>");
            out.println("</html>");
        }

    }
}
