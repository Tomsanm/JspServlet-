package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.blog.daoImp.WriteDaoImp;
import com.blog.entity.WriteEntity;

/**
 * Servlet implementation class Article_in
 */
@WebServlet("/com/blog/servlet/Article_in_servlet")
public class Article_in_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Article_in_servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("前端获取文章数据----");
//		String text = request.getParameter("text");
		String text = request.getParameter("t1");
		String title = request.getParameter("article_title");
		System.out.println("将数据保存在实体类中  text"+text);
		WriteEntity data = new WriteEntity(text);
		data.setTitle(title);
		WriteDaoImp ri = new WriteDaoImp();
		// 调用数据访问层  写入数据库
		if(ri.in_tb_article_info(data)) {
			
			// 发表成功
			response.sendRedirect("/Blog_Project/pressSuccess.jsp");
		}else {
			System.out.println("写入文章失败....");
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
