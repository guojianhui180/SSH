package com.gjh.validate;

import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.http.HttpSession;

public class ParseSessionObj {
    public static UserMsg getUserMsg(HttpSession sesson)
    {
        UserMsg userMsg=new UserMsg();
        String session_user_msg=(String) sesson.getAttribute("php_session_user");
        try {
            if(session_user_msg!=null){
                JSONArray array=new JSONArray(session_user_msg);
                userMsg.setUid(array.getInt(0));
                userMsg.setName(array.getString(1));
                userMsg.setLan(array.getString(2));
                userMsg.setIslogin(array.getInt(3));
                return userMsg;
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validate(HttpSession sesson,String servlet_path) {
        // TODO Auto-generated method stub
        String session_authority=(String) sesson.getAttribute("php_session_authority");
        if(session_authority==null)
        {
            System.out.println("登陆已失效或未获得任何权限");
            return false;
        }else {
            try {
                JSONArray array;
                array = new JSONArray(session_authority);
                int length=array.length();
                for(int i=0;i<length;i++)
                {
                    String authority_path=array.getString(i);
                    if(authority_path.trim().equals(servlet_path))
                    {
                        return true;
                    }
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return false;
    }
}
