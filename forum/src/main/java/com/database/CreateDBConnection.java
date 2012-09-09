package com.database;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/9/12
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateDBConnection {
    private static CreateDBConnection INSTANCE = new CreateDBConnection();

    private Connection conn = null;

    private CreateDBConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        } catch (SQLException e) {
            System.out.println("链接数据库发生异常!");
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void ExecuteSQL(String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(username + "" + password);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static CreateDBConnection getINSTANCE() {
        return INSTANCE;
    }
}
