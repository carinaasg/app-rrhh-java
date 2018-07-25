/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.apprrhh.dao;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import utn.ofa.java.app.rrhh.Efectivo;
import utn.ofa.java.app.rrhh.Empleado;

/**
 *
 * @author casanchez
 */
public class EliminarEmpleadoTest {
    
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
    public void EliminarTest () {
        System.out.println("Eliminar Empleado id 1");
        EmpleadoDaoJdbc empleadoDaoJdbc;
        empleadoDaoJdbc = new EmpleadoDaoJdbc();
        empleadoDaoJdbc.eliminar(1);      
        Empleado eborrado = empleadoDaoJdbc.buscarPorId(1);
        assertNull(eborrado);
}
    
}
 

