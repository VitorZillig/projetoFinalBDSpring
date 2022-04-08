package br.com.letscode.projetofinal.repository;

import br.com.letscode.projetofinal.model.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompraRepository extends JpaRepository<Compra,Integer>, JpaSpecificationExecutor<Compra> {

    public String PRODUTOS = "produtos";

    Page<Compra> findByCpfCliente(String cpf, Pageable pageable);


}
