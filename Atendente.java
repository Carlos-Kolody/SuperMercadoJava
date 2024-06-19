import java.io.Serializable;

public class Atendente implements Serializable {
    private int id;
    private String nome;
    private String matricula;

    public Atendente(int id, String nome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String toString() {
        return "Atendente [id=" + id + ", nome=" + nome + ", matricula=" + matricula + "]";
    }
}
