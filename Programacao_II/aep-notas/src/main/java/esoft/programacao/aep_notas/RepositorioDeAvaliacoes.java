package esoft.programacao.aep_notas;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RepositorioDeAvaliacoes {

    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionarAvaliacao(Avaliacao avaliação) {
        this.avaliacoes.add(avaliação);
    }

    public Aluno[] obterAprovados(Disciplina disciplina) {
        List<Avaliacao> avaliacoesPorDisciplina = this.avaliacoes
                .stream()
                .filter(avaliação -> avaliação.getDisciplina().equals(disciplina))
                .collect(Collectors.toList());
        Set<Aluno> alunosDaDisciplina = avaliacoesPorDisciplina.stream()
                .map(Avaliacao::getAluno)
                .collect(Collectors.toSet());
        List<Aluno> alunosAprovados = new ArrayList<>();
        for (Aluno aluno : alunosDaDisciplina) {
            List<Avaliacao> avaliacoesDoAluno = avaliacoesPorDisciplina.stream()
                    .filter(avaliação -> avaliação.getAluno().equals(aluno))
                    .collect(Collectors.toList());
            float média = 0;
            for (Avaliacao avaliação : avaliacoesDoAluno) {
                média += avaliação.getNota();
            }
            média = média / avaliacoesDoAluno.size();
            if (média >= 6) {
                alunosAprovados.add(aluno);
            }
        }
        return alunosAprovados.toArray(new Aluno[0]);
    }
}
