/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class DBConnection {

    static String url = "jdbc:mysql://localhost:3306/dbpacientes";
    static String user = "root";
    static String password = "";
    static String driver = "com.mysql.jdbc.Driver";
    static Connection connection = null;

    public static Connection getConnection() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("conectado");

        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }



        return connection;
    }


}
