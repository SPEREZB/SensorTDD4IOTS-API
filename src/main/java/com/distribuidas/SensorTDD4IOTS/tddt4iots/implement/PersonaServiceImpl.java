package com.distribuidas.SensorTDD4IOTS.tddt4iots.implement;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.commons.GenericServiceImpl;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.PersonaDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Persona;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.PersonaServiceAPI;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, PersonaDTO> implements PersonaServiceAPI {
    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("persona");
    }
}
