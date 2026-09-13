// Extends Indica Que ContaCorrente Herda De ContaBancaria
public class ContaCorrente extends ContaBancaria implements Tributavel {

    // Atributo Especifico Da ContaCorrente
    private double taxaManutencao;


    // Construtor Da ContaCorrente
    public ContaCorrente(
            String nomeDoTitular,
            int numeroDaConta,
            double saldo,
            double taxaManutencao
    ) {

        // Super Chama O Construtor Da Classe Mae ContaBancaria
        // A Classe Mae Fica Responsavel Por Inicializar Nome Numero E Saldo
        super(nomeDoTitular, numeroDaConta, saldo);

        // This Inicializa O Atributo Especifico Da Propria ContaCorrente
        this.taxaManutencao = taxaManutencao;
    }


    // Metodo Especifico De ContaCorrente
    public void cobrarTaxa() {

        // Verifica Se Existe Saldo Suficiente Para Cobrar A Taxa
        if (getSaldo() >= taxaManutencao) {

            // Saldo Pode Ser Acessado Aqui Porque Foi Declarado Como Protected
            saldo -= taxaManutencao;
        }
    }


    // Override Indica Que Estamos Substituindo A Versao Herdada De ExibirDados
    @Override
    public void exibirDados() {

        // Super ExibirDados Chama Primeiro A Versao Da Classe Mae
        super.exibirDados();

        // Depois Adicionamos O Comportamento Especifico Da ContaCorrente
        System.out.println(
                "Taxa de Manutencao: "
                        + taxaManutencao
        );
    }


    // Override Implementa O Metodo Abstrato Exigido Pela ContaBancaria
    @Override
    public double calcularTarifa() {

        // Se O Saldo For Menor Ou Igual A Quinhentos
        // Retorna Uma Tarifa Fixa De Dez
        if (saldo <= 500) {

            return 10;

            // Se O Saldo For Maior Que Quinhentos E Menor Ou Igual A Cinco Mil
            // Retorna Um Por Cento Do Saldo
        } else if (saldo <= 5000) {

            return saldo * 0.01;

            // Se O Saldo For Maior Que Cinco Mil
            // Retorna Meio Por Cento Do Saldo
        } else {

            return saldo * 0.005;
        }
    }

    @Override
    public double calcularImposto() { // Contrato da Interface Para Calcular Imposto
        return saldo * 0.02;
    }
}