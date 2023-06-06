package br.edu.ifsp.xyz.comissao;
import java.util.ArrayList;
import java.util.Arrays;

import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

public class ProdutoPedido {
	private int idProdutoPedido;
	private int Quantidade;
	private double precoVenda;
	private Produto produto;
	
	 public ProdutoPedido(int idProdutoPedido, int Qauntidade, double precoVenda2, Produto produto) {
	        this.idProdutoPedido = idProdutoPedido;
	        this.Quantidade = Qauntidade;
	        this.precoVenda = precoVenda2;
	        this.produto = produto;
	        
	    }

	 
	public Produto getProduto() {
		return produto;
	}

	

	public int getQuantidade() {
		return Quantidade;
	}


	public double getPrecoVenda() {
		return precoVenda;
	}


	public ProdutoPedido(String caminho, int chave, String valorChave) throws Exception{
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> produtoPedidos = leitor.conteudo();
		String produtoPedido = produtoPedidos.get(0);
		System.out.println(produtoPedido);
		String[] campos = produtoPedido.split(";");
		this.idProdutoPedido = Integer.parseInt(campos[0]);
		this.Quantidade = Integer.parseInt(campos[3]);
		this.precoVenda = Double.parseDouble(campos[4]);
		// carregar o produto
		
		 String caminhoProduto = "../srcComissao/Produto.txt";
		 int chaveProduto = 0;
		 String idProduto = campos[1];
		 String valorProduto = String.valueOf(this.idProdutoPedido);
         this.produto = new Produto(caminhoProduto,chaveProduto,idProduto);
		 
		// leitor = new Leitor(caminhoProduto, chaveProduto, valorProduto);
		// ArrayList<String> produtos = leitor.conteudo();
		// int qtProduto = produtos.size();
		// this.produto = new Produto[qtProduto];
		// int indiceProduto = 0;
		// for (String ProdutoAux : produtos) {
		//	 campos = ProdutoAux.split(";");
		//	 int IdCategoria = Integer.parseInt(campos[0]);
		//	 String nomeProduto = (campos[1]);
		//	 String descricaoProduto = (campos[2]);
		//	 Produto produto = new Produto(IdCategoria, nomeProduto, descricaoProduto);
		//	 this.produto[indiceProduto] = produto;
			 	
		 //}
		
	}
	

	@Override
	public String toString() {
		return " Produto Pedido [idProdutoPedido=" + idProdutoPedido + ", Qauntidade=" + Quantidade + ", Preço da venda=" + precoVenda + ","
				+ "]\n---> Produto =" + produto + "]";
	}

	
}
