package esoft.programacao.aep_notas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 1156);
        Aluno aluno2 = new Aluno("Lucas", 7351);
        Aluno aluno3 = new Aluno("Bruno", 2485);
        Aluno aluno4 = new Aluno("Fernando", 9381);
        Aluno aluno5 = new Aluno("PolacO", 3785);
        Aluno aluno6 = new Aluno("PolacA", 1648);
        Aluno aluno7 = new Aluno("FulanO", 9762);
        Aluno aluno8 = new Aluno("FulanA", 1427);
        Aluno aluno9 = new Aluno("CarinhaQueMoraLogoAli", 2936);
        Aluno aluno10 = new Aluno("Artur", 5716);

        Disciplina esoft = new Disciplina("Engenharia De Software");
        Disciplina algoritimos = new Disciplina("algoritimos");
        Disciplina banco = new Disciplina("Banco de Dados");
        Disciplina programacao = new Disciplina("programação");
        Disciplina sistop = new Disciplina("Sistemas Operacionais");

        List<Disciplina> disciplinas = new ArrayList<>();

        disciplinas.add(esoft);
        disciplinas.add(algoritimos);
        disciplinas.add(banco);
        disciplinas.add(programacao);
        disciplinas.add(sistop);

        RepositorioDeAvaliacoes repositorioDeAvaliacoes = new RepositorioDeAvaliacoes();

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno1, esoft, 5, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno1, algoritimos, 5, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno1, banco, 5, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno1, programacao, 1, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno1, sistop, 1, 1, 1, 1);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno2, esoft, 5, 6, 6, 8);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno2, algoritimos, 1, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno2, banco, 1, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno2, programacao, 1, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno2, sistop, 1, 1, 1, 1);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno3, esoft, 5, 8, 8, 8);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno3, algoritimos, 10, 1, 6, 8);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno3, banco, 1, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno3, programacao, 1, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno3, sistop, 1, 1, 1, 1);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno4, esoft, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno4, algoritimos, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno4, banco, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno4, programacao, 1, 1, 1, 1);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno4, sistop, 1, 1, 1, 1);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno5, esoft, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno5, algoritimos, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno5, banco, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno5, programacao, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno5, sistop, 1, 1, 1, 1);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno6, esoft, 6, 7, 8, 9);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno6, algoritimos, 6, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno6, banco, 5, 9, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno6, programacao, 6, 7, 6, 6);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno6, sistop, 6, 6, 6, 9);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno7, esoft, 5, 10, 10, 10);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno7, algoritimos, 5, 10, 6, 7);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno7, banco, 5, 10, 8, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno7, programacao, 7, 1, 6, 10);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno7, sistop, 5, 8, 6, 7);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno8, esoft, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno8, algoritimos, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno8, banco, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno8, programacao, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno8, sistop, 5, 10, 6, 4);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno9, esoft, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno9, algoritimos, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno9, banco, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno9, programacao, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno9, sistop, 5, 10, 6, 4);

        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno10, esoft, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno10, algoritimos, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno10, banco, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno10, programacao, 5, 10, 6, 4);
        adiconarAvaliacoes(repositorioDeAvaliacoes, aluno10, sistop, 5, 10, 6, 4);

        disciplinas.forEach(disciplina -> System.out.println("Disciplina: " + disciplina.getNome() + "\n"
                + "Aprovados: " + Arrays.toString(repositorioDeAvaliacoes.obterAprovados(disciplina))));
    }

    private static void adiconarAvaliacoes(RepositorioDeAvaliacoes repositorio, Aluno aluno, Disciplina disciplina, float... notas) {

        for (float nota : notas) {
        	repositorio.adicionarAvaliacao(new Avaliacao(aluno, disciplina, nota));
        }

    }

}