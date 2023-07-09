/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wms.manager;

import com.wms.persister.entity.User;

public interface LoginManager {
    public User validateLogin(String userName, String password);
}
