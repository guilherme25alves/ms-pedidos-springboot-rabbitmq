package br.com.guilherme25alves.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilherme25alves.pedido.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
