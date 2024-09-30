package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercicio3 {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres"; // substitua com seu usuário do PostgreSQL
    String password = "postgres"; // substitua com sua senha do PostgreSQL


    public void app(){
        try (Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement()) {
            String query = "SELECT nome, preco FROM produtos";
            ResultSet rs = stmt.executeQuery(query);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
