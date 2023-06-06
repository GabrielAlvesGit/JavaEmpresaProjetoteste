package br.edu.ifsp.xyz.comissao;
import br.edu.ifsp.xyz.util.Data;
import br.edu.ifsp.xyz.leitor.Leitor;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {
    private int idPedido;
    private Data dataPedido;
    private ProdutoPedido produtosPedido[];
    private Vendedor vendedor;
    
    public ProdutoPedido[] getProdutosPedido() {
		return produtosPedido;
	}

    
	public Pedido(int idPedido, String cpf, Data dataPedido, double valor) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
    }

    public Pedido(String caminho, int chave, String valorChave) throws Exception {
        Leitor leitor = new Leitor(caminho, chave, valorChave);   
        ArrayList<String> pedidos = leitor.conteudo();
        String pedido = pedidos.get(0);
        System.out.println(pedido);
        String[] campos = pedido.split(";");
        this.idPedido = Integer.parseInt(campos[0]);
        //this.cpf = campos[1];
        String[] campoData = campos[2].split("/");
        int dia = Integer.parseInt(campoData[0]);
        int mes = Integer.parseInt(campoData[1]);
        int ano = Integer.parseInt(campoData[2]);
        this.dataPedido = new Data(dia, mes, ano);
        //this.valor = Double.parseDouble(campos[3]);
        String cpfVendedor = campos[6];
       
        
        // carregar o produto
        String caminhoProdutoPedido = "../srcComissao/ProdutoPedido.txt";
        int chaveProdutoPedido = 2; //2
        String valorProdutoPedido = String.valueOf(idPedido);
        leitor = new Leitor(caminhoProdutoPedido, chaveProdutoPedido, valorProdutoPedido);
        ArrayList<String> produtoPedidos = leitor.conteudo();
        int qtProdutoPedido = produtoPedidos.size();
        this.produtosPedido = new ProdutoPedido[qtProdutoPedido];
        int indiceProdutoPedido = 0;
        for (String ProdutoPedidoAux :produtoPedidos ) {
        	campos = ProdutoPedidoAux.split(";");
        	 int idProdutoPedido = Integer.parseInt(campos[0]);
             String idProduto = campos[1];
        	 int  Quantidade = Integer.parseInt(campos[3]);
        	 double precoVenda = Integer.parseInt(campos[4]);
        	 Produto produto = new Produto("../srcComissao/Produto.txt", 0, idProduto );
        	 ProdutoPedido  produtoPedido = new ProdutoPedido(idProdutoPedido, Quantidade, precoVenda,produto);
        	 this.produtosPedido[indiceProdutoPedido] = produtoPedido;
        	 indiceProdutoPedido += 1;
        }	
        
        String caminhoVendedor = "../srcComissao/Vendedor.txt";
        int chaveVendedor = 0; 
       // String valorVendedor = String.valueOf(idPedido);
        this.vendedor = new Vendedor(caminhoVendedor,chaveVendedor,cpfVendedor);
        
 }
            
        
    @Override
    public String toString() {
    	  return " Pedido = [idPedido=" + idPedido + "  dataPedido=" + dataPedido +   
        		"]\n---> ProdutoPedidos=" + Arrays.toString(produtosPedido) + 
                "]\n---> Vendedor=" + vendedor+ "]";
    }

	//public double getValor() {
	//	// TODO Auto-generated method stub
	//	return 0;
	//}
}
