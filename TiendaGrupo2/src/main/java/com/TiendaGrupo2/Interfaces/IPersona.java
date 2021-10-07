package com.TiendaGrupo2.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TiendaGrupo2.model.Persona;


@Repository
public interface IPersona extends CrudRepository<Persona, Integer>
{

}