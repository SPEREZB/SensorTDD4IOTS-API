package com.distribuidas.SensorTDD4IOTS.tddt4iots.dao;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
 
 public interface DoctorDao extends JpaRepository<Doctor, Long> {
 }
