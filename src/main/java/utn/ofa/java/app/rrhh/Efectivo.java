/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ofa.java.app.rrhh;

import java.util.Date;

/**
 *
 * @author casanchez
 */
public class Efectivo extends Empleado {
    private double sueldoBasico;
    private double comisiones;
    private Integer cantMinHorOblig;
    
    public double getsueldoBasico() {
        return sueldoBasico;
    }

    public void setsueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getcomisiones() {
        return comisiones;
    }

    public void setcomisiones(double comisiones) {
        this.comisiones = comisiones;
    }

    public Integer getcantMinHorOblig() {
        return cantMinHorOblig;
    }

    public void setcantMinHorOblig(Integer cantMinHorOblig) {
        this.cantMinHorOblig = cantMinHorOblig;
    }
    
    @Override
    public Double salario() {
        Double horaExtras = 0.0;
        if(horasTrabajadas > cantMinHorOblig){
            horaExtras = (horasTrabajadas - cantMinHorOblig) * (sueldoBasico/20);
        }
        return sueldoBasico + comisiones + horaExtras;
    }
    
    @Override
    public Boolean esEfectivo(){
        return true;
    }
    
    @Override
    public Boolean esContratado(){
        return false;
    }
    
}
