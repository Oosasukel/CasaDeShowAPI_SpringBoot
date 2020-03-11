package com.casashow.casa.models;

import javax.persistence.*;

@Entity
public class Venda {
	@Id
	private String Id;
	private VendaStatus Status;
	private double PrecoUnitario;
	@ManyToOne
	public Evento Evento;
	@ManyToOne
	private Usuario Usuario;
	private int Quantidade;

	public Venda() {
		Status = VendaStatus.Normal;
	}
}
