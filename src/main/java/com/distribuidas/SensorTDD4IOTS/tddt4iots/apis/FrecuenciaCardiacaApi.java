package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.FrecuenciaCardiacaDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.FrecuenciaCardiacaDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.UsuarioDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.FrecuenciaCardiaca;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.FrecuenciaCardiacaServiceAPI;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.UsuarioServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/frecuenciacardiaca")
public class FrecuenciaCardiacaApi {

    @Autowired
    private FrecuenciaCardiacaDao frecuenciacardiacaDAO;

    @Autowired
    private FrecuenciaCardiacaServiceAPI frecApiServiceAPI;
    @GetMapping
    public ResponseEntity<List<FrecuenciaCardiaca>> getFrecuenciaCardiaca() {
        List<FrecuenciaCardiaca> listFrecuenciaCardiaca = frecuenciacardiacaDAO.findAll();
        return ResponseEntity.ok(listFrecuenciaCardiaca);
    }

    @GetMapping(value = "/all")
    public List<FrecuenciaCardiacaDTO> getAll() throws Exception {
        return frecApiServiceAPI.getAll();
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
