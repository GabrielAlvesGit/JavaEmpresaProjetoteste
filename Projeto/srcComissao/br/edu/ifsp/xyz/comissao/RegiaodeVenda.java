package br.edu.ifsp.xyz.comissao;
import java.util.ArrayList;
import java.util.Arrays;

import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;


public class RegiaodeVenda {
	private int idregiao;
	private String nome;
	private ZonadeVenda[] zonadeVendas;
	
	public RegiaodeVenda(int idregiao, String nome) {
        this.idregiao = idregiao;
        this.nome = nome;
    }
	public RegiaodeVenda(String caminho, int chave, String valorChave) throws Exception{
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> regiaodeVendas = leitor.conteudo();
		String regiaodeVenda = regiaodeVendas.get(0);
		System.out.println(regiaodeVenda);
		String[] campos = regiaodeVenda.split(";");
		this.idregiao = Integer.parseInt(campos[0]);
		this.nome = (campos[1]);
		
		 String caminhoZonadeVenda = "../srcComissao/ZonaVenda.txt";
		 int chaveZonadeVenda = 0;
		 String valorZonadeVenda = String.valueOf(this.idregiao);
		 leitor = new Leitor(caminhoZonadeVenda, chaveZonadeVenda, valorZonadeVenda);
		 ArrayList<String> zonadeVendas = leitor.conteudo();
		 int qtZonadeVenda = zonadeVendas.size();
		 this.zonadeVendas = new ZonadeVenda[qtZonadeVenda];
		 int indiceZonadeVenda = 0;
		 for (String zonadeVendaAux : zonadeVendas) {
			 campos = zonadeVendaAux.split(";");
			 String idUf = (campos[0]);
			 String nome = (campos[1]);
			 String idregiao = campos[2];
			 ZonadeVenda zonadeVenda = new ZonadeVenda(idUf, nome, this);
			 this.zonadeVendas[indiceZonadeVenda] = zonadeVenda;
			 indiceZonadeVenda += 1;
		 }
	}
	@Override
	public String toString() {
		return "RegiaodeVenda [idregiao=" + idregiao + ", nome=" + nome  + ", Zona de venda =" + Arrays.toString(zonadeVendas) + "]";
	}
}
