package Lista1.DisciplinaEAluno;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Lucas", "123141221");
        Aluno aluno2 = new Aluno("Pedro", "543526123");
        Disciplina disciplina = new Disciplina("LTPII", "Quinta","8:00-10:50");
        disciplina.exibirAlunos();
        disciplina.addAluno(aluno1.nome);
        disciplina.exibirAlunos();
        disciplina.addAluno(aluno2.nome);
        disciplina.exibirAlunos();
    }
}
