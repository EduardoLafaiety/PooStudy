public class ContaBancaria {

    private String nomeDoTitular;
    private int numeroDaConta;
    protected double saldo;

    public ContaBancaria(String nomeDoTitular, int numeroDaConta, double saldo) {

        this.nomeDoTitular = nomeDoTitular;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;

    }

    void receber(double valorRecebido) {
        saldo += valorRecebido;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private String getNomeDoTitular()
    {
        return nomeDoTitular;
    }

    private void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    private int getNumeroDaConta() {
        return numeroDaConta;
    }

    private void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    void transferencia(double valorTransferido, ContaBancaria contaDestino) {
        if (valorTransferido > saldo){
            System.out.println("Saldo Insuficiente!");
        }else{
            saldo -= valorTransferido;
            contaDestino.receber(valorTransferido);
        }

    }

    @Override
    public String toString() {
        return "ContaBancaria [" +
                "Titular: '" + nomeDoTitular + '\'' +
                ", Número: " + numeroDaConta +
                ", Saldo: R$ " + saldo +
                ']';
    }

}

