package br.com.letscode.projetofinal.dto;

import br.com.letscode.projetofinal.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    private Float preco;
    private Integer quantidade;

    public static ProdutoDTO convert(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setQuantidade(produto.getQuantidade());
        return produtoDTO;
    }

    public static Produto convert(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());
        return produto;
    }
}
