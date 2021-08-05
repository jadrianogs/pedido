package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>, PagingAndSortingRepository<Pedido, Integer> {

}
