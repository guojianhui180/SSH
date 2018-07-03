package com.gjh.action;

import com.gjh.utils.CharSetUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public class AuthorityAction  extends ActionSupport implements SessionAware,ParameterAware {
    private Map<String, Object> session;
    private Map<String, String[]> parameters;
    private InputStream inputStream=new ByteArrayInputStream("success".getBytes());;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String saveUserMsg()
    {
        String php_session_unicode = parameters.get("php_user")[0];
        String php_session_decode = CharSetUtils.decodeUnicode(php_session_unicode);
        String php_session = php_session_decode.replace("\\", "");
        session.put("php_session_user", php_session);
        System.out.println("php_session---->"+php_session);
        return "saveuser";
    }
    public String saveAuthority()
    {
        String php_session_unicode=parameters.get("php_session")[0];
        String php_session_decode=CharSetUtils.decodeUnicode(php_session_unicode);
        String php_session=php_session_decode.replace("\\", "");
        session.put("php_session_authority", php_session);
        System.out.println("php_session_authority---->"+php_session);
//        inputStream=new ByteArrayInputStream("success".getBytes());
        return "saveauthority";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    @Override
    public void setParameters(Map<String, String[]> parameters) {
        this.parameters=parameters;
    }
}
