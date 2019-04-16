package esoft.programacao.aep_notas;

import java.util.ArrayList;
import java.util.List;


public class RepositorioAvaliacoes {

public class AvaliacaoRepository {
	private List<Avaliacao> avaliacoes = new ArrayList();
	
	public List<Avaliacao> getAll() {
		return this.avaliacoes;
	}
	public void add(Avaliacao AvaliacaoParaAdicionar) {
		this.avaliacoes.add(AvaliacaoParaAdicionar);
	}
	public void remove(Avaliacao AvaliacaoParaRemover) {
		this.avaliacoes.remove(AvaliacaoParaRemover);
	}
	
	public void adicionar(Avaliacao avaliacao) {

		}
	
	
	}
}
