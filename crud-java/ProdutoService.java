import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    List<Produto> listaProdutos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {

        listaProdutos.add(produto);

    }

    public void adicionarNovoProduto(Produto produto) {
        for (Produto produtoNovo : listaProdutos) {
            if (produtoNovo.id == produto.id) {
                System.out.println("ID duplicado. Tente novamente");
                return;
            }
        }
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso.");

    }

    public void buscaProduto(String nome) {
        boolean produtoEncontrado = false;

        for (Produto encontraProduto : listaProdutos) {
            if (encontraProduto.nome.equals(nome)) {
                System.out.println("Produto encontrado " + "ID: " + encontraProduto.id);
                System.out.println("Produto encontrado " + "Nome: " + encontraProduto.nome);
                System.out.println("Produto encontrado " + "Preço: " + encontraProduto.preco);
                System.out.println("Produto encontrado " + "Quantidade: " + encontraProduto.quantidade);

                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizaProduto(int idRecebido, String novoNome) {

        boolean idEncontrado = false;
        for (Produto produto : listaProdutos) {
            if (idRecebido == produto.id) {
                produto.nome = novoNome;
                System.out.println("Produto renomeado para " + novoNome);
                idEncontrado = true;
            } 
        }
        if (!idEncontrado) {
            System.out.println("Id não encontrado");
        }

    }

    public void deleteProduto(int idDeletar) {
        boolean removido = listaProdutos.removeIf(produto -> produto.id == idDeletar);
        if (!removido) {
            System.out.println("Id Não encontrado");
        } else {
            System.out.println("Produto deletado");
        }
    }

    public void mostraProduto() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Não temos produtos cadastrados");
        }
        for (Produto produto : listaProdutos) {

            produto.exibirDetalhes();
        }

    }

}
