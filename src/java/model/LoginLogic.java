/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsersDAO;

/**
 *
 * @author g16910hm
 */
public class LoginLogic {
    public boolean execute(Login login){
        UsersDAO dao = new UsersDAO();
        Users users=dao.findByLogin(login);
        return users != null;
    }
    
}
