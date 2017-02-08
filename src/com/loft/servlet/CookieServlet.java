package com.loft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = null;
		// 获取与该域相关的 Cookie 的数组
		cookies = request.getCookies();
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		String docType = "<!DOCTYPE html>\n";
		PrintWriter out = response.getWriter();
		String title = null;
		if (cookies != null && cookies.length > 0) {
			title = "读取cookies信息";
			out.println(docType + "<html>\n" + "<head><title>" + title
					+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
			for (int i = 0; i < cookies.length; i++) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				out.println(cookies[i].getName() + "   "
						+ URLDecoder.decode(cookies[i].getValue(), "UTF-8"));
				int x=10;
			}
			out.println("</body>");
			out.println("</html>");
		} else {
			title = "设置cookies信息";
			Cookie _cookie = new Cookie("name", URLEncoder.encode("我是cookie",
					"uTF-8"));
			// 储存24小时
			_cookie.setMaxAge(60 * 60 * 24);
			Cookie _cookie2 = new Cookie("address", URLEncoder.encode("我的地址",
					"uTF-8"));
			// 储存24小时
			_cookie2.setMaxAge(60 * 60 * 24);
			response.addCookie(_cookie);
			response.addCookie(_cookie2);
			out.println(docType + "<html>\n" + "<head><title>" + title
					+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
			out.println(_cookie.getName() + "   "
					+ URLDecoder.decode(_cookie.getValue(), "UTF-8"));
			out.println(_cookie2.getName() + "   "
					+ URLDecoder.decode(_cookie2.getValue(), "uTF-8"));
			out.println("</body>");
			out.println("</html>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
