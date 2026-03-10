import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//Exercicio: Calcular o total do pedido

public class Pedido {
    private int id;
    private Date data;
    private Cliente cliente; //associação todo-parte
    private ArrayList<ItemPedido> itens;
    private double totalPedido;

    public Pedido(int id, Date data, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.totalPedido = 0;
    }

    public Pedido() {
        this.itens = new ArrayList<>();
        this.totalPedido = 0;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                ", cliente=\n" + cliente +
                ", itens=\n" + itens +
                ", totalPedido=" + totalPedido +
                '}';
    }

    public void adicionaItem(int id, Produto produto, int quantidade) {
        if (quantidade > produto.getEstoque()) {
            System.out.println("Estoque indisponível!");
        } else {
            ItemPedido aux = new ItemPedido(id, produto, quantidade);
            itens.add(aux);
            System.out.println("Item adicionado com sucesso!");
            totalPedido += (aux.getQuantidade()*produto.getPreco());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
