package fun.felipe.entities.models;

public class VendaProdutoEntity {
    private int id;
    private int idProduto;
    private int quantidade;

    public VendaProdutoEntity() {
    }

    public VendaProdutoEntity(int idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public VendaProdutoEntity(int id, int idProduto, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
}
