package com.germany.agenda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


public class NotaItem implements Serializable {
 enum Tipo{
     URGENTE,
     IMPORTANTE,
     NORMAL
    }
    private int imageResource;
    private String actividad;
    private Calendar fecha;
    private Tipo tipoActividad;


    public NotaItem(int imageResource, String actividad, Calendar fecha, Tipo tipoActividad) {
        this.imageResource = imageResource;
        this.actividad = actividad;
        this.fecha = fecha;
        this.tipoActividad = tipoActividad;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Tipo getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(Tipo tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    @Override
    public String toString() {
        return "NotaItem{" +
                "imageResource=" + imageResource +
                ", actividad='" + actividad + '\'' +
                ", fecha=" + fecha +
                ", tipoActividad='" + tipoActividad + '\'' +
                '}';
    }

    public  String getfechaString(){
        int dia = fecha.get(Calendar.DAY_OF_MONTH) ;
        int mes = fecha.get(Calendar.MONTH);
        int anio = fecha.get(Calendar.YEAR);
        String obtenerFecha = dia+"-"+mes+"-"+anio;
        return   obtenerFecha;
    }
}
