package com.TiendaGrupo2.interceService;

import java.util.List;
import java.util.Optional;

import com.TiendaGrupo2.model.Persona;

public interface IPersonaService 
{
	public List<Persona> listar();
	public Optional<Persona> listarId(int id);
	public int save(Persona p);
	public void delete(int id);

}
