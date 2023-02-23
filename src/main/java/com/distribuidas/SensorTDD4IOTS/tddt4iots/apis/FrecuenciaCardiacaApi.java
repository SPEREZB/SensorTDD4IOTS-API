package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.FrecuenciaCardiacaDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.FrecuenciaCardiacaDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.FrecuenciaCardiaca;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.FrecuenciaCardiacaServiceAPI;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.UsuarioServiceAPI;
import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/frecuenciacardiaca")
public class FrecuenciaCardiacaApi {

    @Autowired
    private FrecuenciaCardiacaDao frecuenciacardiacaDAO;

    @Autowired
    private FrecuenciaCardiacaServiceAPI frecServiceAPI;

    @GetMapping
    public ResponseEntity<List<FrecuenciaCardiaca>> getFrecuenciaCardiaca() {
        List<FrecuenciaCardiaca> listFrecuenciaCardiaca = frecuenciacardiacaDAO.findAll();
        return ResponseEntity.ok(listFrecuenciaCardiaca);
    }

    @GetMapping(value = "/all")
    public List<FrecuenciaCardiacaDTO> getAll() throws Exception {
        return frecServiceAPI.getAll();
    }
    @GetMapping(value = "/find/{id}")
    public FrecuenciaCardiacaDTO find(@PathVariable String id) throws Exception {
        return frecServiceAPI.get(id);
    }

    @GetMapping("/getData")
    public String getData() {
        List<Object> resultados = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference("Dispositivos/-1111/Datos/Emergencia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Aquí es donde puedes recuperar los datos almacenados en la ubicación "usuarios".
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                       // String key = snapshot.getKey();
                        //Long id= Long.parseLong(key);
                        Object cantpulsaciones =  snapshot.child("Bpm").getValue();
                        String fechademedicion =  snapshot.child("Fecha").getValue().toString();

                        FrecuenciaCardiaca frec = new FrecuenciaCardiaca(Integer.parseInt(cantpulsaciones.toString()), fechademedicion);
                        // Enviar el objeto Usuario al método save de UsuarioServiceAPI
                        try {
                            frecServiceAPI.save(frec);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Aquí es donde se manejan los errores.
            }
        });
        return "";
    }
    @PostMapping(value = "/post")
    public ResponseEntity<String> save(@RequestBody FrecuenciaCardiaca frec) throws Exception{
        return new ResponseEntity<String>(frecServiceAPI.save(frec), HttpStatus.OK);
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
