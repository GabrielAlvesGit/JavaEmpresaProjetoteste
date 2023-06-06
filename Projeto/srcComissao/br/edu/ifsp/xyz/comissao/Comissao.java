package br.edu.ifsp.xyz.comissao;

import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

public class Comissao {
	private int idComissao;
	private Vendedor vendedor;
	private Pedido[] pedidos;

	public Comissao(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> comissoes = leitor.conteudo();
		String comissao = comissoes.get(0);
		System.out.println(comissao);
		String[] campos = comissao.split(";");
		this.idComissao = Integer.parseInt(campos[0]);

		// Carregar o vendedor
		String cpf = campos[1];
		this.vendedor = carregarVendedor(cpf);

		// Carregar os pedidos do vendedor
		this.pedidos = carregarPedidosVendedor(cpf);
	}

	private Vendedor carregarVendedor(String cpf) throws Exception {
		String caminhoVendedor = "../srcComissao/Vendedor.txt";
		int chaveVendedor = 0;
		Leitor leitor = new Leitor(caminhoVendedor, chaveVendedor, cpf);
		ArrayList<String> vendedoresTxt = leitor.conteudo();
		if (vendedoresTxt.isEmpty()) {
			throw new Exception("Vendedor não encontrado");
		}
		String vendedorTxt = vendedoresTxt.get(0);
		String[] campos = vendedorTxt.split(";");
		String nomeVendedor = campos[1];
		return new Vendedor(cpf, nomeVendedor);
	}

	private Pedido[] carregarPedidosVendedor(String cpf) throws Exception {
		String caminhoPedido = "../srcComissao/Pedido.txt";
		int chavePedido = 6;
		Leitor leitor = new Leitor(caminhoPedido, chavePedido, cpf);
		ArrayList<String> pedidosTxt = leitor.conteudo();
		int qtPedidos = pedidosTxt.size();
		Pedido[] pedidos = new Pedido[qtPedidos];
		int indicePedido = 0;
		for (String pedidoTxt : pedidosTxt) {
			String[] campos = pedidoTxt.split(";");
			int idPedido = Integer.parseInt(campos[0]);
			String[] campoData = campos[2].split("/");
			int dia = Integer.parseInt(campoData[0]);
			int mes = Integer.parseInt(campoData[1]);
			int ano = Integer.parseInt(campoData[2]);
			Data dataPedido = new Data(dia, mes, ano);
			double valor = Double.parseDouble(campos[3]);
			// Pedido pedido = new Pedido(idPedido, cpf, dataPedido, valor);
			Pedido pedido = new Pedido("../srcComissao/Pedido.txt", 0, idPedido + "");

			pedidos[indicePedido] = pedido;
			indicePedido++;
		}
		// vendedor.setPedidos(pedidos);
		return pedidos;
	}

	public double calcularComissao() {
		double totalComissao = 0.0;
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		for (Pedido pedido : this.pedidos) {
			for (ProdutoPedido prodPed : pedido.getProdutosPedido()) {
				Produto prod = prodPed.getProduto();
				CategoriadoProduto cat = prod.getCategoriaProduto();
				double percentual = cat.getPercentualComissao();
				int quantidade = prodPed.getQuantidade();
				double preco = prodPed.getPrecoVenda();
				double subtotal = preco * quantidade;
				double comissaoProduto = subtotal * (percentual / 100 ) ;

				System.out.println("Preço: " + preco);
				System.out.println("Quantidade: " + quantidade);
				System.out.println("Subtotal: " + subtotal);
				System.out.println("Percentual: " + percentual + "%");
				System.out.println("Comissão Desse Produto para o vendedor: " + decimalFormat.format(comissaoProduto));

				totalComissao += comissaoProduto ;
			}
		}
		return totalComissao;
	}

	@Override
	public String toString() {
		// double comissao = calcularComissao();
		return " Comissao [ID da Comissão=" + idComissao + "]\n" + "---> Vendedor=" + vendedor + "\n" + "---> Pedido ="
				+ Arrays.toString(pedidos) + "\n" + "---> Comissão=" + "R$:" + calcularComissao () ;
	}
}