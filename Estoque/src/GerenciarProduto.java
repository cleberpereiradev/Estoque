import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciarProduto {

    List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarProduto gerenciar = new GerenciarProduto();
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        do{
            opcao = montarMenu(gerenciar, sc);
        }while(opcao != 9);
    }

    private static int montarMenu(GerenciarProduto gerenciar, Scanner sc){
        int opcao;
        System.out.println("-----------------------------------");
        System.out.println("Menu de gerenciamento");
        System.out.println("1- Cadastrar novo pedido");
        System.out.println("2- Registrar entrada em um produto");
        System.out.println("3- Registrar saida em um produto");
        System.out.println("4- Saldo de um produto");
        System.out.println("5- Listar produtos");
        System.out.println("6- Mostrar Patrimonio");
        System.out.println("9- Sair");
        System.out.println("-----------------------------------");
        System.out.println("Escolha uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());


        switch (opcao){
            case 1:
                gerenciar.execCadastrarNovo(sc);
                break;
            case 2:
                gerenciar.execRegistrarEntrada(sc, gerenciar);
                break;
            case 3:
                gerenciar.execRegistrarSaida(sc, gerenciar);
                break;
            case 4:
                gerenciar.execMostrarSaldo(sc, gerenciar);
                break;
            case 5:
                gerenciar.execMostrarTodos();
                break;
            case 6:
                gerenciar.execPatrimonioInventariado();
                break;
            case 9:
                System.out.println("FIM");
                break;
            default:
                System.out.println("Opcao invalida");
        }
        return opcao;
    }


    public void execCadastrarNovo(Scanner sc){
        //Cadastrar novo produto e adiciona na lista
        Produto produto = new Produto();
        System.out.println("Digite o codigo: ");
        produto.setCodigo(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite a descricao do produto: ");
        produto.setDescricao(sc.nextLine());
        System.out.println("Digite o valor unitario do produto R$ ");
        produto.setValorUnitario(Double.parseDouble(sc.nextLine()));

        //Adicionar no Array
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");

    }
    public void execRegistrarEntrada(Scanner sc, GerenciarProduto gerenciar){
        System.out.println("Digite o codigo do produto: ");
        int codProcurar = Integer.parseInt(sc.nextLine());
        Produto produto = gerenciar.procurarProduto(codProcurar);
        if(produto != null){
            //produto existe, registra entrada
            System.out.println("Digite a quantidade a ser adicionada: ");
            int qtdEntrada = Integer.parseInt(sc.nextLine());
            boolean ok = produto.registrarEntrada(qtdEntrada);
            if(ok){
                System.out.println("Entrada registrada do produto");
            }else{
                System.out.println("Quantidade invalida! Corrija!");
            }
        }
    }
    public void execRegistrarSaida(Scanner sc, GerenciarProduto gerenciar){
        System.out.println("Digite o codigo do produto: ");
        int codProcurar = Integer.parseInt(sc.nextLine());
        Produto produto = gerenciar.procurarProduto(codProcurar);
        if(produto != null){
            //produto existe, registra saida
            System.out.println("Digite a quantidade a ser retirada: ");
            int qtdEntrada = Integer.parseInt(sc.nextLine());
            boolean ok = produto.registrarSaida(qtdEntrada);
            if(ok){
                System.out.println("Saida efetuada com sucesso");
            }else{
                System.out.println("Quantidade indisponivel em estoque");
            }
        }

    }
    public void execMostrarSaldo(Scanner sc, GerenciarProduto gerenciar){
        int codProcurar;
        System.out.println("Digite o codigo do produto: ");
        codProcurar = Integer.parseInt(sc.nextLine());
        Produto produto = procurarProduto(codProcurar);
        if(produto != null){
            produto.exibirDados();
        }else{
            System.out.println("Produto nao cadastrado!");
        }

    }
    public void execMostrarTodos(){
        //Apresentar todos os produtos na tela

        for(Produto item : produtos){
            item.exibirDados();
        }

    }
    public void execPatrimonioInventariado(){
        double total = 0;
        for(Produto item : produtos){
            total += item.getValorUnitario() * item.getQuantidade();
        }
        System.out.println("Total em patrimonio R$" + total);
    }

    public Produto procurarProduto(int codProduto){
        for(Produto item : produtos){
            if(codProduto == item.getCodigo()){
                return item;
            }
        }
        return null;
    }
}
