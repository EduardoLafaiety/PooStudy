public class ContaPoupanca extends ContaBancaria {

    private double rendimento;

    public ContaPoupanca(
            Cliente titularDaConta,
            int numeroDaConta,
            double saldo,
            double rendimento
    ) {

        super(titularDaConta, numeroDaConta, saldo);

        this.rendimento = rendimento;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Rendimento: " + rendimento);
    }

    @Override
    public double calcularTarifa() {
        return saldo * 0.02;
    }
}