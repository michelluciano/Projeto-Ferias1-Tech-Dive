package SistemaFuncionario;

public class GerenteGeral extends Colaborador{

    private double participacaoLucros = 20;
    private double ajudaDeCusto;

    public GerenteGeral() {
        super();
    }

    public GerenteGeral(int id, String nome, int idade, String sexo, String status, double salarioBruto, double descontos, double participacaoLucros, double ajudaDeCusto) {
        super(id, nome, idade, sexo, status, salarioBruto, descontos);
        this.participacaoLucros = participacaoLucros;
        this.ajudaDeCusto = ajudaDeCusto;
    }

    public double getParticipacaoLucros() {
        return participacaoLucros;
    }

    public void setParticipacaoLucros(double participacaoLucros) {
        this.participacaoLucros = participacaoLucros;
    }

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public Double calcularSalario() {
        double salarioLiquido = getSalarioBruto() + ((getDescontos() / 100)* getSalarioBruto());
        return salarioLiquido + getAjudaDeCusto() + ( salarioLiquido * (getParticipacaoLucros() /100)) ;
    }
}
