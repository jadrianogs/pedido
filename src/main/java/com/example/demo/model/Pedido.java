package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -8406336410953716563L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String descricao;
	
	private Integer quantidade;
	
	@Column(name = "quantidade_apv")
	private Integer quantidadeAptovada;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	@Column(name = "data_pedido")
	private LocalDate dataPedido;
	
	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;
	
}
