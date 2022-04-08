package br.com.letscode.projetofinal.dto;

import br.com.letscode.projetofinal.model.Compra;
import br.com.letscode.projetofinal.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CompraDTO {
    private String cpfCliente;
    private List<ProdutoDTO> produtos;

    public static CompraDTO convert(Compra compra){
        CompraDTO compraDTO = new CompraDTO();
        List<ProdutoDTO>produtos = compra.getProdutos().stream().map(Produto::convertToDTO).collect(Collectors.toList());
        compraDTO.setCpfCliente(compra.getCpfCliente());
        compraDTO.setProdutos(produtos);
        return compraDTO;
    }
}
