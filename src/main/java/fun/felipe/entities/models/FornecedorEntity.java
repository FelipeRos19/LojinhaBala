package fun.felipe.entities.models;

public class FornecedorEntity {
    private int id;
    private String nome;
    private String endereco;

    public FornecedorEntity() {
    }

    public FornecedorEntity(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }
}
