package br.edu.ifsp.xyz.teste;
import br.edu.ifsp.xyz.comissao.ProdutoPedido;

public class ProdutoPedidoTeste {
		public static void main(String[] args) throws Exception {
			ProdutoPedido produtoPedido = new ProdutoPedido("../srcComissao/ProdutoPedido.txt", 0, "2");
			System.out.println("--->" + produtoPedido);
	}

}

