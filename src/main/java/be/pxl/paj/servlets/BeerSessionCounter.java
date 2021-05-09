package be.pxl.paj.servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class BeerSessionCounter implements HttpSessionListener {

	private static int activeSessions;

	public static int getActiveSessions() {
		return activeSessions;
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		activeSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		activeSessions--;
	}
}
