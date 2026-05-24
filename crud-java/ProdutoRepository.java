import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    List<Produto> listaProdutos = new ArrayList<>();

    public boolean produtoAdicionado(Produto produto) {

        boolean produtoAdicionado = listaProdutos.add(produto);

        return produtoAdicionado;

    }

    public boolean produtoDeletado(int idDeletar) {
        boolean removido = listaProdutos.removeIf(produto -> produto.id == idDeletar);
        return removido;
    }

    public Produto produtoBuscadoPorId(int buscaPorId) {
        for (Produto produto : listaProdutos) {
            if (produto.id == buscaPorId) {
                return produto;
            }
        }
        return null;
    }

    public Produto produtoBuscadoPorNome(String nome) {

        for (Produto produto : listaProdutos) {
            if (produto.nome.equalsIgnoreCase(nome)) {

                return produto;
            }

        }
        return null;
    }

    public boolean produtoAtualizado(int idRecebido, String novoNome, double novoPreco, int novaQtd) {
        for (Produto produto : listaProdutos) {
            if (idRecebido == produto.id) {
                produto.nome = novoNome;
                produto.preco = novoPreco;
                produto.quantidade = novaQtd;

                return true;
            }

        }
        return false;
    }

    public boolean existeporId(int id) {

        for (Produto produto : listaProdutos) {
            if (produto.id == id) {
                return true;
            }
        }
        return false;
    }

public List<Produto> listarProdutos() {
    return listaProdutos;
}
}
