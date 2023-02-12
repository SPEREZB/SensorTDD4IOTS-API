package com.distribuidas.SensorTDD4IOTS.tddt4iots.service;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.UsuarioDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.data.UsuarioDt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioDt{
    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> getAllUsuarios(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Usuario> pagedResult = usuarioDao.findAll(paging);


        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Usuario>();
        }
    }
    @Override
    public Usuario create(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario findById(Long idUsuario) {
        Optional<Usuario> usuario=usuarioDao.findById(idUsuario);
        return usuario.orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        usuarioDao.deleteById(idUsuario);
    }


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
