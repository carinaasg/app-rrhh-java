/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh;

/**
 *
 * @author casanchez
 */
public class Contratados extends Empleado {
    private double montoHora;
    
    public double getmontoHora() {
        return montoHora;
    }

    public void setmontoHora(double montoHora) {
        this.montoHora = montoHora;
    }

    @Override
    public Double salario() {            
        
        return horasTrabajadas * montoHora;                
    }
    
    @Override    
    public Boolean esContratado(){
        return true;
    }

    @Override
    public Boolean esEfectivo() {
        return false;
    }
    
}