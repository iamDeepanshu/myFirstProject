package drivers;

import java.sql.*;

public class MysqlLocalDriver {
    public static Connection connection = null;
    public static Statement statement = null;
    public static String JDBCDriver = "com.mysql.cj.jdbc.Driver";

    public MysqlLocalDriver() {
        if (connection == null) {
            openConnection();
        } else {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            openConnection();
        }
    }

    public static void openConnection() {
        try {
            Class.forName(JDBCDriver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeSelectQuery(String query){
        try{
           ResultSet resultSet= statement.executeQuery(query);
           return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public int  executeInsertQuery(String query){
        try{
            return statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }


}
