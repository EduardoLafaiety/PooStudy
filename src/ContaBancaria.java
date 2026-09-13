// Abstract Indica Que Esta Classe Serve Como Base Para Outras Classes
// Ela Nao Pode Ser Instanciada Diretamente Com New ContaBancaria
public abstract class ContaBancaria implements Tributavel {

    // Private Protege O Atributo Contra Acesso Direto Fora Desta Classe
    private String nomeDoTitular;

    // Private Protege O Numero Da Conta
    private int numeroDaConta;

    // Protected Permite Que Classes Filhas Como ContaCorrente Acessem O Saldo
    protected double saldo;


    // Construtor Responsavel Por Inicializar A Parte ContaBancaria Do Objeto
    public ContaBancaria(
            String nomeDoTitular,
            int numeroDaConta,
            double saldo
    ) {

        // This NomeDoTitular Representa O Atributo Deste Objeto
        // NomeDoTitular Representa O Parametro Recebido Pelo Construtor
        this.nomeDoTitular = nomeDoTitular;

        // Guarda O Numero Recebido No Atributo Do Objeto
        this.numeroDaConta = numeroDaConta;

        // Guarda O Saldo Recebido No Atributo Do Objeto
        this.saldo = saldo;
    }


    // Metodo Que Modifica O Estado Do Objeto Aumentando Seu Saldo
    void receber(double valorRecebido) {

        // Soma O Valor Recebido Ao Saldo Atual
        saldo += valorRecebido;
    }


    // Getter Permite Consultar O Saldo Sem Permitir Alteracao Direta
    public double getSaldo() {
        return saldo;
    }


    // Setter Privado So Pode Ser Utilizado Dentro Da Propria ContaBancaria
    // Atualmente Este Metodo Nao Esta Sendo Utilizado
    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    // Getter Privado So Pode Ser Utilizado Dentro Desta Classe
    // Atualmente Este Metodo Nao Esta Sendo Utilizado
    private String getNomeDoTitular() {
        return nomeDoTitular;
    }


    // Setter Privado So Pode Ser Utilizado Dentro Desta Classe
    // Atualmente Este Metodo Nao Esta Sendo Utilizado
    private void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }


    // Getter Privado So Pode Ser Utilizado Dentro Desta Classe
    // Atualmente Este Metodo Nao Esta Sendo Utilizado
    private int getNumeroDaConta() {
        return numeroDaConta;
    }


    // Setter Privado So Pode Ser Utilizado Dentro Desta Classe
    // Atualmente Este Metodo Nao Esta Sendo Utilizado
    private void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }


    // Metodo Que Recebe Um Valor E Outra Conta Como Parametros
    void transferencia(
            double valorTransferido,
            ContaBancaria contaDestino
    ) {

        // Verifica Se A Conta Possui Saldo Suficiente
        if (valorTransferido > saldo) {

            System.out.println("Saldo Insuficiente!");

        } else {

            // Retira O Dinheiro Da Conta Atual
            saldo -= valorTransferido;

            // Envia O Mesmo Valor Para O Outro Objeto
            contaDestino.receber(valorTransferido);
        }
    }


    // Metodo Que Exibe O Estado Atual Do Proprio Objeto
    // Nao Precisa Receber Parametros Pois O Objeto Ja Possui Esses Dados
    void exibirDados() {

        System.out.println(
                "Nome do Titular da Conta Corrente: "
                        + nomeDoTitular
        );

        System.out.println(
                "Numero da Conta Corrente do Titular: "
                        + numeroDaConta
        );

        System.out.println(
                "Saldo da Conta Corrente: "
                        + saldo
        );
    }


    // Override Indica Que Estamos Sobrescrevendo Um Metodo Herdado De Object
    @Override
    public String toString() {

        // Retorna Uma Representacao Em Texto Deste Objeto
        return "ContaBancaria [" +
                "Titular: '" + nomeDoTitular + '\'' +
                ", Numero: " + numeroDaConta +
                ", Saldo: R$ " + saldo +
                ']';
    }


    // Metodo Abstrato Define Uma Obrigacao Para As Classes Filhas Concretas
    // ContaBancaria Diz Que Toda Conta Deve Saber Calcular Sua Tarifa
    // Mas Nao Define Aqui Como Esse Calculo Deve Ser Feito
    public abstract double calcularTarifa();
}