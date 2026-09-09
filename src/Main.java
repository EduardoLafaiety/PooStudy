public class Main {

    public static void main(String[] args) {

        ContaBancaria conta1 = new ContaBancaria("Eduardo", 123, 1000);


        conta1.receber(500);
        System.out.println("Saldo Conta 1: " + conta1.getSaldo());


        ContaBancaria conta2 = new ContaBancaria("Agatha Lafaiety", 321, 2500);

        conta2.receber(300);
        System.out.println("Saldo Conta 2: " + conta2.getSaldo());


        conta1.transferencia(5000, conta2);
        System.out.println("Saldo Conta 2: " + conta2.getSaldo());

        conta2.transferencia(200, conta1);
        System.out.println("Saldo Conta 1: " + conta1.getSaldo());

        System.out.println(conta1);
        System.out.println(conta2);

        ContaCorrente contaCorrente1 = new ContaCorrente("Pedro Muniz", 999, 7500, 350);

        System.out.println("O Saldo da Conta Corrente e De: " + contaCorrente1.getSaldo());
        contaCorrente1.cobrarTaxa();
        System.out.println("O Saldo da Conta Corrente Apos a Taxa de Manutencao!: " +contaCorrente1.getSaldo());


    }

}
