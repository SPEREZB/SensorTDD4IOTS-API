package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.FrecuenciaCardiacaDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.FrecuenciaCardiaca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/frecuenciacardiaca")
public class FrecuenciaCardiacaApi {

    @Autowired
    private FrecuenciaCardiacaDao frecuenciacardiacaDAO;

    @GetMapping
    public ResponseEntity<List<FrecuenciaCardiaca>> getFrecuenciaCardiaca() {
        List<FrecuenciaCardiaca> listFrecuenciaCardiaca = frecuenciacardiacaDAO.findAll();
        return ResponseEntity.ok(listFrecuenciaCardiaca);
    }

    @PostMapping
    public ResponseEntity<FrecuenciaCardiaca> insertFrecuenciaCardiaca(@RequestBody FrecuenciaCardiaca frecuenciacardiaca) {
        FrecuenciaCardiaca newFrecuenciaCardiaca = frecuenciacardiacaDAO.save(frecuenciacardiaca);
        return ResponseEntity.ok(newFrecuenciaCardiaca);
    }

    @PutMapping
    public ResponseEntity<FrecuenciaCardiaca> updateFrecuenciaCardiaca(@RequestBody FrecuenciaCardiaca frecuenciacardiaca) {
        FrecuenciaCardiaca upFrecuenciaCardiaca = frecuenciacardiacaDAO.save(frecuenciacardiaca);
        if (upFrecuenciaCardiaca != null) {
            return ResponseEntity.ok(upFrecuenciaCardiaca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<FrecuenciaCardiaca> deletePersons(@PathVariable("id") Long id) {
        frecuenciacardiacaDAO.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
