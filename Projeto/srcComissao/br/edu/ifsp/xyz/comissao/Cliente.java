package br.edu.ifsp.xyz.comissao;
import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;
import java.util.ArrayList;
import java.util.Arrays;


public class Cliente {
	private String cpf;
	private String nome;
	private Pedido[] pedidos;
	
	public Cliente(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> clientes = leitor.conteudo();
		String cliente = clientes.get(0);
		System.out.println(cliente);
		String[] campos = cliente.split(";");
		this.cpf = campos[0];
		this.nome = campos[1];
		
		String caminhoPedido = "../srcComissao/Pedido.txt";
        int chavePedido = 1;
        String valorChavePedido = this.cpf;
		leitor = new Leitor(caminhoPedido, chavePedido, valorChavePedido);
		ArrayList<String> pedidos = leitor.conteudo();
		int qtPedidos = pedidos.size();
		this.pedidos = new Pedido[qtPedidos]; 
		int indicePedido = 0;
		for (String pedidoAux : pedidos) {
			 campos = pedidoAux.split(";");
			 int idPedido = Integer.parseInt(campos[0]);
		     String cpf = campos[1];
		     String[] campoData = campos[2].split("/");
		     int dia = Integer.parseInt(campoData[0]);
		     int mes = Integer.parseInt(campoData[1]);
		     int ano = Integer.parseInt(campoData[2]);
		     Data dataPedido = new Data(dia,mes,ano);
		     double valor = Double.parseDouble(campos[3]);
		     Pedido pedido = new Pedido(idPedido,cpf,dataPedido,valor);
		     this.pedidos[indicePedido] = pedido;
		     indicePedido =+ 1;
		}
	}
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", pedidos=" + Arrays.toString(pedidos) + "]";
	}
}
