package br.com.letscode.projetofinal.controller;

import br.com.letscode.projetofinal.dto.CompraDTO;
import br.com.letscode.projetofinal.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {
    private final CompraService compraService;
    @GetMapping
    public Page<CompraDTO> listCompras(@RequestParam(name="cpf") List<String> cpf, Pageable pageable){
        return compraService.listAll(cpf,pageable);
    }

    @GetMapping("/page")
    public Page<CompraDTO> listCompras(Pageable pageable){
        return compraService.listAll(pageable);
    }


    @PostMapping
    public CompraDTO criarCompra(@RequestBody CompraDTO compraDTO){
        return compraService.criarCompra(compraDTO);
    }
}
