import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nome;
        int codigo;
        String categoria;
        double preco;
        int quantidade;
        boolean sistemaAtivo = true;

        int totalProdutos = 0;

        Produto[] produtos = new Produto[100];

        while (sistemaAtivo){

           System.out.println("==== SISTEMA DE PRODUTOS ====");
           System.out.println("1)- Cadastrar produtos");
           System.out.println("2)- Listar produtos");
           System.out.println("3)- buscar produto pelo código");
           System.out.println("4)- Atualizar estoque");
           System.out.println("5)- Exibir valores total do estoque");
           System.out.println("6)- Sair");

           int opcao = leitor.nextInt();
           switch (opcao){

               case 1:
                   System.out.println("Qual o nome do produto?");
                   leitor.nextLine();
                   nome = leitor.nextLine();
                   System.out.println("Qual o codigo do produto?");
                   codigo = leitor.nextInt();
                   boolean codigoExiste = false;
                   if (codigo <= 0){
                       System.out.println("Digite um numero valido! (Exemplo: maior que 0)");
                       continue;
                   }
                   for (int i = 0; i < totalProdutos; i++){
                       if (codigo == produtos[i].getCodigo()){
                           codigoExiste = true;
                           break;
                       }
                   }
                   if (codigoExiste){
                       System.out.println("Esse codigo já existe! Digite um novo");
                       continue;
                   }
                   leitor.nextLine();
                   System.out.println("Qual a categoria do produto?");
                   categoria = leitor.nextLine();
                   System.out.println("Digite o preco do produto?");
                   preco = leitor.nextDouble();
                   if (preco <= 0){
                       System.out.println("Digite um numero valido!");
                       continue;
                   }
                   System.out.println("Qual a quantidade do produto?");
                   quantidade = leitor.nextInt();
                    if (quantidade < 0){
                        System.out.println("Digite um numero valido!");
                        continue;
                    }

                    Produto produto = new Produto(nome, codigo, categoria, preco, quantidade);

                   produtos[totalProdutos] = produto;
                   totalProdutos ++;
                   break;

               case 2:
                   if (totalProdutos == 0){
                       System.out.println("Nenhum produto cadastrado");
                            continue;
                   }else {
                       for (int i = 0; i < totalProdutos; i++){
                           System.out.println("Nome: " + produtos[i].getNome());
                           System.out.println("Preco: " + produtos[i].getPreco());
                           System.out.println("Categoria: " + produtos[i].getCategoria());
                           System.out.println("Codigo: " + produtos[i].getCodigo());
                           System.out.println("Estoque: " + produtos[i].getQuantidade());
                       }
                   }break;

               case 3:
                   boolean encontrou = false;
                   System.out.println("Qual o codigo do produto desejado?");
                   int codigoProduto = leitor.nextInt();
                   for (int i = 0; i < totalProdutos; i++){


                       if (codigoProduto == produtos[i].getCodigo() ){
                           System.out.println("Nome: " + produtos[i].getNome());
                           System.out.println("Preco: " + produtos[i].getPreco());
                           System.out.println("Categoria: " + produtos[i].getCategoria());
                           System.out.println("Codigo: " + produtos[i].getCodigo());
                           System.out.println("Estoque: " + produtos[i].getQuantidade());
                            encontrou = true;
                            break;
                        }
                   }
                   if (!encontrou){
                       System.out.println("Produto Não encontrado");
                   }break;

               case 4:
                   boolean encontrouProduto = false;
                   System.out.println("\nATUALIZAÇÃO DE ESTOQUE:");
                   System.out.println("Qual o codigo do produto?");
                   codigoProduto = leitor.nextInt();
                   System.out.println("Qual a nova quantidade no estoque?");
                   int novoEstoque = leitor.nextInt();
                   if (novoEstoque < 0){
                       System.out.println("Digite um numero valido!");
                       continue;
                   }else {
                       for (int i = 0; i < totalProdutos; i++){

                           if (codigoProduto == produtos[i].getCodigo()){

                               produtos[i].setQuantidade(novoEstoque);
                               encontrouProduto = true;
                               break;
                           }

                       }
                   }


                    if (!encontrouProduto){
                        System.out.println("Produto não encontrado");
                    }break;

               case 5:
                   double valorTotalEstoque = 0;
                   double valorProdutos = 0;
                   for (int i = 0; i < totalProdutos; i++){

                       valorProdutos = produtos[i].getPreco() * produtos[i].getQuantidade();
                       valorTotalEstoque += valorProdutos;
                   }
                   System.out.println("O valor total é: " + valorTotalEstoque);
                   break;

               case 6:
                   System.out.println("Até mais!");
                   sistemaAtivo = false;
                   break;

               default:
                   System.out.println("Digite um numero valido! (Exemplo: maior que 0)");
           }


        }




    }
}