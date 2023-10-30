/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.maven_cine;

import javax.swing.JButton;

/**
 *
 * @author SENA
 */
public class cine_adso extends JButton{

    
    int aforo; 
    int sillasOcupadas;
    String tituloPelicula;
    int precioEntrada;
    
    public cine_adso(){
        aforo = 100;
        sillasOcupadas = 0;
        tituloPelicula = "";
        precioEntrada = 5000;      
    }
    
    public void setAforo(int afo){
        aforo = afo;
    }
    
    public void setSillasOcupadas (int ocupacion){
        sillasOcupadas = ocupacion;
    }
    
    public void setTituloPelicula (String peli){
        tituloPelicula = peli;
    }
    
    public void setPrecioEntrada (int entrada){
        precioEntrada = entrada;
    }
 
    public void setSillasLibres (int libres){
        int ocupado; 
        ocupado = aforo - libres;
        sillasOcupadas = ocupado;
    }

    public double getAforo() {
        return aforo;
    }

    public double getSillasOcupadas() {
        return sillasOcupadas;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    //Metodo porcentaje de ocupacion
    public double getPorcentajeOcupacion() {
        return (double) sillasOcupadas / aforo * 100;
    }
    
    //Metodo para saber los ingresos a la sala
    
    public double getIngresosSala() {
        return sillasOcupadas * precioEntrada;
    }
    
    // sillas libres
    public int getSillasLibres(){
        return sillasOcupadas;
    }
    
    public void vaciarSala(){
        sillasOcupadas = 0;
    }
    
    public void boleta(){
        sillasOcupadas++;
    }
    
    
    
}
