package com.distribuidas.SensorTDD4IOTS.tddt4iots.apis;

import com.distribuidas.SensorTDD4IOTS.tddt4iots.dao.UsuarioDao;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.entities.Usuario;
import com.distribuidas.SensorTDD4IOTS.tddt4iots.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/prueba/")
    public ResponseEntity<List<Usuario>> getUsuario(@RequestParam(defaultValue = "0") Integer pageNo,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(defaultValue = "id") String sortBy) {
        List<Usuario> listUsuario = usuarioService.getAllUsuarios(pageNo, pageSize, sortBy);
        return ResponseEntity.ok(listUsuario);
    }


    String date, us, ps;
    int index = 0, datel, cantidad = 0,cont = 0;
    @PostMapping("/VerificarUsuarios/")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
// Comprobar si el nombre de usuario y la contraseña son correctos

        cantidad = getUsuario().getBody().size();
        while (cantidad > 0) {
            date = getUsuario().getBody().get(index).toString();
            datel = date.length();
            return usuarioService.getUsPs(date,datel,cantidad,cont,index,usuario);
        }
        return ResponseEntity.ok("No existen usuarios");
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
