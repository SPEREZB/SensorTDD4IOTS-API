package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.PacienteDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.PacienteDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.UsuarioDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Paciente;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.AWSS3Service;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.PacienteServiceAPI;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacienteApi {

    @Autowired
    private PacienteDao pacienteDAO;
    @Autowired
    private PacienteServiceAPI pacienteServiceAPI;

    @Autowired
    private AWSS3Service awss3Service;

    @GetMapping
    public ResponseEntity<List<Paciente>> getPaciente() {
        List<Paciente> listPaciente = pacienteDAO.findAll();
        return ResponseEntity.ok(listPaciente);
    }
    @GetMapping(value = "/all")
    public List<PacienteDTO> getAll() throws Exception {
        return pacienteServiceAPI.getAll();
    }

    @PostMapping(value = "/audio")
    public ResponseEntity<String> uploadFile(@RequestPart(value="file") MultipartFile file) {
        awss3Service.uploadFile(file);
        String response = "El archivo "+file.getOriginalFilename()+" fue cargado correctamente a S3";
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<String>> listFiles() {
        return new ResponseEntity<List<String>>(awss3Service.getObjectsFromS3(), HttpStatus.OK);
    }

    @GetMapping(value = "/download")
    public ResponseEntity<Resource> download(@RequestParam("key") String key) {
        InputStreamResource resource  = new InputStreamResource(awss3Service.downloadFile(key));
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+key+"\"").body(resource);
    }

    @PostMapping
    public ResponseEntity<Paciente> insertPaciente(@RequestBody Paciente paciente) {
        Paciente newPaciente = pacienteDAO.save(paciente);
        return ResponseEntity.ok(newPaciente);
    }

    @PutMapping
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente) {
        Paciente upPaciente = pacienteDAO.save(paciente);
        if (upPaciente != null) {
            return ResponseEntity.ok(upPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Paciente> deletePersons(@PathVariable("id") Long id) {
        pacienteDAO.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
