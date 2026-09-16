// Extends Indica Que ContaCorrente Herda De ContaBancaria
public class ContaCorrente extends ContaBancaria implements Tributavel {

    // Atributo Especifico Da ContaCorrente
    private double taxaManutencao;


    // Construtor Da ContaCorrente Agora Recebe Um Cliente Inteiro
    public ContaCorrente(
            Cliente titularDaConta,
            int numeroDaConta,
            double saldo,
            double taxaManutencao
    ) {

        // Super Envia O Cliente Numero E Saldo Para O Construtor Da Classe Mae
        super(titularDaConta, numeroDaConta, saldo);

        // This Inicializa O Atributo Especifico Da ContaCorrente
        this.taxaManutencao = taxaManutencao;
    }


    // Metodo Especifico Da ContaCorrente
    public void cobrarTaxa() {

        // Verifica Se Existe Saldo Suficiente Para Cobrar A Taxa
        if (getSaldo() >= taxaManutencao) {

            saldo -= taxaManutencao;
        }
    }


    // Override Indica Que Estamos Sobrescrevendo O Metodo Herdado
    @Override
    public void exibirDados() {

        // Chama Primeiro A Versao Da Classe Mae
        super.exibirDados();

        // Depois Adiciona O Dado Específico Da ContaCorrente
        System.out.println(
                "Taxa De Manutencao: "
                        + taxaManutencao
        );
    }


    // Override Implementa O Metodo Abstrato Da Classe Mae
    @Override
    public double calcularTarifa() {

        if (saldo <= 500) {

            return 10;

        } else if (saldo <= 5000) {

            return saldo * 0.01;

        } else {

            return saldo * 0.005;
        }
    }


    // Override Implementa O Contrato Da Interface Tributavel
    @Override
    public double calcularImposto() {

        return saldo * 0.02;
    }
}