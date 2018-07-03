package com.gjh.utils;

public class Format {
    public static String format(String original)
    {
        int index=original.indexOf(".");
        if(index!=-1)
        {
            return  original.substring(0, index);
        }else{
            return  original;
        }
    }
}
