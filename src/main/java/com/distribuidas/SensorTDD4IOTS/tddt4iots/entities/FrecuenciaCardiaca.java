package com.distribuidas.SensorTDD4IOTS.tddt4iots.entities;

//import com.app.tddt4iots.enums.*;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
 import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

 @Entity
 @Table(name = "frecuenciacardiaca")
 @Data
 @NoArgsConstructor
 public class FrecuenciaCardiaca {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private String id;

     @Column(name = "idrt", nullable = false, unique = false)
     private String idrt;
     @Column(name = "idus", nullable = false, unique = false)
     private String idus;
    @Column(name = "cantpulsaciones", nullable = false, unique = false) 
    private Integer cantpulsaciones;
 
    @Column(name = "fechademedicion", nullable = false, unique = false)
    private String fechademedicion;

    @Column(name = "riesgoDeInfarto", nullable = false, unique = false, length = 30)
    private String riesgoDeInfarto;


     public FrecuenciaCardiaca(String idrt,int cantpulsaciones, String fechademedicion,String riesgo) {
         this.idrt = idrt;
         this.cantpulsaciones = cantpulsaciones;
         this.fechademedicion = fechademedicion;
         this.riesgoDeInfarto = riesgo;
     }
     public FrecuenciaCardiaca(int cantpulsaciones) {
         this.cantpulsaciones = cantpulsaciones;
     }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null ) ? 0 : this.id.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrecuenciaCardiaca)) {
            return false;
        }
        FrecuenciaCardiaca other = (FrecuenciaCardiaca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.app.tddt4iots.entities.FrecuenciaCardiaca[ id=" + id + " ]";
    }
}    
