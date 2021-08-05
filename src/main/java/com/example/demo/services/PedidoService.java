package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.model.Status;
import com.example.demo.model.VencimentoPedidoDto;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido getById(Integer codigo) {
		Optional<Pedido> optional = pedidoRepository.findById(codigo);
		
		if(!optional.isEmpty())
			return optional.get();
		else
			return null;
	}
	
	public Pedido salvar(Pedido pedido) {
		if(pedido != null) {
			if(pedido.getDataVencimento() != null)
				pedido.setDataVencimento(pedido.getDataPedido().plusDays(10));
		}
		return pedidoRepository.save(pedido);
	}

	public Pedido alterar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido atualizarStatus(Integer codigo, Status status) {
		Optional<Pedido> optional = pedidoRepository.findById(codigo);
		
		if(!optional.isEmpty()) {
			Pedido pedido = optional.get();
			pedido.setStatus(status);
			return pedidoRepository.save(pedido);
		} else {
			return null;
		}
	}
	
	public Pedido atualizarVencimento(VencimentoPedidoDto vencimento) {
		Optional<Pedido> optional = pedidoRepository.findById(vencimento.getCodigo());
		
		if(!optional.isEmpty()) {
			Pedido pedido = optional.get();
			pedido.setDataVencimento(vencimento.getDataVencimento());
			return pedidoRepository.save(pedido);
		} else {
			return null;
		}
	}
	
	public Pedido excluir(Integer codigo) {
		Optional<Pedido> optional = pedidoRepository.findById(codigo);
		
		if(!optional.isEmpty()) {
			Pedido pedido = optional.get();
			pedido.setStatus(Status.EXLCUIDO);
			return pedidoRepository.save(pedido);
		} else {
			return null;
		}
			
	}
	
	public List<Pedido> getLista() {
		return pedidoRepository.findAll();
	}

}
