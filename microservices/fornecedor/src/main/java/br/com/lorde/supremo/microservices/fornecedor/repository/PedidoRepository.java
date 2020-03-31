package br.com.lorde.supremo.microservices.fornecedor.repository;

import br.com.lorde.supremo.microservices.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
