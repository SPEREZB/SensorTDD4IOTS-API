package com.distribuidas.SensorTDD4IOTS.tddt4iots.entities;

//import com.app.tddt4iots.enums.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
 import lombok.NoArgsConstructor;
import jakarta.persistence.*;
 import java.util.ArrayList;
 
@Entity
 @Table(name = "Persona")
 @Data
 @NoArgsConstructor
 public class Persona {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

    @Column(name = "nombre", nullable = false, unique = false, length = 30) 
    private String nombre; 
 
    @Column(name = "apellido", nullable = false, unique = false, length = 30) 
    private String apellido; 
 
    @Column(name = "genero", nullable = false, unique = false, length = 30) 
    private String genero;
    @Column(name = "edad", nullable = false, unique = false, length = 30)
    private Integer edad;

    @Column(name = "numeroDeTelefono", nullable = false, unique = false, length = 30) 
    private String numeroDeTelefono; 

   /*@OneToMany(mappedBy = "id")
    private ArrayList<Paciente> paciente; 
 
   @OneToMany(mappedBy = "id") 
    private ArrayList<Usuario> Usuario; 
 
   @OneToMany(mappedBy = "id") 
    private ArrayList<Doctor> doctor; */
 
    
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.app.tddt4iots.entities.Persona[ id=" + id + " ]";
    }
}    
