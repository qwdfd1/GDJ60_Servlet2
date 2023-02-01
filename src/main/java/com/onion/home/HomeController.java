package com.onion.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String method = request.getMethod();
//		StringBuffer sb = request.getRequestURL();
//		String uri = request.getRequestURI();
//		String context = request.getContextPath();
//		Cookie [] cookies =  request.getCookies();
//		
//		String name = request.getParameter("name");
//		
//		String age = request.getParameter("age");
//		int a = 0;
//		if(age != null) {
//			a = Integer.parseInt(age);
//		}
//		 
//		
//		String [] moneys = request.getParameterValues("money");
//		
//		System.out.println("Method : " + method);
//		System.out.println("URL : " + sb);
//		System.out.println("URI : " + uri);
//		for (Cookie cookie : cookies) {
//			System.out.println("CookieName : " + cookie.getName());
//			System.out.println("CookieValue : " + cookie.getValue());
//		}
//		System.out.println("ContextPath : " + context);
//		System.out.println("Name : " + name);
//		System.out.println("Age : " + a);
//		
//		if(moneys != null) {
//			for (String money : moneys) {
//				System.out.println("Money : " + money);
//			}
//		}
		
		
		
//		System.out.println("Hello SEOK J OOOOOOOOOOOOOOOOO");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>SEK JOO PAGE </h1>");
//		out.println("<h2>Header2</h2>");
//		
		
//		out.close();
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
