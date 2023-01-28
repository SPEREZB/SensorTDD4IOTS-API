package com.distribuidas.SensorTDD4IOTS.tddt4iots.service;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.UsuarioDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;
    public List<Usuario> getAllPersonas (){
        return usuarioDao.findAll();
    }
}
