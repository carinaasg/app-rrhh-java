/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.apprrhh.dao;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import utn.ofa.java.app.rrhh.Efectivo;
import utn.ofa.java.app.rrhh.Empleado;

/**
 *
 * @author casanchez
 */
public class ActualizarEmpleadoTest {
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testSomeMethod() {
    }
    
    @Test   
    public void ActualizarTest () {
        System.out.println("Actualizar Empleado ID 2");
        EmpleadoDaoJdbc empleadoDaoJdbc;
        empleadoDaoJdbc = new EmpleadoDaoJdbc();
        Efectivo empleado = new Efectivo();         
        empleado.setId(2);
        empleado.setNombre("DATO ACTUALIZADO");
        empleado.setCorreoElectronico("NUEVO");
        empleado.setCuil("24232334229");
        empleado.setFechaIngreso(new java.util.Date());
        empleado.setHorasTrabajadas(45);        
        empleado.setcantMinHorOblig(20);
        empleado.setcomisiones(1000.0);
        empleado.setsueldoBasico(5000.0);
        empleadoDaoJdbc.actualizar(empleado);            
        Empleado eactualizado = empleadoDaoJdbc.buscarPorId(2);        
        assertEquals(empleado.getNombre(), eactualizado.getNombre());        
}
    
}
 

