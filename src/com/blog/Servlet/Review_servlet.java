package com.blog.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.daoImp.ReviewDaoImp;

/**
 * Servlet implementation class Look_servlet
 */
@WebServlet("/com/blog/servlet/Review_servlet")
public class Review_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Review_servlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 从数据库读出文章，让后setAttribte 跳转显示页面
		int id = Integer.parseInt(request.getParameter("select_id"));
		System.out.println("选择文章序号"+id);
		ReviewDaoImp ri =new ReviewDaoImp();
		ArrayList<String> article = ri.seek(id);
//		System.out.println("博文标题"+article.get(0));
		String title = article.get(0);
		String text = article.get(1);
		System.out.println(text);
		
		// 将内容装入 请求
		request.setAttribute("title",title);
		request.setAttribute("content", text);
		
		HttpSession session =request.getSession();
		// 请求转发
		if(session.getAttribute("uname")!=null) {
			request.getRequestDispatcher("/look_new.jsp").forward(request, response);// 这里注意要一起使用;
			}
			else {
				response.sendRedirect("/Blog_Project/login.jsp");}
		
		
//		response.sendRedirect("/Blog_Project/look_new.jsp");
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
