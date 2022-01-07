package SistemaFuncionario;

public class LiderTecnico extends Colaborador{
    private double ajudaDeCusto;

    public LiderTecnico() {
        super();
    }

    public LiderTecnico(int id, String nome, int idade, String sexo, String status, double salarioBruto, double descontos, double ajudaDeCusto) {
        super(id, nome, idade, sexo, status, salarioBruto, descontos);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public Double calcularSalario() {
        double salarioLiquido = (ajudaDeCusto + getSalarioBruto()) - ((getDescontos() / 100)* getSalarioBruto());
        return salarioLiquido;
    }

    // g e s

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }
}
