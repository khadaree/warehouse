package com.wms.controller;

import java.util.HashMap;
import java.util.Map;

import com.wms.persister.entity.User;

import jakarta.servlet.http.HttpSession;

public class SessionHelper {
    public static void addUser(HttpSession session, User user){
        
        Map<String, User> userMap = (Map<String, User>) session.getAttribute("userMap");
        if(userMap == null)
            userMap = new HashMap<>();
        userMap.put(session.getId(), user);
        session.setAttribute("userMap", userMap);
    }

    public static User getUser(HttpSession session, String sessionId){
        Map<String, User> userMap = (Map<String, User>) session.getAttribute("userMap");
        if(userMap != null)
            return userMap.get(sessionId);
        else
            return null;
    }

    public static String getJsessionId(String cookies){
        String result = "";
        if(cookies != null){
            String[] cookieArr = cookies.split(";");
            for(String cookie: cookieArr){
                if(cookie.contains("JSESSIONID=")){
                    result = cookie.replace("JSESSIONID=", "");
                    result = result.trim();
                }
            }
        }
        return result;
    }
}
