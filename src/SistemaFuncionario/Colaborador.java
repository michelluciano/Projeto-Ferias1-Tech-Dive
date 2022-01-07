package SistemaFuncionario;

public class Colaborador extends Pessoa{
    private double salarioBruto;
    private double descontos;

    //construtor
    public Colaborador() {
        super();
    }

    public Colaborador(int id, String nome, int idade, String sexo, String status, double salarioBruto, double descontos) {
        super(id, nome, idade, sexo, status);
        this.salarioBruto = salarioBruto;
        this.descontos = descontos;
    }
    //métodos
    public Double calcularSalario(){
        double salarioLiquido = getSalarioBruto() - ((getDescontos() / 100)* getSalarioBruto());
        return salarioLiquido;
    }

    //getters e setters

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }
}
