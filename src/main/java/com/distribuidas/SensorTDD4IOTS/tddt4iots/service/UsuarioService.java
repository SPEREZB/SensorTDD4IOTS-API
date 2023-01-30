package com.distribuidas.SensorTDD4IOTS.tddt4iots.service;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.UsuarioDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    public ResponseEntity<String> getUsPs(String date,int datel,int cantidad,int cont, int index,@RequestBody Usuario usuario)
    {
         String us="",ps="";
        for (int i = 0; i < datel; i++) {
            // Incrementamos el contador cada vez que encontremos un caracter
            cont = cont + 1;
            ps= date.substring(cont);
            // Verificamos si el caracter actual es una coma
            if (date.charAt(i) == ',') {
                // Si se encuentra una coma, salimos del ciclo
                break;
            }
        }
        us = date.substring(0, cont - 1);

        if (usuario.getNombreUsuario().equals(us) && usuario.getClave().equals(ps)) {
            cont = 0;
            index = 0;
            return ResponseEntity.ok("Login exitoso");
        } else {
            index = index + 1;
            if(index+1>cantidad){
                cont = 0;
                index = 0;
                return ResponseEntity.ok("Nombre de usuario o contraseña incorrectos");
            }
        }

        return ResponseEntity.ok("Login exitoso");
    }
}
