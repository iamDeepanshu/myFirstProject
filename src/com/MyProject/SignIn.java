package com.MyProject;

import drivers.MysqlLocalDriver;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignIn extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String query=String.format("select * from myproject.userdata where mobno= %s and password='%s'; ",req.getParameter("mobno"),req.getParameter("password"));
        MysqlLocalDriver mysqlLocalDriver= new MysqlLocalDriver();
        ResultSet rs=mysqlLocalDriver.executeSelectQuery(query);
        if(rs==null){
            res.getWriter().println("invalid  mob no or password");
        }
        else{
            res.getWriter().println("login success full");

        }
    }

}