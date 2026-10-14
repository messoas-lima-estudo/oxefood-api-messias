package br.edu.ifpe.oxefood.categoriaProduto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoriaproduto")
public class CategoriaProdutoController {

    private final CategoriaProdutoService CategoriaProdutoservice;

    public CategoriaProdutoController(CategoriaProdutoService service) {
        this.CategoriaProdutoservice = service;

    }

    @PostMapping
    public ResponseEntity<CategoriaProduto> cadastrar(@RequestBody CategoriaProdutoDTO dto) {
        CategoriaProduto categoriaProduto = CategoriaProdutoservice.cadastrar(dto);
        return ResponseEntity.ok(categoriaProduto);
    }

}
