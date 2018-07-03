package com.gjh.interceptor;

import com.gjh.validate.ParseSessionObj;
import com.gjh.validate.UserMsg;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class AuthorityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
//        PrintWriter out = ServletActionContext.getResponse().getWriter();
        HttpSession session = request.getSession();
        /// /amc/doamcaction-list
        String servlet_path = request.getServletPath();

        System.out.println(servlet_path);
        UserMsg userMsg=ParseSessionObj.getUserMsg(session);

        if(userMsg==null)
        {
//            out.println("登陆已失效,请重新登陆");
            return "login_failed";
        }

        boolean is_valid=ParseSessionObj.validate(session, servlet_path);
        if(!is_valid)
        {
//            out.println("你没有该操作的权限");
            return "authority_failed";
        }
        actionInvocation.invoke();
        return "success";
    }
}
