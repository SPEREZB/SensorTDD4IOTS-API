package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.PersonaDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.PersonaDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.UsuarioDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Persona;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/persona")
public class PersonaApi {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;
    @Autowired
    private PersonaDao personaDAO;

    @GetMapping
    public ResponseEntity<List<Persona>> getPersona() {
        List<Persona> listPersona = personaDAO.findAll();
        return ResponseEntity.ok(listPersona);
    }
    @GetMapping(value = "/all")
    public List<PersonaDTO> getAll() throws Exception {
        return personaServiceAPI.getAll();
    }

    @PostMapping
    public ResponseEntity<Persona> insertPersona(@RequestBody Persona persona) {
        Persona newPersona = personaDAO.save(persona);
        return ResponseEntity.ok(newPersona);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<String> save(@RequestBody Persona persona) throws Exception{
        return new ResponseEntity<String>(personaServiceAPI.save(persona), HttpStatus.OK);
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
