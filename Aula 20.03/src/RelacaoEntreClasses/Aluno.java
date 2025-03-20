package RelacaoEntreClasses;

public class Aluno {
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

// Pode apenas ter uma classe public em um arquivo

class Disciplina {
    public String nome;
    public String dia;
    public String horario;
    public Aluno[] alunos = new Aluno[2];

    public Disciplina(String nome, String dia, String horario) {
        this.nome = nome;
        this.dia = dia;
        this.horario = horario;
    }

    public void exibirAlunos(){
        System.out.println("Disciplina: " + nome);
        for(Aluno aluno: alunos){
            System.out.println("Nome: "+ aluno.getNome() + ", Matricula: "+ aluno.getMatricula());
        }
    }

}

class Main{
    public static void main(String[] args) {
        Disciplina disciplina = new Disciplina("LTPII","Quinta","8:00-10:50");
        Aluno aluno1 = new Aluno("Pedro", "1235412341");
        Aluno aluno2 = new Aluno("João", "38493842398");
        disciplina.alunos[0] = aluno1;
        disciplina.alunos[1] = aluno2;
        disciplina.exibirAlunos();
    }
}


