/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.apprrhh.dao;
import utn.ofa.java.app.rrhh.Empleado;
import utn.ofa.java.app.rrhh.Efectivo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import utn.ofa.java.app.rrhh.Contratados;



/**
 *
 * @author casanchez
 */
public class EmpleadoDaoJdbc implements EmpleadoDao{
    private final String INSERT_EMPLEADO = "INSERT INTO EMPLEADOS (NOMBRE, CORREO, CUIL, FECHA_INGRESO, HS_TRABAJADAS, SUELDO_BASICO, COMISIONES, HS_MINIMAS, COSTO_HORA, TIPO_EMPLEADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
    private final String UPDATE_EMPLEADO = "UPDATE EMPLEADOS SET NOMBRE = ?, CORREO = ?, CUIL = ?, FECHA_INGRESO = ?, HS_TRABAJADAS = ?, SUELDO_BASICO = ?, COMISIONES = ?, HS_MINIMAS = ?, COSTO_HORA = ?, TIPO_EMPLEADO = ? WHERE ID = ? ";
    
    private final String DELETE_EMPLEADO = "DELETE FROM EMPLEADOS WHERE ID = ? ";
    
    private final String BUSCAR_ID = "SELECT NOMBRE, CORREO, CUIL, FECHA_INGRESO, HS_TRABAJADAS, SUELDO_BASICO, COMISIONES, HS_MINIMAS, COSTO_HORA, TIPO_EMPLEADO FROM EMPLEADOS WHERE ID = ? "; 
     
    private final String BUSCAR = "SELECT ID, NOMBRE, CORREO, CUIL, FECHA_INGRESO, HS_TRABAJADAS, SUELDO_BASICO, COMISIONES, HS_MINIMAS, COSTO_HORA, TIPO_EMPLEADO FROM EMPLEADOS ";
              
       
    @Override
    public void crear(Empleado e) {
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(INSERT_EMPLEADO)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCorreoElectronico());
            ps.setString(3, e.getCuil());
            ps.setDate(4, new Date(e.getFechaIngreso().getTime()));
            ps.setInt(5, e.getHorasTrabajadas());
            if(e.esEfectivo()) {
                Efectivo empEf = (Efectivo) e;
                ps.setDouble(6, empEf.getsueldoBasico());
                ps.setDouble(7, empEf.getcomisiones());
                ps.setInt(8, empEf.getcantMinHorOblig());                
                ps.setInt(9, 0);
                ps.setInt(10, 1);                
            }
            if(e.esContratado()){
                Contratados c = (Contratados) e;
                ps.setDouble(9, c.getmontoHora());
                ps.setInt(10, 2);
            }
            int filasInsertadas = ps.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        ConexionJDBC.liberarConexion();
    }
    
    @Override
    public void actualizar(Empleado e) {
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(UPDATE_EMPLEADO)) {                     
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCorreoElectronico());
            ps.setString(3, e.getCuil());
            ps.setDate(4, new Date(e.getFechaIngreso().getTime()));
            ps.setInt(5, e.getHorasTrabajadas());
            if(e.esEfectivo()) {
                Efectivo empEf = (Efectivo) e;
                ps.setDouble(6, empEf.getsueldoBasico());
                ps.setDouble(7, empEf.getcomisiones());
                ps.setInt(8, empEf.getcantMinHorOblig());                
                ps.setInt(9, 0);
                ps.setInt(10, 1);                
            }
            if(e.esContratado()){
                Contratados c = (Contratados) e;
                ps.setDouble(9, c.getmontoHora());
                ps.setInt(10, 2);
            }
            ps.setInt(11, e.getId());
            int filasActualizadas = ps.executeUpdate();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        ConexionJDBC.liberarConexion();    
    }
      
    @Override
    public void eliminar(Integer id) {
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(DELETE_EMPLEADO)){
            ps.setInt(1, id);
            int filasEliminadas = ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        ConexionJDBC.liberarConexion();
    }


    @Override
    public Empleado buscarPorId(Integer id) {
        Connection conn = ConexionJDBC.getConexion();
        Empleado eb = null;        
        try(PreparedStatement ps = conn.prepareStatement(BUSCAR_ID)){   
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){ 
                    if (rs.getInt("TIPO_EMPLEADO") == 1){
                        /**Efectivo**/ 
                        eb = new Efectivo();
                        eb.setId(id);
                        eb.setNombre(rs.getString("NOMBRE") );
                        eb.setCorreoElectronico(rs.getString("CORREO"));
                        eb.setCuil(rs.getString("CUIL"));
                        eb.setFechaIngreso(rs.getDate("FECHA_INGRESO"));                        
                        eb.setHorasTrabajadas(rs.getInt("HS_TRABAJADAS"));                        
                    } 
                    if (rs.getInt("TIPO_EMPLEADO") ==  2 ){
                        /**Contratado**/
                        eb = new Contratados();
                        eb.setId(id);
                        eb.setNombre(rs.getString("NOMBRE"));
                        eb.setCuil(rs.getString("CUIL"));
                        eb.setCorreoElectronico(rs.getString("CORREO"));
                        eb.setFechaIngreso(rs.getDate("FECHA_INGRESO"));                        
                        eb.setHorasTrabajadas(rs.getInt("HS_TRABAJADAS")); 
                    }            
          }
       
    }   catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
         
}       catch (SQLException ex) {     
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }     
        ConexionJDBC.liberarConexion();
        return eb;
}        
   
     
    
    @Override
    public List<Empleado> buscarTodos() {       
        Connection conn = ConexionJDBC.getConexion();
        List<Empleado> etodos = new ArrayList<>(1000);
         try(PreparedStatement ps = conn.prepareStatement(BUSCAR)){          
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    if (rs.getInt("TIPO_EMPLEADO") == 1){
                        /**Efectivo**/
                        Efectivo ebuscado = new Efectivo();
                        ebuscado.setId(rs.getInt("ID"));
                        ebuscado.setNombre(rs.getString("NOMBRE"));  
                        etodos.add(ebuscado);
                    }
                    if (rs.getInt("TIPO_EMPLEADO") == 2 ){
                        /**Contratados**/
                        Contratados ebuscado = new Contratados();
                        ebuscado.setId(rs.getInt("ID"));
                        ebuscado.setNombre(rs.getString("NOMBRE"));                        
                        etodos.add(ebuscado);
                    }                     
                }
            }catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    ConexionJDBC.liberarConexion(); 
    return etodos;
}
 
}