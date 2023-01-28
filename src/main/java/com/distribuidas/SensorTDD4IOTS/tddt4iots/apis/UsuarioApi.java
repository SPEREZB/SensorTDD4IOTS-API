package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.UsuarioDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    String date,us,ps;
    int index=0,datel,inicio,inicio2,listar=0;
    int fin=1,fin2=1,finpr=1,finpr2=1;
    @PostMapping("/VerifyUsers/")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
// Comprobar si el nombre de usuario y la contraseña son correctos

        listar=getUsuario().getBody().size();
        while (listar>0)
        {

            date= getUsuario().getBody().get(index).toString();
            datel=date.length();
            us= getUsername();
            ps= getPassword();

            if (usuario.getNombreUsuario().equals(us) && usuario.getClave().equals(ps)) {

                return ResponseEntity.ok("Login exitoso");
            } else {
                index= index+1;
            }
            listar=listar-1;
        }
        return ResponseEntity.ok("Nombre de usuario o contraseña incorrectos");
    }

    private String getUsername()
    {
        while(datel>0)
        {
            fin=inicio+9;
            us = date.substring(inicio,fin);
            if(us.compareTo("Username=")==0)
            {
                fin2=fin+1;

                while(us.contains(",")==false)
                {
                    us = date.substring(fin,fin2);
                    fin2=fin2+1;
                }
                inicio2=fin2;
                finpr=fin2+9;
                fin2=fin2-2;
                us = date.substring(fin,fin2);
                return us;
            }
            else{
                inicio=inicio+1;
            }
        }
        return "NO HAY USUARIOS";
    }

    private String getPassword()
    {
        while(datel>0)
        {
            finpr=inicio2+9;
            ps= date.substring(inicio2,finpr);
            if(ps.compareTo("Password=")==0)
            {
                finpr2=finpr+1;
                while(ps.contains(")")==false)
                {
                    ps = date.substring(finpr,finpr2);
                    finpr2=finpr2+1;
                }
                finpr2=finpr2-2;
                ps = date.substring(finpr,finpr2);
                return ps;
            }

            else{
                inicio2=inicio2+1;
            }
        }
        return "NO HAY USUARIOS";
    }



    @PostMapping
    public ResponseEntity<Usuario> insertUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioDAO.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario upUsuario = usuarioDAO.save(usuario);
        if (upUsuario != null) {
            return ResponseEntity.ok(upUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Usuario> deletePersons(@PathVariable("id") Long id) {
        usuarioDAO.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
