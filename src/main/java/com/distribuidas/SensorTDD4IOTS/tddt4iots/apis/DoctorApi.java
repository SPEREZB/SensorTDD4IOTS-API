package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.DoctorDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorApi {

    @Autowired
    private DoctorDao doctorDAO;

    @GetMapping
    public ResponseEntity<List<Doctor>> getDoctor() {
        List<Doctor> listDoctor = doctorDAO.findAll();
        return ResponseEntity.ok(listDoctor);
    }

    @PostMapping
    public ResponseEntity<Doctor> insertDoctor(@RequestBody Doctor doctor) {
        Doctor newDoctor = doctorDAO.save(doctor);
        return ResponseEntity.ok(newDoctor);
    }

    @PutMapping
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        Doctor upDoctor = doctorDAO.save(doctor);
        if (upDoctor != null) {
            return ResponseEntity.ok(upDoctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Doctor> deletePersons(@PathVariable("id") Long id) {
        doctorDAO.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
