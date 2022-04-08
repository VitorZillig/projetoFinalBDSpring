package br.com.letscode.projetofinal.service;

import br.com.letscode.projetofinal.dto.CompraDTO;
import br.com.letscode.projetofinal.model.Compra;
import br.com.letscode.projetofinal.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {
    private final CompraRepository compraRepository;

    public Page<CompraDTO> listAll(List<String> cpf, Pageable pageable){
        return compraRepository.findByCpfCliente(cpf.get(0),pageable).map(CompraDTO::convert);
    }

    public Page<CompraDTO> listAll(Pageable pageable) {
        return compraRepository.findAll(pageable).map(CompraDTO::convert);
    }

    public CompraDTO criarCompra(CompraDTO compraDTO){
        Compra compra = Compra.convert(compraDTO);
       Float soma = compraDTO.getProdutos().stream().map(produtoDTO -> produtoDTO.getPreco()).reduce(0F,Float::sum);
        compra.setValorTotalCompra(soma);
        compraRepository.save(compra);
       return CompraDTO.convert(compra);
    }

}
