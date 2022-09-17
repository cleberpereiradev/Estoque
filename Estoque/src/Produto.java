public class Produto {
    private int codigo;
    private String descricao;
    private double valorUnitario;
    private int quantidade;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public boolean registrarEntrada(int qtdEntrada){
        if(qtdEntrada <= 0){
            return false;
        }else{
            quantidade = quantidade + qtdEntrada;
            return true;
        }
    }

    public boolean registrarSaida(int qtdRetirada){
        if(qtdRetirada > quantidade){
            System.out.println("Quantidade em estoque indisponível");
            return false;
        }else if(qtdRetirada <= 0){
            System.out.println("Valor inválido!");
            return false;
        }else{
            quantidade = quantidade - qtdRetirada;
            return true;
        }
    }

    public void exibirDados(){
        System.out.println("#######################################");
        System.out.println("Codigo: " + codigo);
        System.out.println("Descricao: " + descricao);
        System.out.println("Valor unitario R$ " + valorUnitario);
        System.out.println("Quantidade em estoque: " + quantidade);
        System.out.println("#######################################");
    }

}
