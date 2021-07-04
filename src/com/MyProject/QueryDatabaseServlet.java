package com.MyProject;

import drivers.MysqlLocalDriver;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDatabaseServlet extends HttpServlet {
    public void doPost(HttpServletRequest requestObject, HttpServletResponse responseObject){
        MysqlLocalDriver mysqlLocalDriver=new MysqlLocalDriver();
        try {

            String query = String.format("select * from myProject.UserData where name = '" + requestObject.getParameter("inputFromUser") + "';");
            ResultSet resultSet = mysqlLocalDriver.executeSelectQuery(query);
            responseObject.getWriter().println("<html><body bgcolor = yellow><label>UserName     </label><label>UserId </label>");
            while (resultSet.next()) {
                responseObject.getWriter().println("<br>");
                responseObject.getWriter().println(resultSet.getString("name"));
                responseObject.getWriter().println(resultSet.getString("userId"));
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
//insert into userdata(username,mobno,city,pincode,password) values('Ravi',999234,'hisar',125001,9991212)
}
