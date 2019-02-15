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
public class BBB implements Serializable{
    //private String userId;
    //private String b1;
    //private String b2;
    //private String b3;
    //private String b4;
    /*private String b5;
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
    
    
    
    public BBB(){}
    public BBB(String[] b){
        
        /*this.b[0]=b1;
        this.b[1]=b2;
        this.b[2]=b3;
        this.b[3]=b4;
        this.b[4]=b5;
        this.b[5]=b6;
        this.b[6]=b7;
        this.b[7]=b8;
        this.b[8]=b9;
        this.b[9]=b10;
        this.b[10]=b11;
        this.b[11]=b12;
        this.b[12]=b13;
        this.b[13]=b14;
        this.b[14]=b15;
        this.b[15]=b16;
        this.b[16]=b17;
        this.b[17]=b18;
        this.b[18]=b19;
        this.b[19]=b20;*/
        this.b=b;
        
    }
    //public String getUserId(){return userId;}
    public String[] getB(){
        /*b[0]=b1;
        b[1]=b2;
        b[2]=b3;
        b[3]=b4;
        b[4]=b5;
        b[5]=b6;
        b[6]=b7;
        b[7]=b8;
        b[8]=b9;
        b[9]=b10;
        b[10]=b11;
        b[11]=b12;
        b[12]=b13;
        b[13]=b14;
        b[14]=b15;
        b[15]=b16;
        b[16]=b17;
        b[17]=b18;
        b[18]=b19;
        b[19]=b20;*/
        
        
        
        return b;}
    
    
    
    
}