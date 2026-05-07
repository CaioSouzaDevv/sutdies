import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProdutoService service = new ProdutoService();

     

        service.mostraProduto();

        Scanner menu = new Scanner(System.in);

        int escolha = -1;

        while (escolha != 0) {
            System.err.println("Menu");
            System.err.println("0- Sair");
            System.err.println("1- Buscar Produto por nome");
            System.err.println("2- Atualizar Produto por ID");
            System.err.println("3- Deletar Produto por ID");
            System.err.println("4- Lista Produto");
            System.err.println("5- Adicionar Produto");

            System.err.println("Escolha uma opção");

            if (menu.hasNextInt()) {
                escolha = menu.nextInt();

                switch (escolha) {
                    case 0:
                        break;
                    case 1:
                        menu.nextLine();
                        System.out.println("Digite o nome do produto");
                        String nome = menu.nextLine();
                        service.buscaProduto(nome);
                        
                        break;

                    case 2:
                        menu.nextLine();
                        System.out.println("Digite o número do id");
                    
                        int idRecebido = menu.nextInt();
                        menu.nextLine();

                        System.out.println("Digite o novo nome");
                        String novoNome = menu.nextLine();

                        service.atualizaProduto(idRecebido, novoNome);

                        

                        break;

                    case 3:
                        menu.nextLine();
                        System.out.println("Digite o id para deletar");
                        int idDeletar = menu.nextInt();
                        service.deleteProduto(idDeletar);
                        service.mostraProduto();
                        
                        break;

                    case 4:
                        service.mostraProduto();
                        break;

                    case 5:
                        System.out.println("Digite o id do novo produto");
                        
                        int recebeIdCadastro = menu.nextInt();
                        menu.nextLine();
                        System.out.println("Digite o nome do novo produto");
                        String recebeNomeCadastro = menu.nextLine();
                        System.out.println("Digite o preco do novo produto");
                        double recebePrecoCadastro = menu.nextDouble();

                        System.out.println("Digite a quantidade do novo produto");
                        int recebeQtdCadastro = menu.nextInt();

                        Produto p3 = new Produto();

                        p3.id = recebeIdCadastro;
                        p3.nome = recebeNomeCadastro;
                        p3.preco = recebePrecoCadastro;
                        p3.quantidade = recebeQtdCadastro;

                        

                        service.adicionarNovoProduto(p3);
                        break;

                    default:
                        break;
                }
            } else {
                System.out.println("Escolha uma opção");
            }
        }
    }

}