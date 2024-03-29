package com.wms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.wms.manager.LoginManagerImpl;
import com.wms.manager.NextGenKeyHandler;
import com.wms.manager.RegisterManagerImpl;
import com.wms.persister.entity.Register;
import com.wms.persister.entity.User;

//testing git commit
import jakarta.servlet.http.HttpSession;

//import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginManagerImpl loginManager;

    @Autowired
    NextGenKeyHandler nextGenKeyHandler;

    @Autowired
    RegisterManagerImpl registerManager;
    

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        //return "forward:/login.html";
        return "login";
    }

    @RequestMapping(value = "/homePage")
    public String  homePage(@RequestHeader(value="Cookie") String cookie, HttpSession session) {        
        User user = SessionHelper.getUser(session, SessionHelper.getJsessionId(cookie));
        if(user == null){            
            return "login";
        }else{                        
            return "home";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateLogin(@RequestParam Map<String,String> allParams,Model model, 
                HttpSession session) {                    
        User user = loginManager.validateLogin(allParams.get("name"), allParams.get("password"));        
        if(user == null){
            model.addAttribute("message", "Invalid user name/password");
            return "login";
        }else{            
            //String sessionId = SessionHelper.getJsessionId(cookie);            
            SessionHelper.addUser(session, user);
            System.out.println( user.getRole());
            return "home";
        }
        
    }

    @RequestMapping(value = "/entryForm", method = RequestMethod.GET)
    public String showEntryForm(@RequestHeader(value="Cookie") String cookie, HttpSession session) {                    
        User user = SessionHelper.getUser(session, SessionHelper.getJsessionId(cookie));
        if(user == null){            
            return "login";
        }else{                        
            return "entryForm";
        }
    }

    @RequestMapping(value = "/exitForm", method = RequestMethod.GET)
    public String showExitForm(@RequestHeader(value="Cookie") String cookie, HttpSession session) {                    
        User user = SessionHelper.getUser(session, SessionHelper.getJsessionId(cookie));
        if(user == null){            
            return "login";
        }else{                        
            return "exitForm";
        }
    }

    // private String getRolePage(User user){
    //     if("admin".equals(user.getRole())){
    //         return "admin";
    //     }if("watchman".equals(user.getRole())){
    //         return "entryForm";
    //     }
    //     return "welcome";
    // }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        Register register = registerManager.getRegister(106);        
        Gson gson = new Gson();
        String json = gson.toJson(register);
        return "home";
    }
}
