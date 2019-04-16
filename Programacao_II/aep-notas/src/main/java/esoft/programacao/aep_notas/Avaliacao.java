package esoft.programacao.aep_notas;

public class Avaliacao {
	private float nota;
	private Aluno aluno;
	private Disciplina disciplina;

	public Avaliacao() {};
	
	public Avaliacao(Aluno aluno, Disciplina disciplina, float nota) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		nota = disciplina.getNota();
	}
	
}
