package br.com.letscode.projetofinal.service;

import br.com.letscode.projetofinal.dto.ProdutoDTO;
import br.com.letscode.projetofinal.model.Produto;
import br.com.letscode.projetofinal.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Page<ProdutoDTO> listAll(List<Integer> codigo, Pageable pageable){
        return produtoRepository.findByCodigo(codigo.get(0),pageable).map(ProdutoDTO::convert);
    }

    public Page<ProdutoDTO> listAll(Pageable pageable){
        return produtoRepository.findAll(pageable).map(ProdutoDTO::convert);
    }

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO){
        Produto produtoBD = produtoRepository.save(Produto.convert(produtoDTO));
        return ProdutoDTO.convert(produtoBD);
    }

}
