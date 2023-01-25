package br.com.tech4me.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.pedidos.model.Pedido;
import br.com.tech4me.pedidos.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository repo;
  
    @Override
    public Pedido createPedido(Pedido pedido) {
      return repo.save(pedido);
    }
  
    @Override
    public List<Pedido> getPedidos() {
      return repo.findAll();
    }
  
    @Override
    public Optional<Pedido> getPedidoById(String id) {
      return repo.findById(id);
    }
  
    @Override
    public Optional<Pedido> editPedidoById(String id, Pedido pedido) {
  
      Optional<Pedido> pedidoAntigo = repo.findById(id);

      if (pedidoAntigo.isPresent()) {
          pedido.setId(id);
          return Optional.of(repo.save(pedido));
      } else {
          return Optional.empty();
      }
    }

    
  
    @Override
    public void deletePedidoById(String id) {
      repo.deleteById(id);
    }
    
}
