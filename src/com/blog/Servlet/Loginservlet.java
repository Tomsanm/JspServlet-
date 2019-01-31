package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.daoImp.LoginDaoImp;
import com.blog.entity.LoginEntity;

// 控制器层：负责接受请求，和 分派 给 Java bean
@WebServlet("/com/blog/servlet/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		System.out.println("控制器开始工作了");
		System.out.println("获取 请求中的登录数据");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		// 查看 记住我选项
		String ck = request.getParameter("ck");
		System.out.println("查看ck："+ck);
		System.out.println("将登录数据装入login数据模型");
		
		LoginEntity loginData = new LoginEntity();
		loginData.setUname(uname);
		loginData.setUpwd(upwd);
		
		System.out.println("调用数据逻辑模型");
		LoginDaoImp Lp = new LoginDaoImp("blog");
		
		int flag = Lp.check(loginData) ;
		
		// 获取到数据后，调用方法 关闭连接资源
		
		
		if (flag==1) {
			System.out.println("执行到跳转 登录之后的 首页....");
			
			// 生成带有用户名和密码的 Cookie，发往客户端
			Cookie cookie1 = new Cookie("uname",uname);
			Cookie cookie2 = new Cookie("upwd",upwd);
			// 是否记住密码的标志
			Cookie cookie3 = new Cookie("ck",ck);
			cookie1.setPath("/");                        // 保持cookie在客户端存储的位置一致，不然拿不到
			cookie2.setPath("/");
			cookie3.setPath("/");
			cookie1.setMaxAge(10);
			cookie2.setMaxAge(60*10); //记住密码 两天
			cookie3.setMaxAge(10);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			System.out.println("加入cookie了.");
			
			
			// 创建 Session 保持登录状态
			HttpSession session =request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("upwd", upwd);
			session.setMaxInactiveInterval(10*60); // 保持十分钟的登录状态
			
			
//			response.sendRedirect("/Blog_Project/sucess.jsp");
//			request.getRequestDispatcher("index.jsp");
			
			
			
			//session控制页面访问许可
			if(session.getAttribute("uname")!=null) {
			response.sendRedirect("/Blog_Project/index1.jsp");}
			else {
				response.sendRedirect("/Blog_Project/login.jsp");}
			
			
		}
		else {
			response.sendRedirect("/Blog_Project/error.jsp");
			System.out.println("密码错误重新登录页面....");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
