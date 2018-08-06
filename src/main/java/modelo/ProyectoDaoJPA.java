/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import utn.ofa.java.app.rrhh.Empleado;
import utn.ofa.java.apprrhh.dao.ConexionJPA;


/**
 *
 * @author casanchez
 */
public class ProyectoDaoJPA implements ProyectoDao{
    
    private EntityManager em;

    @Override
    public void crear(Proyecto e) {
        this.em = ConexionJPA.get();
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();           
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Proyecto e) {
        this.em = ConexionJPA.get();
        try {
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();           
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Proyecto e) {
        this.em = ConexionJPA.get();
        try {
            em.getTransaction().begin();
            
            Proyecto pry;
            pry = em.getReference(Proyecto.class, e.getId());
            pry.getId();
            em.remove(pry);             
                       
            
            em.getTransaction().commit();           
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }   
    
    @Override
    public Proyecto buscarPorId(Integer id) {
        this.em = ConexionJPA.get();       
        return em.find(Proyecto.class, id);
    } 
    

    @Override
    public List<Proyecto> buscarTodos() {
        this.em = ConexionJPA.get();
        List<Proyecto> resultado = new ArrayList<Proyecto>();
        try {
            em.getTransaction().begin();
            resultado = this.em.createQuery("SELECT p FROM Proyecto p").getResultList();
            em.getTransaction().commit();            
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();     
        } finally {
            em.close();
        }
        return resultado;
    }
    
    
}
