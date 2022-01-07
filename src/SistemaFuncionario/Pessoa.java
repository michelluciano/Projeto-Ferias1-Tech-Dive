package SistemaFuncionario;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String status;
    public static int contadorPessoas = 4;

    public Pessoa(){

    }

    public Pessoa(int id, String nome, int idade, String sexo, String status) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.status = status;
    }

    // getter e setter


    public static int getContadorPessoas() {
        return contadorPessoas;
    }

    public static void setContadorPessoas(int contadorPessoas) {
        Pessoa.contadorPessoas = contadorPessoas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo=" + sexo +
                ", status=" + status +
                '}';
    }
}
