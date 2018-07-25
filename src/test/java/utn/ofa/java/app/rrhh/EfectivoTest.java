/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author casanchez
 */
public class EfectivoTest {
    
    public EfectivoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testSomeMethod() {
    }
    
    /**Test of salario method, of class Efectivo.**/
    @Test
    public void testSalarioSinHorasExtras() {
        System.out.println("Salario");
        Efectivo empleado = new Efectivo();
        empleado.setHorasTrabajadas(42);
        empleado.setcantMinHorOblig(40);
        empleado.setcomisiones(2000.0);
        empleado.setsueldoBasico(30000.0);
        Double expResult = 30000.0+2000.0+3000.0;
        Double result = empleado.salario();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSalario2HorasExtras() {
        System.out.println("Salario");
        Efectivo empleado = new Efectivo();
        empleado.setHorasTrabajadas(42);
        empleado.setcantMinHorOblig(40);
        empleado.setcomisiones(2000.0);
        empleado.setsueldoBasico(30000.0);
        Double expResult = 30000.0+2000.0+3000.0;
        Double result = empleado.salario();
        assertEquals(expResult, result);               
    }
}
