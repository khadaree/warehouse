package com.wms.controller;

import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wms.manager.RegisterManagerImpl;
import com.wms.persister.entity.Register;
import com.wms.persister.entity.User;
import com.wms.util.StringHelper;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    RegisterManagerImpl registerManager;

    @RequestMapping(value = "/saveEntryRegister", method = RequestMethod.POST)
    public String saveEntryRegister(@RequestParam Map<String,String> allParams,Model model, 
                @RequestHeader(value="Cookie") String cookie, HttpSession session){
        User user = SessionHelper.getUser(session, SessionHelper.getJsessionId(cookie));
        if(user != null){
            Register register = new Register();
            registerMapper(allParams, register);
            register.setInTime(Calendar.getInstance().getTimeInMillis());
            register.setStage("MAIN_GATE");
            registerManager.saveRegisterDetails(register);            
            model.addAttribute("message", "Register details saved");
            return "home";
        }else{
            return "login";
        }        
    }

    @RequestMapping(value = "/saveExitRegister", method = RequestMethod.POST)
    public String saveExitRegister(@RequestParam String registerId,Model model, 
                @RequestHeader(value="Cookie") String cookie, HttpSession session){
        User user = SessionHelper.getUser(session, SessionHelper.getJsessionId(cookie));
        if(user != null){
            Register register = registerManager.getRegister(Integer.parseInt(registerId));
            register.setStage("EXIT");
            register.setOutTime(Calendar.getInstance().getTimeInMillis());
            registerManager.updateRegisterDetails(register);
            model.addAttribute("message", "Register details saved");
            return "exitForm";
        }else{
            return "login";
        }        
    }
    
    private void registerMapper(Map<String,String> allParams, Register register){
        register.setTruckNo(allParams.get("truckNo"));
        register.setWayBillNo(allParams.get("wayBillNo"));
        register.setMillName(allParams.get("millerName"));
        register.setMillPlace(allParams.get("millerPlace"));
        register.setVeriety(allParams.get("veriety"));
        register.setBags(StringHelper.stringToInt(allParams.get("bags")));        
    }
}
