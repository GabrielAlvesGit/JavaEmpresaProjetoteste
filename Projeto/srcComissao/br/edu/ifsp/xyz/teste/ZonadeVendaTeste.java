package br.edu.ifsp.xyz.teste;
import br.edu.ifsp.xyz.comissao.ZonadeVenda;

public class ZonadeVendaTeste {
	public static void main(String[] args) throws Exception {
		ZonadeVenda zonadeVenda = new ZonadeVenda("../srcComissao/ZonaVenda.txt",0,"AC");
		System.out.println("--->" + zonadeVenda);
	}
}
