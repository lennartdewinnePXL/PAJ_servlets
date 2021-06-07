package be.pxl.paj.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    private static final Random RANDOM = new Random();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        String response = "Welcome";
        int greeting = RANDOM.nextInt(2);
        if (greeting == 1){
            response += " boy";
        }else{
            response += " girl";
        }
        writer.println("<html>" +
                "<body>" +
                "<h1 style=\"text-align:center\">"+response+"</h1><p>" +
                "</p></body>" +
                "</html>");

    }
}
