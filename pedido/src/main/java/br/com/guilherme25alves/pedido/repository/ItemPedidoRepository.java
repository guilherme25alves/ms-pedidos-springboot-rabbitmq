package br.com.guilherme25alves.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guilherme25alves.pedido.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
