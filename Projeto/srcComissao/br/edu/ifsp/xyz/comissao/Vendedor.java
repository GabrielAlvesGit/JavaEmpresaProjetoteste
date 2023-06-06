package br.edu.ifsp.xyz.comissao;

import java.util.ArrayList;
import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

public class Vendedor {
	private String cpf;
	private String nomeVendedor;
	//private Pedido[] pedidos;	
	//private RepresentantedeVenda representanteVenda;

	public Vendedor(String nomeVendedor, String cpf) {
		this.cpf = cpf;
		this.nomeVendedor = nomeVendedor;
	}

	public Vendedor(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> vendedores = leitor.conteudo();
		String vendedor = vendedores.get(0);
		System.out.println(vendedor);
		String[] campos = vendedor.split(";");
		this.cpf = campos[0];
		this.nomeVendedor = campos[1];
		// String idRepresentante = campos[2];
		 //String idPedido = campos[3];
		// this.representanteVenda = new RepresentantedeVenda(caminho, chave, valorChave) 
		// this.representanteVenda = new RepresentantedeVenda("../srcComissao/RepresentantedeVenda.txt", 0, idRepresentante);
		 
		 //this.representanteVenda = new RepresentantedeVenda(caminho, chave, valorChave) 
		 //this.pedidos = new Pedido("../srcComissao/Pedido.txt", 0, idPedido);
		 /*
		 leitor = new Leitor("../srcComissao/Pedido.txt",1,this.cpf);
		 ArrayList<String> pedidosTxt = leitor.conteudo();
		 this.pedidos = new Pedido[pedidosTxt.size()];
		 int ind = 0;
		 for (String pedidoTxt : pedidosTxt) {
			 System.out.println(pedidoTxt);
			 String[] camposPedido = pedidoTxt.split(";");
			 int idPed = Integer.parseInt(camposPedido[0]);
             String cpf = camposPedido[1];
             String[] campoData = camposPedido[2].split("/");
		     int dia = Integer.parseInt(campoData[0]);
		     int mes = Integer.parseInt(campoData[1]);
		     int ano = Integer.parseInt(campoData[2]);
		     Data dataPedido = new Data(dia,mes,ano);
		     double valor = Double.parseDouble(camposPedido[3]);
		     Pedido ped = new Pedido(idPed,cpf,dataPedido,valor);
		     this.pedidos[ind]  = ped;
		     ind = ind + 1;
		 }
		
		*/
		 
		 //String caminhoRepresentanteVenda = "../srcComissao/RepresentantedeVenda.txt";
		 //int chaveRepresentanteVenda = 0;
		 //String valorRepresentanteVenda = this.cpf;
		 //leitor = new Leitor(caminhoRepresentanteVenda, chaveRepresentanteVenda, valorRepresentanteVenda);
		 //ArrayList<String> representanteVendas = leitor.conteudo();
		 //int qtRepresentanteVenda = representanteVendas.size();
		 //this.representanteVenda = new RepresentantedeVenda[qtRepresentanteVenda];
		 //int indicerepresentanteVenda = 0;
		 //for (String RepresentanteVendaoAux : representanteVendas) {
		//	 campos = RepresentanteVendaoAux.split(";");
		//	 int IdRepresentate = Integer.parseInt(campos[0]);
		//	 String nome = (campos[1]);
		//	 String cpf = (campos[2]);
		//	 int nZona = Integer.parseInt (campos[3]);
		//	 RepresentantedeVenda representanteVenda = new RepresentantedeVenda(IdRepresentate, nome, cpf, nZona);
		//	 this.representanteVendas[indicerepresentanteVenda] = representanteVenda;
		//	 indicerepresentanteVenda += 1;
			 
			 
		 //}
		 
		 
		
		 
	 }
	@Override
		public String toString() {
			return "Vendedor [cpf=" + cpf + ", nomeVendedor=" + nomeVendedor  +  "]";
					//+ "\n --> Representante de Venda =" + representanteVenda + " ]";
			
		}

	
   
	 
}