/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class LoginDao 
{
    public boolean isValidUser(String user,String pass) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection  cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PROJECT", "postgres","happy");
        PreparedStatement st = cn.prepareStatement("SELECT * FROM user_details where user_name = ?"
                + " and password = ?");
        st.setString(1,user);
        st.setString(2, pass);
       
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next())
        {
            return true;
            
        }
        return false;
        
    } 
}
