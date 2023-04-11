package com.unesp.widget.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unesp.widget.model.Usuario;
import com.unesp.widget.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")

public class IndexController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @GetMapping(value = "", produces = "application/json")
    // public ResponseEntity getHome() {
    // return new ResponseEntity("Olá usuário", HttpStatus.OK);
    // }

    // @GetMapping(value = "/getId", produces = "application/json")
    // public ResponseEntity getId() {
    // return new ResponseEntity("Getando um ID", HttpStatus.OK);
    // }

    // @GetMapping(value = "/getNome", produces = "application/json")
    // public ResponseEntity getNome() {
    // return new ResponseEntity("Getando nome", HttpStatus.OK);
    // }

    // @GetMapping(value = "/getEnd", produces = "application/json")
    // public ResponseEntity getEnd() {
    // return new ResponseEntity("Getando um endereço", HttpStatus.OK);
    // }

    // @GetMapping(value = "/getWithParams", produces = "application/json")
    // public ResponseEntity requestParam(@RequestParam(value = "name", required =
    // false) String nome,
    // @RequestParam(value = "sobrenome", required = false) String sobrenome) {
    // System.out.println(nome);
    // return new ResponseEntity("Olá usuário " + nome + " " + sobrenome,
    // HttpStatus.OK);
    // }

    // @GetMapping(value = "/getUser", produces = "application/json")
    // public ResponseEntity getUser() {
    // Usuario usuario1 = new Usuario();

    // usuario1.setId(1L);
    // usuario1.setLogin("luskas@gmail.com");
    // usuario1.setSenha("umaSenha");
    // usuario1.setNome("luskas");

    // Usuario usuario2 = new Usuario();

    // usuario2.setId(2L);
    // usuario2.setLogin("kuslas@gmail.com");
    // usuario2.setSenha("duasSenhas");
    // usuario2.setNome("kuslas");

    // List<Usuario> list = new ArrayList<Usuario>();

    // list.add(usuario1);
    // list.add(usuario2);

    // return new ResponseEntity(list, HttpStatus.OK);
    // }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> getUserById(@PathVariable(value = "id") Long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity getAllUsers() {

        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity(usuarios.iterator(), HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {

        for (int pos = 0; pos < usuario.getTelefones().size(); pos++) {
            usuario.getTelefones().get(pos).setUsuario(usuario);
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) {

        for (int pos = 0; pos < usuario.getTelefones().size(); pos++) {
            usuario.getTelefones().get(pos).setUsuario(usuario);
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String deleteUser(@PathVariable("id") Long id) {

        usuarioRepository.deleteById(id);
        return "Usuário deleteado com sucesso";
    }
}
