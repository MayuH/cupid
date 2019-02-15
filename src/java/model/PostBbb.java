/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BbbDAO;

/**
 *
 * @author g16910hm
 */
public class PostBbb {
    public void execute(BBB bbb){
        BbbDAO dao= new BbbDAO();
        dao.create(bbb);
    }
    
}
