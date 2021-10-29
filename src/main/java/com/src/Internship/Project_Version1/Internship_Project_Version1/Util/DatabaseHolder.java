package com.src.Internship.Project_Version1.Internship_Project_Version1.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHolder {
    private final static String URL = "jdbc:postgresql://localhost:5432/UserRegistrationAPI"; //PostgreSQL接続情報（タイプ：URL）
    private final static String USER = "postgres"; //PostgreSQL接続情報（タイプ：PostgreSQLログインユーザー名）
    private final static String PASSWORD = "123456"; //PostgreSQL接続情報（タイプ：PostgreSQLログインパスワード）
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
