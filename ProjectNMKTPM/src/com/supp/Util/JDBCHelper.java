/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.supp.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Duy Quang
 */
public class JDBCHelper {
     private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CONNECTION_URL = "jdbc:sqlserver://localhost:1433;databaseName=ProjectNMKTPM;user=sa;password=12345;encrypt=true;trustServerCertificate=true";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_URL);
        PreparedStatement pstmt;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static int update(String sql, Object... args) {
        try (PreparedStatement stmt = getStmt(sql, args)) {
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

public static ResultSet query(String sql, Object... args) {
    try {
        PreparedStatement stmt = JDBCHelper.getStmt(sql, args);
        ResultSet rs = stmt.executeQuery();
        return rs;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
public static Object value(String sql, Object... args) {
    try {
        ResultSet rs = query(sql, args);
        if (rs.next()) {
            return rs.getObject(1);
        }
        rs.getStatement().getConnection().close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return null;
}
}
