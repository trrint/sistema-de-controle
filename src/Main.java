import java.util.Scanner;

public class Main extends Carrinho {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();
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
                case 1 -> {
                    // Inserir item ao carrinho
                    String codigo = Integer.toString(nextCode++); // Gere o código automaticamente
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.next();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Digite o valor do produto: ");
                    double valor = scanner.nextDouble();
                    carrinho.inserirItem(codigo, descricao, valor);
                }
                case 2 -> {
                    // Acréscimo de item
                    System.out.print("Digite o código do produto: ");
                    String codigoAcrecimo = scanner.next();
                    boolean codigoEncontradoAcrecimo = false;
                    for (Item item : carrinho.itens) {
                        if (item.getCodigo().equals(codigoAcrecimo)) {
                            codigoEncontradoAcrecimo = true;
                            System.out.print("Digite o valor de acréscimo: ");
                            double acrescimo = scanner.nextDouble();
                            carrinho.aplicarAcrecimoIndividual(codigoAcrecimo, acrescimo);
                            break;
                        }
                    }
                    if (!codigoEncontradoAcrecimo) {
                        System.out.println("Código do produto não encontrado.");
                    }
                }
                case 3 -> {
                    // Desconto de item
                    System.out.print("Digite o código do produto: ");
                    String codigoDesconto = scanner.next();
                    boolean codigoEncontradoDesconto = false;
                    for (Item item : carrinho.itens) {
                        if (item.getCodigo().equals(codigoDesconto)) {
                            codigoEncontradoDesconto = true;
                            System.out.print("Digite o valor de desconto: ");
                            double desconto = scanner.nextDouble();
                            carrinho.aplicarDescontoIndividual(codigoDesconto, desconto);
                            break;
                        }
                    }
                    if (!codigoEncontradoDesconto) {
                        System.out.println("Código do produto não encontrado.");
                    }
                }
                case 4 -> {
                    // Acréscimo total
                    System.out.print("Digite o valor total de acréscimo: ");
                    double acrescimoTotal = scanner.nextDouble();
                    carrinho.aplicarAcrescimoTotal(acrescimoTotal);
                }
                case 5 -> {
                    // Desconto total
                    System.out.print("Digite o valor total de desconto: ");
                    double descontoTotal = scanner.nextDouble();
                    carrinho.aplicarDescontoTotal(descontoTotal);
                }
                case 6 ->
                    // Finalizar venda
                        carrinho.finalizarCompra();
                case 7 -> {
                    // Sair do programa
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}