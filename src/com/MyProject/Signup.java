package com.MyProject;

import drivers.MysqlLocalDriver;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Signup extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String query=String.format(  "insert into myProject.userdata(username,mobno,city,pincode,password) values('%s',%s,'%s',%s,'%s');",req.getParameter("username"),req.getParameter("mobno"),req.getParameter("city"),req.getParameter("pincode"),req.getParameter("password"));
        MysqlLocalDriver mysqlLocalDriver=new MysqlLocalDriver();
        int a=mysqlLocalDriver.executeInsertQuery(query);
        if(a==1){
            res.getWriter().println("SignUp success full user Use Mobile as username and Password to login ");
        }
        else{
            res.getWriter().println("User already exist please Sign Up with other credentials");
        }

    }

}
