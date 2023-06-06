package br.edu.ifsp.xyz.comissao;
import java.util.ArrayList;
import br.edu.ifsp.xyz.leitor.Leitor;

public class Empresa {
	private String cnpj;
	private String nomeEmp;
	
	public Empresa(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> empresas = leitor.conteudo();
		String empresa = empresas.get(0);
		System.out.println(empresa);
		String[] campos = empresa.split(";");
		this.cnpj = (campos[0]);
		this.nomeEmp = campos[1];
	}
	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", nomeEmp=" + nomeEmp + "]";
		
	}
}
