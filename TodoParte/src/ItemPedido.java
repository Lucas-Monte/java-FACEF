public class ItemPedido {
    private int id;
    private int quantidade;
    private Produto produto;

    public ItemPedido(int id, Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemPedido() {
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto +
                ",\nquantidade=" + quantidade +
                '}';
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
