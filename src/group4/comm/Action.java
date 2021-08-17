package group4.comm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public Forward execute(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException;
}