package Ap2;
import java.util.InputMismatchException;
import java.util.Scanner;

class Conta {
    private String nome;
    private int conta, saques;
    private double saldo;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome, int conta, double saldo_inicial){
        this.nome=nome;
        this.conta=conta;
        this.saldo=saldo_inicial;
        this.saques=0;
    }

    public void extrato(){
        System.out.println("EXTRATO");
        System.out.println("Nome: " + this.nome);
        System.out.println("Número da conta: " + this.conta);
        System.out.printf("Saldo atual: " + this.saldo);
        System.out.println("Saques realizados hoje: " + this.saques + "");



    }

    public void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            saques++;
            sacar(saldo - valor);
            System.out.println("Sacado: " + valor);
            System.out.println("Novo saldo: " + saldo + "\n");
        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }

    public void depositar(double valor)
    {
        saldo += valor;
        System.out.println("Depositado: " + valor);
        System.out.println("Novo saldo: " + saldo + "\n");
    }

    public void iniciar(){
        int opcao;

        do{
            exibeMenu();
            opcao = entrada.nextInt();
            EscolheOpcao(opcao);
        }while(opcao!=4);
    }

    public void exibeMenu(){
        System.out.println(" ");
        System.out.println("Escolha a opção desejada " );
        System.out.println("1 - Consultar Extrato" );
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sair\n");
        System.out.print("Opção: ");

    }

    public void EscolheOpcao(int opcao){
        double valor;

        switch( opcao ){
            case 1:
                extrato();
                break;
            case 2:
                if(saques<3){
                    System.out.print("Quanto quer sacar Sr(a) :" + nome);
                    valor = entrada.nextDouble();
                    sacar(valor);
                } else{
                    System.out.println("Limite de saques diários atingidos.\n");
                }
                break;

            case 3:
                System.out.print("Quanto deseja depositar Sr(a)" + this.nome );
                valor = entrada.nextDouble();
                depositar(valor);
                break;

            case 4:
                System.out.println("Sistema encerrado." + nome);
                break;

            default:
                System.out.println("Opção inválida Sr(a) " + nome );
        }
    }
}
    
   
