/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.apprrhh.dao;

import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import utn.ofa.java.app.rrhh.Efectivo;
import utn.ofa.java.app.rrhh.Empleado;

/**
 *
 * @author casanchez
 */
public class BuscarTodosTest {
    
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
    public void BuscarTest () {
        System.out.println("Listar todos los empleados");
        EmpleadoDaoJdbc empleadoDaoJdbc;
        empleadoDaoJdbc = new EmpleadoDaoJdbc();
        List<Empleado> ebuscados = empleadoDaoJdbc.buscarTodos();
        int emp;
        emp = 1;
        for (Empleado empleado1: ebuscados){
            System.out.println(empleado1.getId() + empleado1.getNombre());
            emp = emp +1;
        }
        assertTrue(emp > 1);             
}
    
}
 