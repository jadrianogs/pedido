package com.example.demo.model;

public enum Status {

	PENDENTE("Pendente"),
	APROVADO("Aprovado"),
	CANCELADO("Cancelado"),
	EXLCUIDO("Excluido");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	private Status(String descricao) {
		this.descricao = descricao;
	}
}
