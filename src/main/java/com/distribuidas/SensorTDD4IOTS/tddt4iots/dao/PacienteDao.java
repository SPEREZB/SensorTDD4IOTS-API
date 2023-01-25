package com.distribuidas.SensorTDD4IOTS.tddt4iots.dao;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
 
 public interface PacienteDao extends JpaRepository<Paciente, Long> {
 }
