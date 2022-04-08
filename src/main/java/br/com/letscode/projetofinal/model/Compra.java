package br.com.letscode.projetofinal.model;

import br.com.letscode.projetofinal.dto.CompraDTO;
import br.com.letscode.projetofinal.dto.ProdutoDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_compra")
    private LocalDateTime dataCompra;

    @Column (name = "cpf_cliente")
    private String cpfCliente;

    @Column(name = "valor_total_compra")
    private Float valorTotalCompra;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "produto_compra",
            joinColumns = { @JoinColumn(name = "id_compra") },
            inverseJoinColumns = { @JoinColumn(name = "cod_produto") }
    )
    private List<Produto> produtos;

    public static Compra convert(CompraDTO compraDTO){
        Compra compra = new Compra();
        List<Produto> produtos = compraDTO.getProdutos().stream().map(ProdutoDTO::convert).collect(Collectors.toList());
        compra.setDataCompra(LocalDateTime.now());
        compra.setCpfCliente(compraDTO.getCpfCliente());
        compra.setProdutos(produtos);
        return compra;
    }
}
