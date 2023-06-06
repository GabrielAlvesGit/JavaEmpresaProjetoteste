package br.edu.ifsp.xyz.comissao;
import java.util.ArrayList;
import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

public class ZonadeVenda {
	private String idUf;
	private String nome;
	private RegiaodeVenda regiaodeVenda;
	
	public ZonadeVenda(String idUf,String nome, RegiaodeVenda regiaodeVenda) {
        this.idUf = idUf;
        this.nome = nome;
        this.regiaodeVenda = regiaodeVenda;
    }
	 
	
	public ZonadeVenda(String caminho, int chave, String valorChave) throws Exception{
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> zonadeVendas = leitor.conteudo();
		String zonadeVenda = zonadeVendas.get(0);
		System.out.println(zonadeVenda);
		String[] campos = zonadeVenda.split(";");
		this.idUf = (campos[0]);
		this.nome = (campos[1]);
		String idRegiao = campos[2];
		//System.out.println("----->>>>" + idRegiao + "<<<----");
		this.regiaodeVenda = new RegiaodeVenda("../srcComissao/RegiaoVenda.txt", 0, idRegiao);
		//System.out.println("@@@@@@ " + this.regiaodeVenda);
		
	}
	@Override
	public String toString() {
		return "ZonadeVenda [idUf=" + idUf + ", nome=" + nome + ", regiaodeVendas=" + regiaodeVenda + "]";
	}
}
