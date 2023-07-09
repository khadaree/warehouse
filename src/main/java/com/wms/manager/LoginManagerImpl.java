/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wms.manager;

import com.wms.persister.UserPersister;
import com.wms.persister.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khada
 */
@Service
public class LoginManagerImpl implements LoginManager{
    @Autowired
    UserPersister UserPersister;

    @Override
    public User validateLogin(String userName, String password) {
        Iterable<User> users = UserPersister.findAll();
        for(User user: users){
            String name = user.getUserName();
            if(name != null && name.equals(userName)){
                String pwd = user.getPassword();
                if(pwd != null && pwd.equals(password))
                    return user;
            }
        }        
        return null;
    }
    
}
