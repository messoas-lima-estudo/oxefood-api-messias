package br.edu.ifpe.oxefood.categoriaProduto;

import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoService {
    private final CategoriaProdutoRepository repository;

    public CategoriaProdutoService(CategoriaProdutoRepository repository) {
        this.repository = repository;
    }

    public CategoriaProduto build(CategoriaProdutoDTO dto) {
        CategoriaProduto categoriaProduto = null;
        if (dto.getId() == null) {
            categoriaProduto = new CategoriaProduto();
        } else {
            categoriaProduto = repository.findById(dto.getId()).get();

        }
        categoriaProduto.setId(dto.getId());
        categoriaProduto.setDescricao(dto.getDescricao());
        return categoriaProduto;
    }

    public CategoriaProduto cadastrar(CategoriaProdutoDTO dto){
        CategoriaProduto categoriaProduto = this.build(dto);
        repository.save(categoriaProduto);
        return categoriaProduto;

    }

}
