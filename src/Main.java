public class Main {

    // Metodo Principal Onde A Execucao Do Programa Comeca
    public static void main(String[] args) {

        // Polimorfismo: A Variavel E Do Tipo ContaBancaria
        // Mas O Objeto Real Criado E Uma ContaCorrente
        ContaBancaria conta1 = new ContaCorrente("Eduardo", 123, 1000, 50);

        // Chama Um Comportamento Herdado Da ContaBancaria
        conta1.receber(500);

        // Consulta O Saldo Atual Do Objeto
        System.out.println("Saldo Conta 1: " + conta1.getSaldo());


        // Outro Exemplo De Polimorfismo
        // A Referencia E ContaBancaria Mas O Objeto Real E ContaCorrente
        ContaBancaria conta2 = new ContaCorrente("Agatha Lafaiety", 321, 2500, 80);

        // Adiciona Dinheiro Ao Saldo Da Conta Dois
        conta2.receber(300);

        // Exibe O Saldo Atual Da Conta Dois
        System.out.println("Saldo Conta 2: " + conta2.getSaldo());


        // A Conta Um Tenta Transferir Dinheiro Para A Conta Dois
        // O Segundo Parametro E Outro Objeto Do Tipo ContaBancaria
        conta1.transferencia(5000, conta2);

        // Mostra O Saldo Da Conta Dois Depois Da Tentativa De Transferencia
        System.out.println("Saldo Conta 2: " + conta2.getSaldo());


        // Agora A Conta Dois Transfere Dinheiro Para A Conta Um
        conta2.transferencia(200, conta1);

        // Exibe O Novo Saldo Da Conta Um
        System.out.println("Saldo Conta 1: " + conta1.getSaldo());


        // Chama Automaticamente O Metodo ToString Do Objeto Conta Um
        System.out.println(conta1);

        // Chama Automaticamente O Metodo ToString Do Objeto Conta Dois
        System.out.println(conta2);


        // Aqui A Variavel E O Objeto Sao Do Tipo ContaCorrente
        ContaCorrente contaCorrente1 =
                new ContaCorrente("Pedro Muniz", 999, 7500, 350);

        // Consulta O Saldo Antes Da Cobranca Da Taxa
        System.out.println(
                "O Saldo da Conta Corrente e De: "
                        + contaCorrente1.getSaldo()
        );

        // Chama Um Metodo Que Existe Especificamente Em ContaCorrente
        contaCorrente1.cobrarTaxa();

        // Consulta O Saldo Depois Da Cobranca Da Taxa
        System.out.println(
                "O Saldo da Conta Corrente Apos a Taxa de Manutencao!: "
                        + contaCorrente1.getSaldo()
        );


        // Chama O Metodo ExibirDados
        // Como Conta Um E Realmente Uma ContaCorrente
        // Sera Executada A Versao Sobrescrita Da ContaCorrente
        conta1.exibirDados();


        // Chama Diretamente A Versao Sobrescrita Em ContaCorrente
        contaCorrente1.exibirDados();


        // Outro Exemplo De Polimorfismo
        // O Tipo Da Variavel E ContaBancaria
        // O Objeto Real E ContaCorrente
        ContaBancaria contaPolimorfica =
                new ContaCorrente("Carlos", 555, 3000, 100);

        // O Metodo Existe Em ContaBancaria
        // Mas A Versao Executada Sera A Da ContaCorrente
        // Porque O Objeto Real E Uma ContaCorrente
        contaPolimorfica.exibirDados();


        // Casting: A Referencia ContaBancaria Passa A Ser Tratada Como ContaCorrente
        // Nenhum Novo Objeto E Criado Aqui
        // As Duas Variaveis Apontam Para O Mesmo Objeto
        ContaCorrente contaCorrenteConvertida =
                (ContaCorrente) contaPolimorfica;

        // Agora Podemos Acessar Um Metodo Especifico De ContaCorrente
        contaCorrenteConvertida.cobrarTaxa();


        // Chama O Metodo Que Calcula A Tarifa
        // O Metodo Retorna Um Double
        System.out.println(contaCorrente1.calcularTarifa());

        Tributavel item = new ContaCorrente("Nikalus Maikonson" , 666, 20000, 500);

        System.out.println(item.calcularImposto());
        System.out.println("O Imposto Calculado E De: " + item.calcularImposto());



    }
}