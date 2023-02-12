package com.distribuidas.SensorTDD4IOTS.tddt4iots.data;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;

import java.util.List;

public interface  UsuarioDt {
    Usuario findById(Long idUsuario);
    List<Usuario> findAll();
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Long idUsuario);
}
