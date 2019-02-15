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
public class PostUsersLogic {
    public void execute(User user){
        UsersDAO dao= new UsersDAO();
        dao.create(user);
    }
    
}
