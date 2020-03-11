package com.casashow.casa.models.modelViews;

import java.util.List;

import com.casashow.casa.models.Casa;
import com.casashow.casa.models.Evento;

public class CasaResponse {
	private String Id;

	private String Nome;

    private String Endereco;
    
    private List<Evento> Eventos;

    public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public List<Evento> getEventos() {
		return Eventos;
	}

	public void setEventos(List<Evento> eventos) {
		Eventos = eventos;
	}

	public CasaResponse(Casa casa) {
        Id = casa.getId();
        Nome = casa.getNome();
        Endereco = casa.getEndereco();
        Eventos = casa.getEventos();
    }
}