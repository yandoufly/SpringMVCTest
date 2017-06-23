package com.yjy.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjy.javabean.UserBean;

public class Model2Servlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	    throws ServletException, IOException {
        doPost(req, resp);//涓轰簡绠�崟锛岀洿鎺ュ鎵樼粰doPost杩涜澶勭悊
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
        String submitFlag = req.getParameter("submitFlag");
        if("toLogin".equals(submitFlag)) {
            toLogin(req, resp);
            return;
        } else if("login".equals(submitFlag)) {
            login(req, resp);
            return;
        }
        toLogin(req, resp); //榛樿鍒扮櫥褰曢〉闈�
    }
    private void toLogin(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
    	//姝ゅ鍜孞SP瑙嗗浘鎶�湳绱у瘑鑰﹀悎锛屾洿鎹㈠叾浠栬鍥炬妧鏈嚑涔庝笉鍙兘
        req.getRequestDispatcher("/mvc/login.jsp").forward(req, resp); 
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) 
        throws IOException, ServletException {
    	//1鏀堕泦鍙傛暟
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	//2楠岃瘉骞跺皝瑁呭弬鏁�閲嶅鐨勬楠�
    	UserBean user = new UserBean();
    	user.setUsername(username);
    	user.setPassword(password);
    	//3璋冪敤javabean瀵硅薄锛堜笟鍔℃柟娉曪級
    	if(user.login()) {
    		//4鏍规嵁杩斿洖鍊奸�鎷╀笅涓�釜椤甸潰
    		resp.sendRedirect(req.getContextPath() + "mvc/success.jsp");
    	} else {
    		//鐧婚檰澶辫触鍐嶈繑鍥炵櫥闄嗛〉闈�骞舵樉绀轰笂娆¤緭鍏ョ殑鐢ㄦ埛鍚�
    		
    		//灏嗚鍥捐鏄剧ず鐨勬ā鍨嬫暟鎹斁鍦ㄨ姹傞噷浼犻�缁欒鍥撅紝瑙嗗浘鍐嶆潵灞曠ず
    		//姝ゅ涔熷彲浠ョ湅鍑哄拰Servlet API绱у瘑鑰﹀悎锛屾洿鎹㈣鍥炬妧鏈篃闇�閲嶆柊璁剧疆杩欎簺鏁版嵁
    		req.setAttribute("user", user);
    		toLogin(req, resp);
    		return;
    	}
    }
}