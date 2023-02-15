package com.distribuidas.SensorTDD4IOTS.tddt4iots.implement;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.commons.GenericServiceImpl;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.UsuarioDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.UsuarioServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, UsuarioDTO> implements UsuarioServiceAPI {

	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {
		return firestore.collection("usuario");
	}
}
