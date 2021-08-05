package com.example.demo.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VencimentoPedidoDto {

	private Integer codigo;
	private LocalDate dataVencimento;
	
}
