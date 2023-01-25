package com.distribuidas.SensorTDD4IOTS.tddt4iots.dao;

 import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
 import org.springframework.data.jpa.repository.JpaRepository;
 
 public interface UsuarioDao extends JpaRepository<Usuario, Long> {
 }
