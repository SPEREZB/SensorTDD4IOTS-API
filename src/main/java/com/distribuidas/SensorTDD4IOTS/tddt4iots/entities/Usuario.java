package com.distribuidas.SensorTDD4IOTS.tddt4iots.entities;
 
//import com.app.tddt4iots.enums.*;
import jakarta.persistence.*;
import lombok.Data;
 import lombok.NoArgsConstructor;

 import java.util.ArrayList;
 
@Entity
 @Table(name = "Usuario")
 @Data
 @NoArgsConstructor
 public class Usuario {
     
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     
    @Column(name = "nombreusuario", nullable = false, unique = false, length = 30)
    private String nombreusuario; 
 
    @Column(name = "clave", nullable = false, unique = false, length = 30) 
    private String clave; 
 
    @Column(name = "estado", nullable = false, unique = false, length = 30) 
    private String estado; 
 
    @Column(name = "tipoDeUsuario", nullable = false, unique = false, length = 30) 
    private String tipoDeUsuario; 
 
   @OneToMany(mappedBy = "id") 
    private ArrayList<Persona> persona; 
 
    
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.app.tddt4iots.entities.Usuario[ id=" + id + " ]";
    }
}    
