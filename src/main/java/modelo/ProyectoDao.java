/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import utn.ofa.java.app.rrhh.Empleado;

/**
 *
 * @author casanchez
 */
public interface ProyectoDao {
    public void crear(Proyecto e);
    public void actualizar(Proyecto e);
    public void eliminar(Proyecto e);
    public Proyecto buscarPorId(Integer id);
    public List<Proyecto> buscarTodos();  
}

