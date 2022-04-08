package br.com.letscode.projetofinal.model;

import br.com.letscode.projetofinal.dto.ProdutoDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "preco")
    private Float preco;

    @Column (name = "qtd")
    private int quantidade;

    public static Produto convert(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());
        return produto;
    }
    public static ProdutoDTO convertToDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setQuantidade(produto.getQuantidade());
        return produtoDTO;
    }
}
