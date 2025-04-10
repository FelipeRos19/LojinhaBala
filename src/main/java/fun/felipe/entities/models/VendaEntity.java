package fun.felipe.entities.models;

import java.time.LocalDateTime;
import java.util.List;

public class VendaEntity {
    private int id;
    private LocalDateTime data;
    private String cpf;
    private String formaPagamento;
    List<VendaProdutoEntity> produtos;
    private float total;
}
