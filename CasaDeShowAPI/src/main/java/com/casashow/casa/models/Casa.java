package com.casashow.casa.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Casa {
	@Id
	private String Id;

	private String Nome;

	private String Endereco;

	@OneToMany
	private List<Evento> Eventos;

	@Enumerated(EnumType.STRING)
	private CasaStatus Status;
	@OneToOne
	private Usuario Usuario;

	public Casa() {
		Status = CasaStatus.Ativa;
	}

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

	public CasaStatus getStatus() {
		return Status;
	}

	public void setStatus(CasaStatus status) {
		Status = status;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
}