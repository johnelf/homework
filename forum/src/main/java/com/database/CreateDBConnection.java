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
public class CreateDBConnection {
    private static CreateDBConnection INSTANCE = new CreateDBConnection();
    private ArrayList<String> rs = new ArrayList<String>();

    private Connection conn = null;

    private CreateDBConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forun", "root", "12345");
        } catch (SQLException e) {
            System.out.println("链接数据库发生异常!");
            e.printStackTrace();
        }
    }

    public void CutConnection() throws SQLException {
        try {
            if (conn != null) ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public ArrayList<String> ExecuteQuerySQL(String sql, String field) {
        rs.clear();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                rs.add(resultSet.getString(field));
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
        return rs;
    }

    public boolean ExecuteInsertSQL(String sql, String value) {
        try{
            Statement statement=conn.createStatement();
            int result = statement.executeUpdate(sql + value);

            if(result>0)
                return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static CreateDBConnection getINSTANCE() {
        return INSTANCE;
    }
}
