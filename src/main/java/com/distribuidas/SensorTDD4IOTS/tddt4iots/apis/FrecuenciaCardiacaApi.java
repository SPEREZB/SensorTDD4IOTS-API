package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.FrecuenciaCardiacaDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.FrecuenciaCardiacaDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.FrecuenciaCardiaca;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.FrecuenciaCardiacaServiceAPI;
import com.google.firebase.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
    @Autowired
    private UsuarioApi usAPI;

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

    //PRUEBA PARA WEBSOCKET
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "HOLAAA "+message;
    }




    List<FrecuenciaCardiaca> resultados = new ArrayList<>();



    //TODO ESTO ES PARA OBTENER LOS DATOS DE LAS FRECUENCIAS CARDIACAS SEGUN EL PACIENTE
    @GetMapping("/getData")
    public List<FrecuenciaCardiaca> getData() {
        // Primero, obtenga una referencia a la base de datos de Firebase:
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        // Ahora obtenga una referencia a la colección que desea consultar:
        DatabaseReference myRef = db.getReference("Dispositivos/-1111/Datos/Historial");
       // Ahora cree un objeto de consulta:
        Query query = myRef.orderByKey().limitToLast(1);
       // Finalmente, obtenga los datos de forma síncrona:
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long lastIndex = dataSnapshot.getChildrenCount() -1;
                int count = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        String key = snapshot.getKey();
                        Integer cont = 0;
                        Object cantpulsaciones = snapshot.child("Bpm").getValue();
                        String fechademedicion = snapshot.child("Fecha").getValue().toString();

                        FrecuenciaCardiaca frec = new FrecuenciaCardiaca(key, Integer.parseInt(cantpulsaciones.toString()), fechademedicion, "NO");

                        try {
                            resultados.add(frec);

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return resultados;
    }

    //PARA LA APP MOVIL
    FrecuenciaCardiaca frec = new FrecuenciaCardiaca();
    @GetMapping("/getDataMovil")
    public FrecuenciaCardiaca getDataMovil() {

        // Primero, obtenga una referencia a la base de datos de Firebase:
        FirebaseDatabase db = FirebaseDatabase.getInstance();

        // Ahora obtenga una referencia a la colección que desea consultar:
        DatabaseReference myRef = db.getReference("Dispositivos/-1111/Datos/Historial");

        // Ahora cree un objeto de consulta:
        Query query = myRef.orderByKey().limitToLast(1);

        // Finalmente, obtenga los datos de forma síncrona:
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long lastIndex = dataSnapshot.getChildrenCount() -1;
                int count = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String key = snapshot.getKey();
                    Integer cont = 0;
                    Object cantpulsaciones = snapshot.child("Bpm").getValue();
                    String fechademedicion = snapshot.child("Fecha").getValue().toString();
                    List<FrecuenciaCardiacaDTO> datos;


                   frec = new FrecuenciaCardiaca(key, Integer.parseInt(cantpulsaciones.toString()), fechademedicion, "NO");

                }


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Aquí es donde se manejan los errores.
            }
        });
        return frec;
    }



    @GetMapping("/getResul")
    public List<FrecuenciaCardiaca> getResultado(){
        return resultados;
    }
/*
    @PostMapping(value = "/post")
    public ResponseEntity<String> save(@RequestBody FrecuenciaCardiaca frec) throws Exception{
        return new ResponseEntity<String>(frecServiceAPI.save(frec), HttpStatus.OK);
    }*/

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
