package br.com.tech4me.pedidos.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.pedidos.shared.PedidoCompDto;
import br.com.tech4me.pedidos.shared.PedidoDto;

public interface PedidoService {

    Optional<PedidoDto> createPedido(PedidoDto dto);

    public List<PedidoDto> getPedidos();

    public Optional<PedidoCompDto> getPedidoById(String id);

    Optional<PedidoDto> editPedidoById(String id, PedidoDto pedido);

    void deletePedidoById(String id);
    
}
