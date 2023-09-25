import java.util.ArrayList;

public class Carrinho {
    ArrayList<Item> itens = new ArrayList<>();
    private double descontoTotal = 0;
    private double acrescimoTotal = 0;

    public void inserirItem (String codigo, String descricao, double valor){
        Item item = new Item(codigo, descricao, valor);
        itens.add(item);
    }
    public void aplicarAcrecimoIndividual(String codigo, double acrescimo){
        for(Item items : itens){
            if(items.getCodigo().equals(codigo)){
                items.apilicarAcrescimo(acrescimo);
                acrescimoTotal+=acrescimo;
                break;
            }
        }
    }
    public void aplicarDescontoIndividual(String codigo, double desconto){
        for(Item items : itens){
            if(items.getCodigo().equals(codigo)){
                items.aplicarDesconto(desconto);
                descontoTotal+=desconto;
            }
        }
    }
    public void aplicarAcrescimoTotal(double acrescimo){
        int numItems = itens.size();
        double acrescimoPorItem = acrescimo / numItems;
        for (Item items : itens){
            items.apilicarAcrescimo(acrescimoPorItem);
            acrescimoTotal += acrescimoPorItem;
        }
    }
    public void aplicarDescontoTotal(double desconto){
        int numItens = itens.size();
        double descontoPorItem = desconto / numItens;
        for (Item item : itens) {
            item.aplicarDesconto(descontoPorItem);
            descontoTotal += descontoPorItem;
        }
    }
    public void finalizarCompra(){
        double valorTotal = 0;
        for (Item item : itens){
            valorTotal += item.getValor();
        }

        System.out.println("Itens do Carrinho:");
        for (Item item : itens){
            System.out.println(item.toString());
        }

        System.out.println("Desconto Total: " + descontoTotal);
        System.out.println("Acrescimo Total: " + acrescimoTotal);
        System.out.println("Valor Total: " + valorTotal);
    }
}
