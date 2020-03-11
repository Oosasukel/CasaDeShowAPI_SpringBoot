package com.casashow.casa.models.modelViews;

import com.casashow.casa.models.Casa;

public class CasaRequest {
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	private String nome;
    private String endereco;
    
	public Casa toCasa() {
        Casa casa = new Casa();
        casa.setNome(nome);
        casa.setEndereco(endereco);
        return casa;
	}
}