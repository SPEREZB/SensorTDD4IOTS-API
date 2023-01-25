package com.distribuidas.SensorTDD4IOTS.tddt4iots.dao;

 import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Persona;
 import org.springframework.data.jpa.repository.JpaRepository;
 
 public interface PersonaDao extends JpaRepository<Persona, Long> {
 }
