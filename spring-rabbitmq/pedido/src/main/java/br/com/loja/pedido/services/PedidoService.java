package br.com.loja.pedido.services;

import br.com.loja.pedido.entities.Pedido;
import br.com.loja.pedido.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoRepository.findAll();
    }
}
