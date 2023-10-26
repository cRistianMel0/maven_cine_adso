/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author crife
 */
public class modeloPeliculas {

    String tituloPelicula;
    int costoEntrada;
    String autor;
    String genero;
    Date fechaInicio;
    Date fechaFin;
    String imagen;

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public int getCostoEntrada() {
        return costoEntrada;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public void setCostoEntrada(int costoEntrada) {
        this.costoEntrada = costoEntrada;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
