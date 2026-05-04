import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    List<Produto> listaProdutos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);

    }

    public void buscaProduto(String nome) {
        boolean produtoEncontrado = false;

        for (Produto encontraProduto : listaProdutos) {
            if (encontraProduto.nome.equals(nome)) {
                System.out.println("Produto encontrado " + encontraProduto.nome + " " + encontraProduto.id + ""
                        + encontraProduto.preco + " " + encontraProduto.quantidade);
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizaProduto(int idRecebido) {

        boolean idAtualizado = false;

        for (Produto atualizaproduto : listaProdutos) {
            if (idRecebido == atualizaproduto.id) {

                atualizaproduto.nome = "Caneta azul foi renomeada e passa a ser rosa";
                idAtualizado = true;
            }

        }

        if (!idAtualizado) {
            System.out.println("Id não encontrado");
        }

    }

    public void deleteProduto(int idDeletar) {
        boolean removido = listaProdutos.removeIf(produto -> produto.id == idDeletar);
        if (!removido) {
            System.out.println("Id Não encontrado");
        }
    }

    public void mostraProduto() {
        for (Produto produto : listaProdutos) {
            produto.exibirDetalhes();
        }
    }

}
