package br.edu.ifsp.xyz.comissao;
import java.util.ArrayList;
import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

public class CategoriadoProduto {
	private int IdCategoria;
	private String finalidadeCategoria;
	private float percentualComissao;
	
	public float getPercentualComissao() {
		return percentualComissao;
	}
	public CategoriadoProduto (int IdCategoria, String finalidadeCategoria, float percentualComissao) {
		this.IdCategoria = IdCategoria;
		this.finalidadeCategoria  = finalidadeCategoria ;
		this.percentualComissao  = percentualComissao ;
		
	}
	public CategoriadoProduto(String caminho, int chave, String valorChave) throws Exception{
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> categoriadoProdutos = leitor.conteudo();
		String categoriadoProduto = categoriadoProdutos.get(0);
		System.out.println(categoriadoProduto);
		String[] campos = categoriadoProduto.split(";");
		this.IdCategoria = Integer.parseInt(campos [0]);
		this.finalidadeCategoria = campos [1];
		this.percentualComissao = Float.parseFloat(campos[2]);
		
	}
	@Override
	public String toString() {
		return "CategoriadoProduto [IdCategoria=" + IdCategoria + ", Finalidade da Categoria=" + finalidadeCategoria +", Percentual da Comissão="  + percentualComissao +  " ]";
		
	}
}
