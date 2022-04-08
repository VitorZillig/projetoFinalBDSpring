package br.com.letscode.projetofinal.controller;

import br.com.letscode.projetofinal.dto.ProdutoDTO;
import br.com.letscode.projetofinal.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public Page<ProdutoDTO> listProdutos(
            @RequestParam(name = "codigo") List<Integer> codigo,
            Pageable pageable
    ){
        return produtoService.listAll(codigo,pageable);
    }

    @GetMapping("/page")
    public Page<ProdutoDTO> listProdutos(Pageable pageable){
        return produtoService.listAll(pageable);
    }

    @PostMapping
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.criarProduto(produtoDTO);
    }
}
