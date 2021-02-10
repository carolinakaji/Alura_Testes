package br.com.caelum.leilao.teste.servico;



import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		// Cen�rio
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Play 3");
		
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 450.0));
		
		// A��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// Valida��o
		double maiorEsperado = 450.0;
		double menorEsperado = 200.0;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveMostrarAMedia() {
		// Cen�rio
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Play 3");
		
		leilao.propoe(new Lance(joao, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 500.0));
		
		// A��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// Valida��o
		double valorMedioEsperado = 400.0;
		Assert.assertEquals(valorMedioEsperado, leiloeiro.getValorMedio(), 0.0001);
		
	}
	
	@Test
	public void testaMediaDeZeroLance() {
		// Cenario
		Usuario mario = new Usuario("Mario");
		
		Leilao leilao = new Leilao("Iphone 12");
		
		// A��o
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		// Valida��o
		Assert.assertEquals(0, avaliador.getValorMedio(), 0.0001);
	}
	
}
