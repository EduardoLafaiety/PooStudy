import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<ContaBancaria> Contas;

    public Banco(){

        this.Contas = new ArrayList<>();

    }

    public void cadastrarConta(ContaBancaria Conta){

        Contas.add(Conta);

    }

    public void listasContas(){

        for ( ContaBancaria Conta : Contas  ){

            Conta.exibirDados();

        }


    }

    public void buscarContaPorNumero (){



    }

}
