package br.edu.ifsp.xyz.comissao;

import java.util.ArrayList;
import java.util.Arrays;

import br.edu.ifsp.xyz.leitor.Leitor;
import br.edu.ifsp.xyz.util.Data;

public class Produto {
    private int IdProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private CategoriadoProduto categoriaProduto;

    public Produto(int IdProduto, String nomeProduto, String descricaoProduto) {
        this.IdProduto = IdProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
    }
    

    public CategoriadoProduto getCategoriaProduto() {
		return categoriaProduto;
	}


	public Produto(String caminho, int chave, String valorChave) throws Exception {
        Leitor leitor = new Leitor(caminho, chave, valorChave);
        ArrayList<String> produtos = leitor.conteudo();
        String produto = produtos.get(0);
        System.out.println(produto);
        String[] campos = produto.split(";");
        this.IdProduto = Integer.parseInt(campos[0]);
        String valorCategoriaProduto = campos[1];
        this.nomeProduto = campos[2];
        this.descricaoProduto = campos[3];

        String caminhoCategoriaProduto = "../srcComissao/CategoriadoProduto.txt";
        int chaveCategoriaProduto = 0;
        
		this.categoriaProduto = new CategoriadoProduto(caminhoCategoriaProduto, chaveCategoriaProduto, valorCategoriaProduto);

        //leitor = new Leitor(caminhoCategoriaProduto, chaveCategoriaProduto, valorCategoriaProduto);
        //ArrayList<String> categoriaProdutos = leitor.conteudo();
       // int qtCategoriaProdutos = categoriaProdutos.size();
       // this.categoriaProduto = new CategoriadoProduto[qtCategoriaProdutos];
       // int indiceCategoriaProduto = 0;
       // for (String categoriaProdutAux : categoriaProdutos) {
       //     campos = categoriaProdutAux.split(";");
       //     int IdCategoria = Integer.parseInt(campos[0]);
       //     String finalidadeCategoria = campos[1].replace("\"", "");
       //     String percentualComissaoString = campos[2].replace("%", "");
       //     float percentualComissao = Float.parseFloat(percentualComissaoString);
       //     CategoriadoProduto categoriaProduto = new CategoriadoProduto(IdCategoria, finalidadeCategoria,percentualComissao);
       //     this.categoriaProduto[indiceCategoriaProduto] = categoriaProduto;
       //     indiceCategoriaProduto++;
       // }
    }

    @Override
    public String toString() {
        return " Produto [IdProduto=" + IdProduto + ", Produto=" + nomeProduto + ", Descrição do Produto=" + descricaoProduto
                + "]\n---> Categoria =" + categoriaProduto + " ]";
    }
}
