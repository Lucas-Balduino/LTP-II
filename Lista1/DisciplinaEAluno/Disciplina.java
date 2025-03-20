package Lista1.DisciplinaEAluno;

public class Disciplina {
    public String nome;
    public String dia;
    public String horario;
    public String[] alunos = {};

    public Disciplina(String nome, String dia, String horario) {
        this.nome = nome;
        this.dia = dia;
        this.horario = horario;
    }

    public void exibirAlunos(){
        for(int i = 0; i < alunos.length; i++){
            System.out.println(alunos[i]);
        }
    }

    public void addAluno(String nomeAluno){
        for(int i = 0; i < alunos.length; i++){
            if(alunos[i] == null){
                alunos[i] = nomeAluno;
            } else {
                i+=1;
            }
        }
    }

}
