package br.com.loja.pedido.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
