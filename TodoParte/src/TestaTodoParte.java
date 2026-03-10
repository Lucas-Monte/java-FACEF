import java.util.Date;

public class TestaTodoParte {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "Lucas Monteiro", "15968432597", "Rua Almada Prada, 360, Jardim Alvorada");

        Produto computador = new Produto(1, "Computador", 3500.00, 2);
        Produto celular = new Produto(2, "Celular Iphone 15", 4680.00, 3);
        Produto mouse = new Produto(3, "Mouse Óptico", 200, 6);
//        ItemPedido item1 = new ItemPedido(1, computador, 1);
//        ItemPedido item2 = new ItemPedido(2, celular, 1);
//        ItemPedido item3 = new ItemPedido(3, mouse, 1);

        Pedido p1 = new Pedido(1, new Date(), c1);
        p1.adicionaItem(1, computador, 3);
        p1.adicionaItem(2, celular, 1);
        p1.adicionaItem(3, mouse, 2);

        System.out.println(p1);
        
    }
}
