/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g16910hm
 */
import dao.DetailDAO;
import dao.UsersDAO;

/**
 *
 * @author g16910hm
 */
public class PostDetail {
    public void execute(Detail detail){
        DetailDAO dao= new DetailDAO();
        dao.create(detail);
    }
    
}