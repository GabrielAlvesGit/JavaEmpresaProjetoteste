package br.edu.ifsp.xyz.teste;
import br.edu.ifsp.xyz.comissao.RepresentantedeVenda;

public class RepresentantedeVendaTeste {
	public static void main(String[] args) throws Exception {
		RepresentantedeVenda representantedeVenda = new RepresentantedeVenda("../srcComissao/RepresentantedeVenda.txt", 0, "1");
		System.out.println("--->" + representantedeVenda);
	}
}
