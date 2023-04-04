package com.unesp.widget.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unesp.widget.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
