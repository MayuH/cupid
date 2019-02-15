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
public class Details implements Serializable{
    private String userId;
    private String age;
    private String hobby;
    private String job;
    private String sex;
    private String type;
    private String speech;
    
    public Details(){}
    public Details(String userId,String age,String hobby,String job,String sex,String type,String speech){
        this.userId=userId;
        this.age=age;
        this.hobby=hobby;
        this.job=job;
        this.sex=sex;
        this.type=type;
        this.speech=speech;
    }
    public String getUserId(){return userId;}
    public String getAge(){return age;}
    public String getHobby(){return hobby;}
    public String getJob(){return job;}
    public String getSex(){return sex;}
    public String getType(){return type;}
    public String getSpeech(){return speech;}
    
    
    
}
