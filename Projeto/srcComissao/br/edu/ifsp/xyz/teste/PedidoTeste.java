package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Pedido;

public class PedidoTeste {
	public static void main(String[] args) throws Exception {
		Pedido pedido = new Pedido("../srcComissao/Pedido.txt", 0, "1");
		System.out.println("--->" + pedido);

	}

}
