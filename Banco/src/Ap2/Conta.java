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

    public class ValidaCPF {

        public boolean isCPF(String CPF) {
            System.out.println("digite seu cpf ");
            if (CPF.equals("00000000000") ||
                    CPF.equals("11111111111") ||
                    CPF.equals("22222222222") || CPF.equals("33333333333") ||
                    CPF.equals("44444444444") || CPF.equals("55555555555") ||
                    CPF.equals("66666666666") || CPF.equals("77777777777") ||
                    CPF.equals("88888888888") || CPF.equals("99999999999") ||
                    (CPF.length() != 11))
                return(false);

            char dig10, dig11;
            int sm, i, r, num, peso;


            try {

                sm = 0;
                peso = 10;
                for (i=0; i<9; i++) {

                    num = (int)(CPF.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11))
                    dig10 = '0';
                else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 11;
                for(i=0; i<10; i++) {
                    num = (int)(CPF.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11))
                    dig11 = '0';
                else dig11 = (char)(r + 48);


                if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                    return(true);
                else return(false);
            } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
    }

}
