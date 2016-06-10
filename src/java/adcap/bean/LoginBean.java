/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.bean;

/**
 *
 * @author Karsten
 */
public class LoginBean {
    private String username;
    private String password;

    public String getPassword()
    {
        return this.password;
    }

    public String getUsername()
    {
        
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }   
}
