package br.edu.ifsp.xyz.teste;

import br.edu.ifsp.xyz.comissao.Empresa;

public class EmpresaTeste {
	public static void main(String[] args) throws Exception {
		Empresa empresa = new Empresa("../srcComissao/Empresa.txt", 0, "2023");
		System.out.println("--->" + empresa);
	}
}
