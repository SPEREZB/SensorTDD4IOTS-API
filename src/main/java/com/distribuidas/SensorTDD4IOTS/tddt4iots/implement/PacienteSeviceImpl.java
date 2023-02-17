package com.distribuidas.SensorTDD4IOTS.tddt4iots.implement;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.commons.GenericServiceImpl;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.PacienteDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.UsuarioDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Paciente;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.PacienteServiceAPI;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.UsuarioServiceAPI;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteSeviceImpl extends GenericServiceImpl<Paciente, PacienteDTO> implements PacienteServiceAPI {
    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("paciente");
    }
}
