/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.rest;

import adcap.entity.User;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Karsten
 */
public class userRestClient {
    
    
    private static  User getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:57225/AdCap"+"/searchUser/1", User.class);
        System.out.println(user.getPassword());
        return user;
    }
        public static void main(String args[]){
        getUser();
    }
}
