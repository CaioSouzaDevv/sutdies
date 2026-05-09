import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    List<Produto> listaProdutos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {

        listaProdutos.add(produto);

    }

    public void adicionarNovoProduto(Produto produto) {
        if (produto.id <= 0) {
            System.err.println("ID negativo ou igual a 0. tente novamente");
            return;
        }
        if (produto.preco <= 0) {
            System.out.println("Preço inválido, tente novamente.");
            return;
        }
        if (produto.quantidade <= 0) {
            System.out.println("Quantidade inválido, tente novamente.");
            return;
        }
        for (Produto produtoNovo : listaProdutos) {
            if (produtoNovo.id == produto.id) {
                System.out.println("ID duplicado ou inválido. Tente novamente");
                return;
            }
        }
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso.");

    }

    public void buscaProduto(String nome) {
        boolean produtoEncontrado = false;

        for (Produto encontraProduto : listaProdutos) {
            if (encontraProduto.nome.equalsIgnoreCase(nome)) {
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

    public void atualizaProduto(int idRecebido, String novoNome, double novoPreco, int novaQtd) {

        boolean idEncontrado = false;
        if (idRecebido <= 0) {
            System.out.println("Digite um id acima de 0.");
            return;
        }
        if (novoPreco <= 0) {
            System.out.println("Digite um valor de preço válido");
            return;
        }
        if (novaQtd <= 0) {
            System.out.println("Digite uma quantidade válida");
            return;
        }
        for (Produto produto : listaProdutos) {
            if (idRecebido == produto.id) {
                produto.nome = novoNome;
                produto.preco = novoPreco;
                produto.quantidade = novaQtd;
                System.out.println("Produto renomeado para " + novoNome);
                System.out.println("Produto com novo preço " + novoPreco);
                System.out.println("Nova quantidade disponivel " + novaQtd);
                idEncontrado = true;
            }
        }
        if (!idEncontrado) {
            System.out.println("Id não encontrado");
        }

    }

    public void deleteProduto(int idDeletar) {
        if(idDeletar <= 0) {
            System.out.println("ID negativo, por favor digite um ID válido.");
            return;
        }
        boolean removido = listaProdutos.removeIf(produto -> produto.id == idDeletar);
        if (!removido) {
            System.out.println("Id Não encontrado");
        } else {
            System.out.println("Produto deletado");
        }
    }

    public void buscaProdutoPorId(int buscaPorId) {
        boolean produtoEncontradoPorId = false;

        for (Produto produto : listaProdutos) {
            if (produto.id == buscaPorId) {
                System.out.println("Produto encontrado.");
                System.out.println("Nome: " + produto.nome);
                System.out.println("Id: " + produto.id);
                System.out.println("Preço: " + produto.preco);
                System.out.println("Quantidade: " + produto.quantidade);
                produtoEncontradoPorId = true;

            }
        }
        if (!produtoEncontradoPorId) {
            System.err.println("ID não registrado na base");
        }
    }

    public void mostraProduto() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Não temos produtos cadastrados");
        }
        for (Produto produto : listaProdutos) {
            System.out.println("-----------------");
            produto.exibirDetalhes();

        }

    }

}
