package com.distribuidas.SensorTDD4IOTS.tddt4iots.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
 @Entity
 @Table(name = "Paciente")
 @Data
 @NoArgsConstructor
 public class Paciente {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     @Column(name = "altura", nullable = false, unique = false, length = 30)
     private String altura;

     @Column(name = "peso", nullable = false, unique = false, length = 30)
     private String peso;

     @Column(name = "gruposanguineo", nullable = false, unique = false, length = 30)
     private String gruposanguineo;

     @Column(name = "audio", nullable = false, unique = false, length = 30)
     private String audio;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.app.tddt4iots.entities.Paciente[ id=" + id + " ]";
    }
}    
