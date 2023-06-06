package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Produto;

public class ProdutoTeste {
	public static void main(String[] args) throws Exception {
		Produto produto = new Produto("../srcComissao/Produto.txt", 0, "3");
		System.out.println("--->" + produto);
	}
}
