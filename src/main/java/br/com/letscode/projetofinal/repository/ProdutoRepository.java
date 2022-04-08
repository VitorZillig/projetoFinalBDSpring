package br.com.letscode.projetofinal.repository;

import br.com.letscode.projetofinal.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    Page<Produto> findByCodigo(Integer codigo, Pageable pageable);
}
