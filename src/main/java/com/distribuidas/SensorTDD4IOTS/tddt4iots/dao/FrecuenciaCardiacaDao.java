package com.distribuidas.SensorTDD4IOTS.tddt4iots.dao;

 import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.FrecuenciaCardiaca;
 import org.springframework.data.jpa.repository.JpaRepository;
 
 public interface FrecuenciaCardiacaDao extends JpaRepository<FrecuenciaCardiaca, Long> {
 }
