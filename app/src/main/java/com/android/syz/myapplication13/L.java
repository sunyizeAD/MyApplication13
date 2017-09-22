package com.android.syz.myapplication13;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by syz on 2017/9/22 .
 */

public class L {
    public static String mtags ="syz";
    public static boolean misDebug = true;
    public static void init(String tags, boolean isDebug){
        mtags = tags;
        misDebug = isDebug;
    }
    public static void e(String tags,String msg,Object ...params){
        if (!misDebug)
        {
            return;
        }
        StackTraceElement tagetStackTrace = getTagetStackTrace();
        String tag = getTag(tags);
        Log.e(tag,"("+tagetStackTrace.getFileName()+":"+tagetStackTrace.getLineNumber()+")");
        Log.e(tag,String.format(msg,params));
    }

    private static String getTag(String tag) {
        if (!TextUtils.isEmpty(tag))
        {
            return tag;
        }
        return mtags;
    }
    public static StackTraceElement getTagetStackTrace(){
        StackTraceElement stet=null;
        boolean shouldTrace = false;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement ste :stackTrace)
        {
            boolean isLogClass = ste.getClassName().equals(L.class.getName());
            if (shouldTrace && !isLogClass)
            {
                stet= ste;
            }
            shouldTrace = isLogClass;
        }
        return stet;

    }
    public static void e(String msg,Object ...params){
        e(null,msg,params);

    }
}
