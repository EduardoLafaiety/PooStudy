// Abstract Indica Que Esta Classe Serve Como Base Para Outras Classes
// Ela Nao Pode Ser Instanciada Diretamente Com New ContaBancaria
public abstract class ContaBancaria {

    // Agora A Conta Guarda Um Objeto Cliente Inteiro
    private Cliente titularDaConta;

    // Private Protege O Numero Da Conta
    private int numeroDaConta;

    // Protected Permite Que Classes Filhas Como ContaCorrente Acessem O Saldo
    protected double saldo;


    // O Construtor Agora Recebe Um Cliente Inteiro
    public ContaBancaria(
            Cliente titularDaConta,
            int numeroDaConta,
            double saldo
    ) {

        // Guarda O Objeto Cliente Dentro Da Conta
        this.titularDaConta = titularDaConta;

        // Guarda O Numero Recebido No Atributo Do Objeto
        this.numeroDaConta = numeroDaConta;

        // Guarda O Saldo Recebido No Atributo Do Objeto
        this.saldo = saldo;
    }


    // Metodo Que Modifica O Estado Do Objeto Aumentando O Seu Saldo
    void receber(double valorRecebido) {

        saldo += valorRecebido;
    }


    // Getter Permite Consultar O Saldo
    public double getSaldo() {
        return saldo;
    }


    // Getter Permite Consultar O Cliente Titular Da Conta
    public Cliente getTitularDaConta() {
        return titularDaConta;
    }


    // Getter Permite Consultar O Numero Da Conta
    public int getNumeroDaConta() {
        return numeroDaConta;
    }


    // Metodo Que Recebe Um Valor E Outra Conta Como Parametros
    void transferencia(
            double valorTransferido,
            ContaBancaria contaDestino
    ) {

        if (valorTransferido > saldo) {

            System.out.println("Saldo Insuficiente!");

        } else {

            saldo -= valorTransferido;

            contaDestino.receber(valorTransferido);
        }
    }


    // Exibe Os Dados Da Conta E Tambem Os Dados Do Cliente
    void exibirDados() {

        System.out.println(
                "Nome Do Titular: "
                        + titularDaConta.getNome()
        );

        System.out.println(
                "CPF Do Titular: "
                        + titularDaConta.getCpf()
        );

        System.out.println(
                "Numero Da Conta: "
                        + numeroDaConta
        );

        System.out.println(
                "Saldo Da Conta: "
                        + saldo
        );
    }


    @Override
    public String toString() {

        return "ContaBancaria [" +
                "Titular: " + titularDaConta.getNome() +
                ", CPF: " + titularDaConta.getCpf() +
                ", Numero: " + numeroDaConta +
                ", Saldo: R$ " + saldo +
                ']';
    }


    // Cada Tipo Concreto De Conta Deve Implementar a Sua Propria Tarifa
    public abstract double calcularTarifa();
}