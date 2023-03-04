package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.UsuarioDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.FrecuenciaCardiacaDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.dto.UsuarioDTO;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.UsuarioServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioApi {

    @Autowired
    private UsuarioDao usuarioDAO;

    @Autowired
    private UsuarioServiceAPI usuarioServiceAPI;

    @GetMapping(value = "/all")
    public List<UsuarioDTO> getAll() throws Exception {
        return usuarioServiceAPI.getAll();
    }
    @GetMapping(value = "/find/{id}")
    public UsuarioDTO find(@PathVariable String id) throws Exception {
        return usuarioServiceAPI.get(id);
    }
    @PostMapping(value = "/post")
    public ResponseEntity<String> save(@RequestBody Usuario usuario) throws Exception{
        return new ResponseEntity<String>(usuarioServiceAPI.save(usuario), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        List<Usuario> listUsuario = usuarioDAO.findAll();
        return ResponseEntity.ok(listUsuario);
    }
    String date, us, ps;
    int index = 0, datel, cantidad = 0,comp=0,cont = 0;
    List<UsuarioDTO> dto;

    @PostMapping("/VerificarUsuarios/")
    @ResponseBody
    public ResponseEntity<Boolean> login(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
// Comprobar si el nombre de usuario y la contraseña son correctos

        cantidad = getAll().size();
        dto= getAll();
        comp=cantidad;
        index = 0;
        while (cantidad > 0) {
            us=dto.get(index).getNombreusuario().toString();
            ps=dto.get(index).getClave().toString();
            cantidad--;

            if (usuarioDTO.getNombreusuario().equals(us) && usuarioDTO.getClave().equals(ps)) {
                usuarioDTO.getTipoDeUsuario();
                cont = 0;
                index = 0;
                return ResponseEntity.ok(true);
            } else {
                index = index + 1;
                if(index>comp){
                    cont = 0;
                    index = 0;
                    return ResponseEntity.ok(false);
                }
            }
        }
        return ResponseEntity.ok(false);
    }

    @PostMapping("/Verificarmovil/")
    @ResponseBody
    public Boolean verifimovil(@RequestParam("usmovil") String usmovil,@RequestParam("cnmovil") String cnmovil) throws Exception {
// Comprobar si el nombre de usuario y la contraseña son correctos

        cantidad = getAll().size();
        dto= getAll();
        comp=cantidad;
        index = 0;
        while (cantidad > 0) {
            us=dto.get(index).getNombreusuario().toString();
            ps=dto.get(index).getClave().toString();
            cantidad--;

            if (usmovil.equals(us) && cnmovil.equals(ps)) {
                cont = 0;
                index = 0;
                return true;
            } else {
                index = index + 1;
                if(index>comp){
                    cont = 0;
                    index = 0;
                    return false;
                }
            }
        }
        return false;
    }

    @PostMapping("/tipous/")
    @ResponseBody
    public ResponseEntity<String> tipous(@RequestBody UsuarioDTO usuarioDTO) throws Exception
    {
        cantidad = getAll().size();
        dto= getAll();
        comp=cantidad;
        index = 0;
        while (cantidad > 0) {
            us=dto.get(index).getNombreusuario().toString();
            ps=dto.get(index).getClave().toString();
            cantidad--;

            if (usuarioDTO.getNombreusuario().equals(us) && usuarioDTO.getClave().equals(ps)) {

                cont = 0;
                return  ResponseEntity.ok(dto.get(index).getTipoDeUsuario());
            } else {
                index = index + 1;
                if(index>comp){
                    cont = 0;
                    index = 0;
                    return null;
                }
            }
        }
        return null;
    }

    @PostMapping
        public ResponseEntity<Usuario> insertUsuario (@RequestBody Usuario usuario){
            Usuario newUsuario = usuarioDAO.save(usuario);
            return ResponseEntity.ok(newUsuario);
        }

        @PutMapping
        public ResponseEntity<Usuario> updateUsuario (@RequestBody Usuario usuario){
            Usuario upUsuario = usuarioDAO.save(usuario);
            if (upUsuario != null) {
                return ResponseEntity.ok(upUsuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping(value = "{id}")
        public ResponseEntity<Usuario> deletePersons (@PathVariable("id") Long id){
            usuarioDAO.deleteById(id);
            return ResponseEntity.ok(null);
        }


}
