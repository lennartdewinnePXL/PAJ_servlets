package be.pxl.paj.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;

@WebServlet(value="/TestSession")
public class TestSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();

		PrintWriter writer = resp.getWriter();
		writer.println("Session ID: " + session.getId());
		writer.println("Number of sessions: " + BeerSessionCounter.getActiveSessions());
		writer.println("Creation Time: " + Instant.ofEpochMilli(session.getCreationTime()).atZone(ZoneId.systemDefault()).toLocalDateTime());
		writer. println("Last Accessed Time: " + Instant.ofEpochMilli(session.getLastAccessedTime()).atZone(ZoneId.systemDefault()).toLocalDateTime());
	}
}
