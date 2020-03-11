package com.casashow.casa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evento {
	@Id
	private String Id;
	private String Nome;
	private double Preco;
	@ManyToOne
	private Casa Casa;
	@OneToMany
	private List<Venda> Vendas;
	@Enumerated(EnumType.STRING)
	private EventoStatus Status;
	private Date Data;
	private int Capacidade;
    
    public Evento(){
        Status = EventoStatus.Ativo;
    }

}
