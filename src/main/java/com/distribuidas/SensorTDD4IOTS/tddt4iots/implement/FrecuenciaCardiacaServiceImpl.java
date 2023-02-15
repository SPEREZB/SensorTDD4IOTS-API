package com.distribuidas.SensorTDD4IOTS.tddt4iots.implement;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.commons.GenericServiceImpl;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.FrecuenciaCardiacaDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.FrecuenciaCardiaca;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.FrecuenciaCardiacaServiceAPI;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrecuenciaCardiacaServiceImpl extends GenericServiceImpl<FrecuenciaCardiaca, FrecuenciaCardiacaDTO> implements FrecuenciaCardiacaServiceAPI {

    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("frecuenciacardiaca");
    }
}
