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

import br.com.tech4me.pedidos.model.Pedido;
import br.com.tech4me.pedidos.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;
    
    @PostMapping
    public ResponseEntity<Pedido> CreatePedido(@RequestBody Pedido pedido)
    {
        return new ResponseEntity<>(service.createPedido(pedido), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> GetPedidos()
    {
        return new ResponseEntity<>(service.getPedidos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> GetPedidoById(@PathVariable String id)
    {
        Optional<Pedido> pedidoAntigo = service.getPedidoById(id);

        if (pedidoAntigo.isPresent()) {
            return new ResponseEntity<>(pedidoAntigo.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> UpdatePedido(@PathVariable String id, Pedido pedido )
    {
        Optional<Pedido> antigoPedido = service.editPedidoById(id, pedido);

        if (antigoPedido.isPresent()) {
            return new ResponseEntity<>(antigoPedido.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> DeletePedido(@PathVariable String id)
    {
        Optional<Pedido> antigoPedido = service.getPedidoById(id);
        service.deletePedidoById(id);

        if (antigoPedido.isPresent()) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
