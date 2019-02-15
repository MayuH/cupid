/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author g16910hm
 */
public class BBBs implements Serializable{
    private String userId;
    /*private String b1;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    private String b6;
    private String b7;
    private String b8;
    private String b9;
    private String b10;
    private String b11;
    private String b12;
    private String b13;
    private String b14;
    private String b15;
    private String b16;
    private String b17;
    private String b18;
    private String b19;
    private String b20;*/
    private String[] b=new String[20];
    
    
    
    public BBBs(){}
    public BBBs(String userId,String[] b){
        this.userId=userId;
        
        this.b=b;
        
    }
    //public String getUserId(){return userId;}
    public String[] getB(){
        
        return b;}
    public String getUserId(){return userId;}
    
    
    
}
