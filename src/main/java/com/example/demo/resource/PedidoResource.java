package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedido;
import com.example.demo.model.Status;
import com.example.demo.model.VencimentoPedidoDto;
import com.example.demo.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Pedido> consultar(@PathVariable Integer codigo) {
		Pedido pedido = pedidoService.getById(codigo);
		
		if(pedido != null)
			return new ResponseEntity<Pedido>(pedido, new HttpHeaders(), HttpStatus.OK);
		else
			return ResponseEntity.notFound().build();
		
	}

	@GetMapping
	public ResponseEntity<List<Pedido>> listar() {
		List<Pedido> lista = pedidoService.getLista();
		
		return new ResponseEntity<List<Pedido>>(lista, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
		
		Pedido pedidoSalvo = pedidoService.salvar(pedido);
		if(pedidoSalvo != null)
			return new ResponseEntity<Pedido>(pedidoSalvo, new HttpHeaders(), HttpStatus.CREATED);
		else
			return ResponseEntity.notFound().build();
	}

	
	@PutMapping
	public ResponseEntity<Pedido> alterar(@RequestBody Pedido pedido) {
		Pedido pedidoSalvo = pedidoService.salvar(pedido);
		
		if(pedidoSalvo != null)
			return new ResponseEntity<Pedido>(pedidoSalvo, new HttpHeaders(), HttpStatus.CREATED);
		else
			return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Integer codigo) {
		Pedido pedido = pedidoService.excluir(codigo);
		
		if(pedido != null)
			return new ResponseEntity<Void>(null, new HttpHeaders(), HttpStatus.OK);
		else
			return ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Void> atualizarStatus(@PathVariable Integer codigo, @RequestParam Status status) {
		Pedido pedido = pedidoService.atualizarStatus(codigo, status);
		
		if(pedido != null)
			return new ResponseEntity<Void>(null, new HttpHeaders(), HttpStatus.OK);
		else
			return ResponseEntity.notFound().build();
	}

	@PutMapping("/vencimento")
	public ResponseEntity<Void> atualizarVencimentoPedido(@RequestBody VencimentoPedidoDto vencimento) {
		Pedido pedido = pedidoService.atualizarVencimento(vencimento);
		
		if(pedido != null)
			return new ResponseEntity<Void>(null, new HttpHeaders(), HttpStatus.OK);
		else
			return ResponseEntity.notFound().build();		
	}

}
