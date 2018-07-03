package com.gjh.validate;

public class UserMsg {
    public UserMsg() {
        // TODO Auto-generated constructor stub
    }


    public UserMsg(int uid, String name, String lan, int islogin) {
        super();
        this.uid = uid;
        this.name = name;
        this.lan = lan;
        this.islogin = islogin;
    }


    private int uid;
    private String name;
    private String lan;
    private int islogin;

    public int getUid() {
        return uid;
    }


    public void setUid(int uid) {
        this.uid = uid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLan() {
        return lan;
    }


    public void setLan(String lan) {
        this.lan = lan;
    }


    public int getIslogin() {
        return islogin;
    }


    public void setIslogin(int islogin) {
        this.islogin = islogin;
    }


    @Override
    public String toString() {
        return "UserMsg [uid=" + uid + ", name=" + name + ", lan=" + lan
                + ", islogin=" + islogin + "]";
    }


}
