public class ContaCorrente extends ContaBancaria {
    private double taxaManutencao;

    public ContaCorrente(String nomeDoTitular, int numeroDaConta, double saldo, double taxaManutencao) {
        super(nomeDoTitular, numeroDaConta, saldo);
        this.taxaManutencao = taxaManutencao;
    }

    public void cobrarTaxa() {
        if (getSaldo() >= taxaManutencao) {

            saldo -= taxaManutencao;

        }

    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Taxa de Manutencao: " +taxaManutencao);
    }
}

