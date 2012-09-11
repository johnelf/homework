package com.database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/9/12
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBOperation {
    private static DBOperation INSTANCE = new DBOperation();
    private Connection conn = null;

    private DBOperation() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forum", "root", "12345");
        } catch (SQLException e) {
            System.out.println("链接数据库发生异常!");
            e.printStackTrace();
        }
    }

    public ArrayList<String> ExecuteQuerySQL(String sql, String field) {
        ArrayList<String> rs = new ArrayList<String>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                rs.add(resultSet.getString(field));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }

    public boolean ExecuteInsertSQL(String sql) {
        try {
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate(sql);

            if (result > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static DBOperation getINSTANCE() {
        return INSTANCE;
    }
}
