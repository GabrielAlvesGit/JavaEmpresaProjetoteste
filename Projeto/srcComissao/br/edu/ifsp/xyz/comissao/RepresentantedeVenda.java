package br.edu.ifsp.xyz.comissao;

import java.util.ArrayList;
import java.util.Arrays;

import br.edu.ifsp.xyz.leitor.Leitor;

public class RepresentantedeVenda {
	private int IdRepresentate;
	private String nome;
	private String cpf;
	//private int nZona;
	private RegiaodeVenda regiaoVenda;
	
	
	public RepresentantedeVenda(int IdRepresentate, String nome, String cpf, int nZona) {
		 this.IdRepresentate = IdRepresentate;
	     this.nome = nome;
	        this. cpf =  cpf;
	        //this.nZona = nZona;
	}
	public RepresentantedeVenda(String caminho, int chave, String valorChave) throws Exception{
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> representantedeVendas = leitor.conteudo();
		String representantedeVenda = representantedeVendas.get(0);
		System.out.println(representantedeVenda);
		String[] campos = representantedeVenda.split(";");
		this.IdRepresentate = Integer.parseInt(campos[0]);
		this.nome = (campos[1]);
		this.cpf = (campos[2]);
		String idRegiao = campos[3];
		
		 String caminhoRegiaoVenda = "../srcComissao/RegiaoVenda.txt";
		 //int chaveRegiaoVenda = 0;
		 String valorRegiaoVenda = String.valueOf(this.IdRepresentate);
		 this.regiaoVenda = new RegiaodeVenda("../srcComissao/RegiaoVenda.txt", 0, idRegiao);

		 //leitor = new Leitor(caminhoRegiaoVenda, chaveRegiaoVenda, valorRegiaoVenda);
		 // ArrayList<String> regiaoVendas = leitor.conteudo();
		  //int qtRegiaoVenda = regiaoVendas .size();
		  //this.regiaoVendas = new RegiaodeVenda[qtRegiaoVenda];
		  //int indiceRegiaoVenda = 0;
		  //for (String regiaoVendaAux : regiaoVendas) {
		//	  campos = regiaoVendaAux.split(";");
			//  int idregiao = Integer.parseInt(campos[0]);
			 // String nome = (campos[1]);
			 // RegiaodeVenda regiaodeVenda = new RegiaodeVenda(idregiao, nome);
			 // this.regiaoVendas[indiceRegiaoVenda] = regiaodeVenda;
			 // indiceRegiaoVenda += 1;
			  
		  //}
		
	}
	
	public String toString() {
		return "RepresentantedeVend [IdRepresentate=" + IdRepresentate + ", nome=" + nome + ", cpf=" +cpf + " Regiao de venda=" + regiaoVenda+ "]";
	}
}
