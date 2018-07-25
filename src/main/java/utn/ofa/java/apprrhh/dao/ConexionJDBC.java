/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.apprrhh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author casanchez
 */

public class ConexionJDBC {
    private static final String USUARIO = "root";
    private static final String PASSWORD = "carina";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/app-rrhh";
    
    private static Connection _CONEXION;
    
    
    
    public static Connection getConexion() {
        try {
            _CONEXION = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);
            System.out.println("Se conectó a la db");            
         } catch (SQLException e) { 
              System.out.println("Error al conectarse a la db"); 
        }    
        return _CONEXION;
    }
       
    
    public static void liberarConexion() {
        if (_CONEXION != null) {
            try {        
            _CONEXION.close();
            _CONEXION = null;
            System.out.println("Liberó la conexión");            
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión a la db");            
            }
        }
    }    
    
}

