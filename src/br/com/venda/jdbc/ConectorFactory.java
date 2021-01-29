/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author KDS
 */
public class ConectorFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/bdvendas","root","");
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
}
