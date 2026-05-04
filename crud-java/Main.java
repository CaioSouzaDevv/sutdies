public class Main {
    public static void main(String[] args) {

        ProdutoService service = new ProdutoService();

        Produto p1 = new Produto();
        Produto p2 = new Produto();

        p1.id = 1;
        p1.nome = "Caneta Azul";
        p1.preco = 2.99;
        p1.quantidade = 100;

        p2.id = 2;
        p2.nome = "Caneta Vermelha";
        p2.preco = 2.99;
        p2.quantidade = 100;

        service.adicionarProduto(p1);
        service.adicionarProduto(p2);

        service.buscaProduto("Caneta Azul");
        service.atualizaProduto(1);
        service.deleteProduto(2);
        service.mostraProduto();
    }

}