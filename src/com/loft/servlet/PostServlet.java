package com.loft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE html> \n";
//		String name = new String(request.getParameter("name").getBytes(
//				"ISO8859-1"), "UTF-8");
//		String password = request.getParameter("password");
//		out.println(docType + "<html>\n" + "<head><title>" + name
//				+ "</title></head>\n" + "<body>\n" + "<h1 align=\"center\">"
//				+ name + "</h1>\n" + password + "\n" + "</body>\n" + "</html>");
		

		out.println(docType +
				"<html>\n" +
				"<head><meta charset=\"utf-8\"><title>"  + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + "测试表单" + "</h1>\n" +
				"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
				"<tr bgcolor=\"#949494\">\n" +
				"<th>参数名称</th><th>参数值</th>\n"+
				"</tr>\n");

		Enumeration paramNames = request.getParameterNames();

		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
			String[] paramValues =
			request.getParameterValues(paramName);
			// 读取单个值的数据
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<td><i>没有值</i></td>");
				else
					out.println("<td>" + paramValue + "</td>");
			} else {
				// 读取多个值的数据
				out.println("<td><ul>");
				for(int i=0; i < paramValues.length; i++) {
				out.println("<li>" + paramValues[i]);
			}
				out.println("</ul></td>");
			}
			out.print("</tr>");
		}
		out.println("\n</table>\n</body></html>");
		
		
		
	}

}
