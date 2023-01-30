package br.com.tech4me.pedidos.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.pedidos.shared.PedidoDto;

public interface PedidoService {

    PedidoDto createPedido(PedidoDto dto);

    public List<PedidoDto> getPedidos();

    public Optional<PedidoDto> getPedidoById(String id);

    Optional<PedidoDto> editPedidoById(String id, PedidoDto pedido);

    void deletePedidoById(String id);
    
}
