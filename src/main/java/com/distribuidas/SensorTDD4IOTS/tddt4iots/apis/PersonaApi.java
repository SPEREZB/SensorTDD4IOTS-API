package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.PersonaDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaApi {

    @Autowired
    private PersonaDao personaDAO;

    @GetMapping
    public ResponseEntity<List<Persona>> getPersona() {
        List<Persona> listPersona = personaDAO.findAll();
        return ResponseEntity.ok(listPersona);
    }

    @PostMapping
    public ResponseEntity<Persona> insertPersona(@RequestBody Persona persona) {
        Persona newPersona = personaDAO.save(persona);
        return ResponseEntity.ok(newPersona);
    }

    @PutMapping
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
        Persona upPersona = personaDAO.save(persona);
        if (upPersona != null) {
            return ResponseEntity.ok(upPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Persona> deletePersons(@PathVariable("id") Long id) {
        personaDAO.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
