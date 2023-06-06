package br.edu.ifsp.xyz.teste;
import br.edu.ifsp.xyz.comissao.RegiaodeVenda;

 public class RegiaodeVendaTeste {
		public static void main(String[] args) throws Exception {
			RegiaodeVenda regiaodeVenda = new RegiaodeVenda("../srcComissao/RegiaoVenda.txt", 0, "1");
			System.out.println("--->" + regiaodeVenda);
	}
}
 