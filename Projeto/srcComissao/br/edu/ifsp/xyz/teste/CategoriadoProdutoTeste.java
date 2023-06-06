package br.edu.ifsp.xyz.teste;
import br.edu.ifsp.xyz.comissao.CategoriadoProduto;

public class CategoriadoProdutoTeste {
		public static void main(String[] args) throws Exception {
			CategoriadoProduto categoriadoProduto = new CategoriadoProduto("../srcComissao/CategoriadoProduto.txt", 0, "1");
			System.out.println("--->" + categoriadoProduto);
		}

}
