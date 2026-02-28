package br.com.loja.pagamento.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

}
