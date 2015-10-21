package com.essayvote;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class checkSubscribed extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=utf-8"); 
		String openid = request.getParameter("openid");
		PrintWriter out = response.getWriter();
		try {
			voteDB v = new voteDB();
			boolean issubscribed = v.issubscribed(openid);
			if (!issubscribed) {
				out.println("{\"state\":\"0\"}");  //鍙互鎶曠エ
			} else {
				out.println("{\"state\":\"1\"}");	//宸叉姇绁�
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
