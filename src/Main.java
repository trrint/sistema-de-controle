import java.util.Scanner;

public class Main extends Carrinho {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();
        Item item = new Item();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");

            System.out.println("1. Inserir item ao carrinho");
            System.out.println("2. Acréscimo de item");
            System.out.println("3. Desconto de item");
            System.out.println("4. Acréscimo total");
            System.out.println("5. Desconto total");
            System.out.println("6. Finalizar venda");

            System.out.println("7. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Inserir item ao carrinho
                    System.out.print("Digite o código do produto: ");
                    String codigo = scanner.next();
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.next();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Digite o valor do produto: ");
                    double valor = scanner.nextDouble();
                    carrinho.inserirItem(codigo, descricao, valor);
                    break;
                case 2:
                    // Acréscimo de item
                    System.out.print("Digite o código do produto: ");
                    String codigoAcrecimo = scanner.next();
                    if(item.getCodigo().equals(codigoAcrecimo)){
                        System.out.print("Digite o valor de acréscimo: ");
                        double acrescimo = scanner.nextDouble();
                        carrinho.aplicarAcrecimoIndividual(codigoAcrecimo, acrescimo);
                    } else {
                        System.out.println("Não possui este codigo cadastrado.");
                    }
                    break;
                case 3:
                    // Desconto de item
                    System.out.print("Digite o código do produto: ");
                    String codigoDesconto = scanner.next();
                    if(item.getCodigo().equals(codigoDesconto)){
                        System.out.print("Digite o valor de desconto: ");
                        double desconto = scanner.nextDouble();
                        carrinho.aplicarDescontoIndividual(codigoDesconto, desconto);
                    } else {
                        System.out.println("Não possui este codigo cadastrado.");
                    }
                    break;
                case 4:
                    // Acréscimo total
                    System.out.print("Digite o valor total de acréscimo: ");
                    double acrescimoTotal = scanner.nextDouble();
                    carrinho.aplicarAcrescimoTotal(acrescimoTotal);
                    break;
                case 5:
                    // Desconto total
                    System.out.print("Digite o valor total de desconto: ");
                    double descontoTotal = scanner.nextDouble();
                    carrinho.aplicarDescontoTotal(descontoTotal);
                    break;
                case 6:
                    // Finalizar venda
                    carrinho.finalizarCompra();
                    break;
                case 7:
                    // Sair do programa
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}