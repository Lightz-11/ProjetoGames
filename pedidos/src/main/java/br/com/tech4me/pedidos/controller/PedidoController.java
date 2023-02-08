package br.com.tech4me.pedidos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.pedidos.service.PedidoService;
import br.com.tech4me.pedidos.shared.PedidoCompDto;
import br.com.tech4me.pedidos.shared.PedidoDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;
    
    @PostMapping
    public ResponseEntity<Optional<PedidoDto>> CreatePedido(@Valid @RequestBody PedidoDto pedido)
    {
        return new ResponseEntity<>(service.createPedido(pedido), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> GetPedidos()
    {
        return new ResponseEntity<>(service.getPedidos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoCompDto> obterPedidoPorId(@PathVariable String id)
    {
        Optional<PedidoCompDto> retorno = service.getPedidoById(id);
        
        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> editGameById(@Valid@PathVariable String id, @RequestBody PedidoDto pedido) {

        Optional<PedidoDto> pedidoAntigo = service.editPedidoById(id, pedido);

        return new ResponseEntity<>(pedidoAntigo.get(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PedidoDto> DeletePedido(@PathVariable String id)
    {
        Optional<PedidoCompDto> antigoPedido = service.getPedidoById(id);
        service.deletePedidoById(id);

        if (antigoPedido.isPresent()) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
