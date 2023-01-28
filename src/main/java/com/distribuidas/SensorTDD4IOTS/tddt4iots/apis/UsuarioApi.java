package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.UsuarioDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioApi {

    @Autowired
    private UsuarioDao usuarioDAO;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        List<Usuario> listUsuario = usuarioDAO.findAll();
        return ResponseEntity.ok(listUsuario);
    }


    String date, us, ps;
    int index = 0, datel, inicio, inicio2, cantidad = 0;
    int fin = 1, fin2 = 1, finpr = 1, finpr2 = 1;

    @PostMapping("/VerificarUsuarios/")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
// Comprobar si el nombre de usuario y la contraseña son correctos

        cantidad = getUsuario().getBody().size();
        while (cantidad > 0) {
            date = getUsuario().getBody().get(index).toString();
            datel = date.length();
            getUsPs();
             //String algo= usServicio.getNombreUsuario();
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
        }
        return ResponseEntity.ok("No existen usuarios");
    }

    int cont = 0, cont2 = 1;

    private void getUsPs() {

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

    }

        @PostMapping
        public ResponseEntity<Usuario> insertUsuario (@RequestBody Usuario usuario){
            Usuario newUsuario = usuarioDAO.save(usuario);
            return ResponseEntity.ok(newUsuario);
        }

        @PutMapping
        public ResponseEntity<Usuario> updateUsuario (@RequestBody Usuario usuario){
            Usuario upUsuario = usuarioDAO.save(usuario);
            if (upUsuario != null) {
                return ResponseEntity.ok(upUsuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(value = "{id}")
        public ResponseEntity<Usuario> deletePersons (@PathVariable("id") Long id){
            usuarioDAO.deleteById(id);
            return ResponseEntity.ok(null);
        }


}
