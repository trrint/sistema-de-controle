public class Item {
    private String codigo;
    private String descricao;
    private double valor;
    private double acrescimo;
    private double desconto;

    public Item(String codigo, String descricao, double valor) {
        this.codigo = (codigo != null) ? codigo : "";
        this.descricao = descricao;
        this.valor = valor;
    }

    public Item() {

    }

    public void apilicarAcrescimo(double acrescimo){
        this.acrescimo += acrescimo;
        this.valor += acrescimo;
    }
    public void aplicarDesconto(double desconto){
        this.desconto += desconto;
        this.valor -= desconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carrinho Item { " +
                "Codigo do Item: " + codigo +
                ", Descrição: " + descricao +
                ", Valor: R$" + valor +
                ", Acrescimo: R$" + acrescimo +
                ", Desconto: R$" + desconto +
                " }";
    }
}
