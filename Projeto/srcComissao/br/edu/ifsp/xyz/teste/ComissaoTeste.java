package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Comissao;

public class ComissaoTeste {
	public static void main(String[] args) throws Exception {
		Comissao comissao = new Comissao("../srcComissao/Comissao.txt", 0, "1");
		System.out.println("--->" + comissao);
	}
}
