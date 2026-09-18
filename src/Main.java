import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Criamos Primeiro Os Clientes
        Cliente Eduardo = new Cliente(
                "Eduardo",
                "111.111.111-11"
        );

        Cliente Agatha = new Cliente(
                "Agatha Lafaiety",
                "222.222.222-22"
        );

        Cliente Pedro = new Cliente(
                "Pedro Muniz",
                "333.333.333-33"
        );

        Cliente Carlos = new Cliente(
                "Carlos",
                "444.444.444-44"
        );

        Cliente NiKalus = new Cliente(
                "Nikalus Maikonson",
                "555.555.555-55"
        );

        Cliente Eliane = new Cliente(

                "Eliane Ximenes",
                "01010127055"
        );


        // A Conta Agora Recebe Um Objeto Cliente
        ContaBancaria Conta1 =
                new ContaCorrente(
                        Eduardo,
                        123,
                        1000,
                        50
                );

        Conta1.receber(500);

        System.out.println(
                "Saldo Conta 1: "
                        + Conta1.getSaldo()
        );


        // Outra Conta Recebe Outro Objeto Cliente
        ContaBancaria Conta2 =
                new ContaCorrente(
                        Agatha,
                        321,
                        2500,
                        80
                );

        Conta2.receber(300);

        System.out.println(
                "Saldo Conta 2: "
                        + Conta2.getSaldo()
        );


        // Transferencia Entre Dois Objetos ContaBancaria
        Conta1.transferencia(5000, Conta2);

        System.out.println(
                "Saldo Conta 2: "
                        + Conta2.getSaldo()
        );


        Conta2.transferencia(200, Conta1);

        System.out.println(
                "Saldo Conta 1: "
                        + Conta1.getSaldo()
        );


        // ToString Das Contas
        System.out.println(Carlos);
        System.out.println(Conta2);


        // Aqui Variavel E Objeto São ContaCorrente
        ContaCorrente contaCorrente1 =
                new ContaCorrente(
                        Pedro,
                        999,
                        7500,
                        350
                );

        System.out.println(
                "O Saldo Da Conta Corrente E De: "
                        + contaCorrente1.getSaldo()
        );

        contaCorrente1.cobrarTaxa();

        System.out.println(
                "O Saldo Da Conta Corrente Apos A Taxa De Manutencao E: "
                        + contaCorrente1.getSaldo()
        );


        // Polimorfismo
        Conta1.exibirDados();

        contaCorrente1.exibirDados();


        // Tipo Da Variavel ContaBancaria
        // Objeto Real ContaCorrente
        ContaBancaria contaPolimorfica =
                new ContaCorrente(
                        Carlos,
                        555,
                        3000,
                        100
                );

        contaPolimorfica.exibirDados();


        // Casting
        // As Duas Variaveis Apontam Para O Mesmo Objeto
        ContaCorrente contaCorrenteConvertida =
                (ContaCorrente) contaPolimorfica;

        contaCorrenteConvertida.cobrarTaxa();


        // Calcula A Tarifa
        System.out.println(
                contaCorrente1.calcularTarifa()
        );


        // Polimorfismo Pela Interface
        Tributavel item =
                new ContaCorrente(
                        NiKalus,
                        666,
                        20000,
                        500
                );

        System.out.println(
                item.calcularImposto()
        );

        System.out.println(
                "O Imposto Calculado E De: "
                        + item.calcularImposto()
        );


        // Criamos Um Cliente Para A Conta Poupanca
        Cliente clientePoupanca =
                new Cliente(
                        "Eduardo Lopes",
                        "666.666.666-66"
                );

        // Polimorfismo
        // Tipo Da Variavel ContaBancaria
        // Objeto Real ContaPoupanca
        ContaBancaria poupanca =
                new ContaPoupanca(
                        clientePoupanca,
                        255,
                        30000,
                        300
                );

        poupanca.exibirDados();

        List <ContaBancaria> ListaDeContas = new ArrayList<>();
        ListaDeContas.add(Conta1);
        ListaDeContas.add(Conta2);
        ListaDeContas.add(poupanca);

        int numeroBuscado = 321;
        boolean encontrou = false;

        for (ContaBancaria Conta : ListaDeContas) {

            if (Conta.getNumeroDaConta() == numeroBuscado) {

                encontrou = true;

                System.out.println(Conta);

                break;
            }
        }

        if (!encontrou) {

            System.out.println("Conta Nao Encontrada");
        }

        int numeroParaRemover = 321;

        ContaBancaria contaParaRemover = null;

        for (ContaBancaria Conta : ListaDeContas) {

            if (Conta.getNumeroDaConta() == numeroParaRemover) {

                contaParaRemover = Conta;

                break;
            }
        }

        if (contaParaRemover != null) {

            ListaDeContas.remove(contaParaRemover);

            System.out.println("Conta Removida Com Sucesso!");

        } else {

            System.out.println("Conta Nao Encontrada");
        }

        int numeroParaReceber = 321;

        ContaBancaria contaParaReceber = null;

        for (ContaBancaria conta : ListaDeContas) {

            if (conta.getNumeroDaConta() == numeroParaReceber) {

                contaParaReceber = conta;

                break;
            }
        }

        if (contaParaReceber != null) {

            contaParaReceber.receber(500);

            System.out.println("Valor Recebido Com Sucesso!");

            System.out.println(
                    "Novo Saldo: "
                            + contaParaReceber.getSaldo()
            );

        } else {

            System.out.println("Conta Nao Encontrada");
        }

        Banco GerenciadorDeContas = new Banco();


        GerenciadorDeContas.cadastrarConta(Conta1);
        System.out.println("Conta1 Cadastrada");
        GerenciadorDeContas.cadastrarConta(Conta2);
        System.out.println("Conta2 Cadastrada");
        GerenciadorDeContas.cadastrarConta(poupanca);
        System.out.println("Conta3 Cadastrada");

        GerenciadorDeContas.listasContas();


    }
}