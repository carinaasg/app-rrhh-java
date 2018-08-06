/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import modelo.Proyecto;
import static org.junit.Assert.assertNull;


/**
 *
 * @author casanchez
 */
public class ProyectoTest {
    ProyectoDao proyectoDao;
    public ProyectoTest(){        
    }
    @Before
    public void setUp() {
        proyectoDao = new ProyectoDaoJPA();        
    }
    
    @Test
    public void testCrearProyecto(){
        System.out.println("Crea Proyecto ID 1");
        List<Proyecto> lista = proyectoDao.buscarTodos();
        int proyectos = lista.size();
        Proyecto pry = new Proyecto();
        pry.setId(1);
        pry.setNombre("Proyecto");
        pry.setDescripcion("Descripcion Proyecto");
        pry.setpresupuestoMaximo(999.0);
        proyectoDao.crear(pry);
        lista = proyectoDao.buscarTodos();
        int proyectosMas1 = lista.size();
        assertEquals(proyectos+1, proyectosMas1);        
    }   
    
    @Test   
    public void testModificarProyecto() {
        System.out.println("Actualiza Proyecto ID 1");
        Proyecto pry = new Proyecto();         
        pry.setId(1);
        pry.setNombre("DATO ACTUALIZADO");
        pry.setDescripcion("Descripcion Actualizada");
        pry.setpresupuestoMaximo(100.0);
        proyectoDao.actualizar(pry);
        Proyecto pactualizado;
        pactualizado = proyectoDao.buscarPorId(1);
        assertEquals(pry.getNombre(), pactualizado.getNombre());        
    }
    
    @Test
    public void testBuscarProyecto() {
        System.out.println("Busca Proyecto ID 1");
        Proyecto pry = proyectoDao.buscarPorId(1);           
        assertEquals(pry.getNombre(), "DATO ACTUALIZADO");      
    }    
    
    @Test   
    public void testEliminar () {
        System.out.println("Elimina Proyecto ID 1");    
        Proyecto pry = new Proyecto();
        pry.setId(1);             
        proyectoDao.eliminar(pry);
        Proyecto pryborrado = proyectoDao.buscarPorId(1);
        assertNull(pryborrado);
    }
     
       
}
