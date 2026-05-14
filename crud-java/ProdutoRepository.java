import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    List<Produto> listaProdutos = new ArrayList<>();

    public boolean produtoDeletado(int idDeletar) {

        
        boolean removido = listaProdutos.removeIf(produto -> produto.id == idDeletar);
        return removido;
    }
}
