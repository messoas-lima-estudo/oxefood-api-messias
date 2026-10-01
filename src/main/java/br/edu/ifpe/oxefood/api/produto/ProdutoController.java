package br.edu.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }


    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoDTO dto) {
         Produto produtoCadastrado = this.produtoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody ProdutoDTO dto) {
        Produto produtoAtualizado = produtoService.atualizar(dto);        
        return ResponseEntity.ok(produtoAtualizado);
    }

               @GetMapping
    public ResponseEntity<List<Produto>> listar() {

        return ResponseEntity.ok(produtoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }
       
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.remover(id);
        return ResponseEntity.noContent().build();
   }
    


}
