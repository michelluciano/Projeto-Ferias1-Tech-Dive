package SistemaFuncionario;

public class GerenteDeDepartamento extends Colaborador{

    private double participacaoLucros = 10;

    public GerenteDeDepartamento() {
        super();
    }

    public GerenteDeDepartamento(int id, String nome, int idade, String sexo, String status, double salarioBruto, double descontos, double participacaoLucros) {
        super(id, nome, idade, sexo, status, salarioBruto, descontos);
        this.participacaoLucros = participacaoLucros;
    }
    // getter e setter

    public double getParticipacaoLucros() {
        return participacaoLucros;
    }

    public void setParticipacaoLucros(double participacaoLucros) {
        this.participacaoLucros = participacaoLucros;
    }


    // metodos

    @Override
    public Double calcularSalario() {
        double salarioLiquido = getSalarioBruto() + ((getDescontos() / 100)* getSalarioBruto());
        return salarioLiquido + ( salarioLiquido * (getParticipacaoLucros() /100)) ;
    }
}
