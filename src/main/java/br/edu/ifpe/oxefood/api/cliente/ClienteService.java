package br.edu.ifpe.oxefood.api.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente build(ClienteDTO dto) {

        Cliente cliente = null;

        if (dto.getId() == null) { // Montado para o cadastro

            cliente = new Cliente();

        } else { // Consultado para a alteração

            cliente = repository.findById(dto.getId()).get();
        }

        cliente.setNome(dto.getNome());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setCpf(dto.getCpf());
        cliente.setFoneCelular(dto.getFoneCelular());
        cliente.setFoneFixo(dto.getFoneFixo());

        return cliente;
    }

    // mexeu em dados deve por, pra dar read n vai precisar, tem a ver com dar
    // commit work se der tudo certo, apesar de ser só uma operacao
    @Transactional
    public Cliente cadastrar(ClienteDTO dto) {

        Cliente cliente = build(dto);
        cliente.setHabilitado(true);
        return repository.save(cliente); // INSERT pq n joguei com ID
    }

    @Transactional
    public Cliente atualizar(ClienteDTO dto) {

        Cliente cliente = build(dto);
        return repository.save(cliente); // update pq passei objeto com ID
    }

    public List<Cliente> listar() {

        return repository.findAll(); // SELECT * FROM cliente
    }

    public Cliente buscarPorId(Long id) {

        return repository.findById(id).get();
    }

       @Transactional
   public void remover(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(false);

        repository.save(cliente);
   }


}
