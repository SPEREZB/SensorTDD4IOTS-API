package com.distribuidas.SensorTDD4IOTS.tddt4iots.entities;

//import com.app.tddt4iots.enums.*;
import lombok.Data;
 import lombok.NoArgsConstructor;
 
import javax.persistence.*;
 import java.util.ArrayList;
 
@Entity
 @Table(name = "Doctor")
 @Data
 @NoArgsConstructor
 public class Doctor {
     
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     
   @OneToMany(mappedBy = "id") 
    private ArrayList<Persona> Persona; 
 
    
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
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.app.tddt4iots.entities.Doctor[ id=" + id + " ]";
    }
}    
