/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterDAO;
import java.util.List;

/**
 *
 * @author g16910hm
 */
public class GetMutterListLogic {
    public List<Mutter> execute(){
        MutterDAO dao = new MutterDAO();
        List<Mutter> mutterList = dao.findAll();
        return mutterList;
    }
}
