package com.distribuidas.SensorTDD4IOTS.tddt4iots.dto;

import java.util.Date;

public class FrecuenciaCardiacaDTO {
    private String id;
    private String idrt;
    private String idus;
    private Integer cantpulsaciones;
    private String fechademedicion;
    private String riesgoDeInfarto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getIdus() {
        return idus;
    }

    public void setIdus(String idus) {
        this.idus = idus;
    }
    public String getIdrt() {
        return idrt;
    }

    public void setIdrt(String idrt) {
        this.idrt = idrt;
    }

    public Integer getCantpulsaciones() {
        return cantpulsaciones;
    }

    public void setCantpulsaciones(Integer cantpulsaciones) {
        this.cantpulsaciones = cantpulsaciones;
    }

    public String getFechademedicion() {
        return fechademedicion;
    }

    public void setFechademedicion(String fechaDeMedicion) {
        this.fechademedicion = fechaDeMedicion;
    }

    public String getRiesgoDeInfarto() {
        return riesgoDeInfarto;
    }

    public void setRiesgoDeInfarto(String riesgodeinfarto) {
        this.riesgoDeInfarto = riesgodeinfarto;
    }

}
