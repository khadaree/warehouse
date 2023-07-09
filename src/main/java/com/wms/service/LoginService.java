package com.wms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wms.controller.SessionHelper;
import com.wms.manager.LoginManagerImpl;
import com.wms.manager.RegisterManagerImpl;
import com.wms.persister.entity.Register;
import com.wms.persister.entity.User;

import jakarta.servlet.http.HttpSession;




@RestController
public class LoginService {
    @Autowired
    LoginManagerImpl loginManager;

    @Autowired
    RegisterManagerImpl registerManager;

    @RequestMapping(value = "/getRegisterList", method = RequestMethod.POST)
    public String getRegisterList(@RequestParam String stage, 
                @RequestHeader(value="Cookie") String cookie, HttpSession session) {        
        User user = SessionHelper.getUser(session, SessionHelper.getJsessionId(cookie));
        if(user != null){
            List<Register> registers = registerManager.getRegisterListByStage(stage);        
            Gson gson = new Gson();
            String json = gson.toJson(registers);
            return json;
        }else{
            return "failure";
        }        
    }

    @RequestMapping(value = "/getRegisterDetails", method = RequestMethod.POST)
    public String getRegisterDetails(@RequestParam String id, 
                @RequestHeader(value="Cookie") String cookie, HttpSession session) {        
        User user = SessionHelper.getUser(session, SessionHelper.getJsessionId(cookie));
        if(user != null){
            Register register = registerManager.getRegister(Integer.parseInt(id));        
            Gson gson = new Gson();
            String json = gson.toJson(register);
            return json;
        }else{
            return "failure";
        }        
    }
}
