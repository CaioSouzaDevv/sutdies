import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    ProdutoRepository repository = new ProdutoRepository();

    public void adicionarNovoProduto(Produto produto) {
        if (produto.getNome().isBlank()) {
            mostrarSeparador();

            System.out.println("Digite um nome válido.");
            return;
        }
        if (produto.getId() <= 0) {
            mostrarSeparador();

            System.err.println("ID negativo ou igual a 0. tente novamente");
            return;
        }
        if (produto.getPreco() <= 0) {
            mostrarSeparador();

            System.out.println("Preço inválido, tente novamente.");
            return;
        }
        if (produto.getQuantidade() <= 0) {
            mostrarSeparador();

            System.out.println("Quantidade inválido, tente novamente.");
            return;
        }

        if (repository.existeporId(produto.getId()) == true) {
            System.out.println("ID duplicado ou inválido. Tente novamente");
            return;
        }

        boolean adicionado = repository.produtoAdicionado(produto);

        if (!adicionado) {
            System.out.println("Produto inválido");

            mostrarSeparador();
        } else {

            System.out.println("Produto cadastrado com sucesso.");
        }

    }

    public void buscaProduto(String nome) {
        Produto produto = repository.produtoBuscadoPorNome(nome);
        if (produto == null) {

            System.out.println("Produto não registrado na base");
        } else {

            System.out.println("Produto encontrado " + "ID: " + produto.getId());
            System.out.println("Produto encontrado " + "Nome: " + produto.getNome());
            System.out.println("Produto encontrado " + "Preço: " + produto.getPreco());
            System.out.println("Produto encontrado " + "Quantidade: " + produto.getQuantidade());
        }
    }

    public void mostrarSeparador() {
        System.out.println("-----------------");

    }

    public void atualizaProduto(int idRecebido, String novoNome, double novoPreco, int novaQtd) {
        if (novoNome.isBlank()) {
            mostrarSeparador();
            System.out.println("Digite um nome válido");
            return;
        }
        if (idRecebido <= 0) {
            mostrarSeparador();
            System.out.println("Digite um id acima de 0.");
            return;
        }
        if (novoPreco <= 0) {
            mostrarSeparador();
            System.out.println("Digite um valor de preço válido");
            return;
        }
        if (novaQtd <= 0) {
            mostrarSeparador();
            System.out.println("Digite uma quantidade válida");
            return;
        }
        boolean produtoAtualizado = repository.produtoAtualizado(idRecebido, novoNome, novoPreco, novaQtd);

        if (produtoAtualizado == false) {
            System.out.println("Id não encontrado");
        } else {
            System.out.println("Produto atualizado com sucesso.");
            mostrarSeparador();
            System.out.println("Nome:" + novoNome);
            System.out.println("Preço: " + novoPreco);
            System.out.println("Quantidade:  " + novaQtd);

        }

    }

    public void deleteProduto(int idDeletar) {
        if (idDeletar <= 0) {
            mostrarSeparador();

            System.out.println("ID negativo, por favor digite um ID válido.");
            return;
        }

        boolean removido = repository.produtoDeletado(idDeletar);

        if (!removido) {
            mostrarSeparador();

            System.out.println("Id Não encontrado");
        } else {
            mostrarSeparador();

            System.out.println("Produto deletado");
        }
    }

    public void buscaProdutoPorId(int buscaPorId) {

        if (buscaPorId <= 0) {
            mostrarSeparador();

            System.out.println("Digite um ID válido.");
            return;
        }

        Produto produto = repository.produtoBuscadoPorId(buscaPorId);

        mostrarSeparador();

        mostrarSeparador();

        if (produto == null) {

            System.err.println("ID não registrado na base");
        } else {
            System.out.println(produto.getId());
            System.out.println(produto.getNome());
            System.out.println(produto.getPreco());
            System.out.println(produto.getQuantidade());
        }

    }

    public void mostraProduto() {

        List<Produto> produtos = repository.listarProdutos();

        if (produtos.isEmpty()) {
            mostrarSeparador();
            System.out.println("Não temos produtos cadastrados");
        } else {
            for (Produto produto : produtos) {
                mostrarSeparador();
                produto.exibirDetalhes();
            }
        }

    }

}