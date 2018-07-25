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
public class CrearEmpleadoTest {

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
    /**Testea el INSERT de empleados Efectivos y la búsqueda por ID**/
    public void CrearTest() {
       System.out.println("Crear Empleado ID 1 y 2");
       System.out.println("Busca Empleado ID 1");
       EmpleadoDaoJdbc empleadoDaoJdbc = new EmpleadoDaoJdbc();
       Efectivo empleado = new Efectivo();   
       java.util.Date fechaActual = new java.util.Date();              
       empleado.setNombre("Pepe");
       empleado.setCorreoElectronico("pepe@hotmail.com");
       empleado.setCuil("20239360484");       
       empleado.setFechaIngreso(fechaActual);
       empleado.setHorasTrabajadas(40);
       empleado.setcantMinHorOblig(40);
       empleado.setcomisiones(2000.0);
       empleado.setsueldoBasico(30000.0);   
       empleadoDaoJdbc.crear(empleado);
       
       Efectivo empleado2 = new Efectivo();          
       empleado2.setNombre("Juana");
       empleado2.setCorreoElectronico("juana@hotmail.com");
       empleado2.setCuil("27232334229");       
       empleado2.setFechaIngreso(fechaActual);
       empleado2.setHorasTrabajadas(40);
       empleado2.setcantMinHorOblig(40);
       empleado2.setcomisiones(2000.0);
       empleado2.setsueldoBasico(30000.0);   
       empleadoDaoJdbc.crear(empleado2);
       
                   
       Empleado eCreado =  empleadoDaoJdbc.buscarPorId(1);
       assertEquals(empleado.getNombre(), eCreado.getNombre());      
       
   }    
       
}
