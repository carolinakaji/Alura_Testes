package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	// Double.NEGATIVE_INFINITY é uma constante que guara o menor valor do double, desta forma inicializada é possível sobrescrever
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	// Double.POSITIVE_INFINITY guarda o maior valor de double
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double valorMedio = 0;;

	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	public double getMenorLance() {
		return menorDeTodos;
	}
	
	public double getValorMedio() {
		return valorMedio;
	}


	public void avalia(Leilao leilao) {
		
		double total = 0;
		
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos ) maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos ) menorDeTodos = lance.getValor();
			total += lance.getValor();
		} 
		
		if(total == 0) {
			valorMedio = 0;
			return;
		}
		valorMedio = total / leilao.getLances().size(); 
		
	}
	
	
	
}
