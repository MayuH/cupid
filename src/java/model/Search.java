/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g16910hm
 */
public class Search implements Serializable{
    private int[] a3=new int[1000];
    private List<Details> detailList=new ArrayList<Details>();
    private String[] id=new String[1000];
    
    public Search(){}
    public Search(String[] id,int[] a3,List<Details> detailList){
        this.id=id;
        this.a3=a3;
        this.detailList=detailList;
        
    }
    public String[] getId(){return id;}
    public int[] getA(){return a3;}
    public List<Details> getListD(){return detailList;}
    
    
    
    
}
