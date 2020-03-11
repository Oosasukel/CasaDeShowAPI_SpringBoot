package com.casashow.casa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	private String Email;
	private String Nome;
	@OneToMany
	private List<Venda> Compras;
	private String Senha;

	private UsuarioStatus Status;
	private String Role;
	@OneToOne
	private Casa casa;
    
    public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public List<Venda> getCompras() {
		return Compras;
	}

	public void setCompras(List<Venda> compras) {
		Compras = compras;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public UsuarioStatus getStatus() {
		return Status;
	}

	public void setStatus(UsuarioStatus status) {
		Status = status;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Usuario() {
    	Status = UsuarioStatus.Ativo;
    }

}
