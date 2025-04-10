package fun.felipe.entities.models;

public class ProdutoEntity {
    private int id;
    private int idFornecedor;
    private String titulo;
    private float valorUnitario;
    private int quantidade;

    public ProdutoEntity() {
    }

    public ProdutoEntity(int id, String titulo, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.quantidade = quantidade;
    }

    public ProdutoEntity(int id, int idFornecedor, String titulo, float valorUnitario, int quantidade) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.titulo = titulo;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "id=" + id +
                ", idFornecedor=" + idFornecedor +
                ", titulo='" + titulo + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                '}';
    }
}
