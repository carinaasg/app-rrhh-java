/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;




/**
 *
 * @author casanchez
 */
@Entity
public class Proyecto {

    @Id public Integer id;
    public String nombre;
    public String descripcion;
    public Double presupuestoMaximo;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;       
     }          
        
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;        
    }
    
    public Double getpresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public void setpresupuestoMaximo(Double presupuestoMaximo) {
        this.presupuestoMaximo = presupuestoMaximo;
    }    
    
    @Override
    public boolean equals (Object obj) {
        if (obj instanceof Proyecto) {

        Proyecto tmpProyecto = (Proyecto) obj;

            if (this.nombre.equals(tmpProyecto.nombre))  {
                    return true;
            }            
        }
        return true;      
    }
    
    @Override
    public String toString() {
        return "Proyecto (id=" + id + ", nombre=" + nombre + ")"; 
    }
}
