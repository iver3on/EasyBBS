package ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Message;
import dao.MessageDao;
import dao.impl.MessageDaoImpl;

public class ListAllServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDao md=new MessageDaoImpl();
		List<Message> ms=md.findAll("");
		request.setAttribute("ms", ms);
		request.getRequestDispatcher("listAll.jsp").forward(request, response);
		
		
	}

}
