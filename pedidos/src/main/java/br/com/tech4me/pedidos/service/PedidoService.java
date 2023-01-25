package br.com.tech4me.pedidos.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.pedidos.model.Pedido;

public interface PedidoService {

    Pedido createPedido(Pedido pedido);

    public List<Pedido> getPedidos();

    public Optional<Pedido> getPedidoById(String id);

    Optional<Pedido> editPedidoById(String id, Pedido pedido);

    void deletePedidoById(String id);
    
}
