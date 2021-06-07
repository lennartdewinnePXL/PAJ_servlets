package be.pxl.paj.servlets;

import be.pxl.paj.servlets.domain.Phonebook;
import be.pxl.paj.servlets.repository.PhonebookRepository;
import be.pxl.paj.servlets.service.BeerExpert;
import be.pxl.paj.servlets.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/phonebook.do")
public class PhonebookServlet extends HttpServlet {
    @Autowired
    private PhoneBookService phoneBookService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Phonebook phonebook = new Phonebook();
        phonebook.setLastName(req.getParameter("lastName"));
        phonebook.setPhoneNumber(Long.parseLong(req.getParameter("phoneNumber")));
        phonebook.setName(req.getParameter("firstName"));
        phoneBookService.addPhoneNumber(phonebook);
        String result = "Welcome " + phonebook.getName();
        PrintWriter writer = resp.getWriter();

        writer.println("<html>" +
                "<body>" +
                "<h1 style=\"text-align:center\">Try these beers:</h1><p>" +
                String.join(", ", result) +
                "</p></body>" +
                "</html>");
    }
}
