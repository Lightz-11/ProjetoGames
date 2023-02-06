package br.com.tech4me.pedidos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.pedidos.model.Pedido;
import br.com.tech4me.pedidos.repository.PedidoRepository;
import br.com.tech4me.pedidos.shared.PedidoDto;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository repo;
  
    @Override
    public PedidoDto createPedido(PedidoDto dto) {

      Pedido pedido = new ModelMapper().map(dto, Pedido.class);
      repo.save(pedido);
      return new ModelMapper().map(pedido, PedidoDto.class);
    }
  
    @Override
    public List<PedidoDto> getPedidos() {
      List<Pedido> pedidos = repo.findAll();

      return pedidos.stream().map(g -> new ModelMapper().map(g, PedidoDto.class)).collect(Collectors.toList());
    }
  
    @Override
    public Optional<PedidoDto> getPedidoById(String id) {
      Optional<Pedido> pedido = repo.findById(id);

      if(pedido.isPresent())
      {
        return Optional.of(new ModelMapper().map(pedido.get(), PedidoDto.class));
      }else
      {
        return Optional.empty();

      }
    }
    @Override
    public Optional<PedidoDto> editPedidoById(String id, PedidoDto dto) {
       Optional<Pedido> pedidoAntigo = repo.findById(id);
        
        if(pedidoAntigo.isPresent()){
            dto.setId(id);
            Pedido pedidoRetorno = new ModelMapper().map(dto, Pedido.class);
            repo.save(pedidoRetorno);

            return Optional.of(new ModelMapper().map(pedidoRetorno, PedidoDto.class));
            
        }else{
            return Optional.empty();
        }

    }

    
  
    @Override
    public void deletePedidoById(String id) {
      repo.deleteById(id);
    }
    
}
