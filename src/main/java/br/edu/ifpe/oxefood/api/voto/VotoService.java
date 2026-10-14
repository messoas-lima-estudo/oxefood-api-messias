package br.edu.ifpe.oxefood.api.voto;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service 
public class VotoService {
    private final VotoRepository repository;

    public VotoService(VotoRepository repository) {
        this.repository = repository;
    }

    public Voto build(VotoDTO dto) {

        Voto voto = null;

        if (dto.getId() == null) { // Montado para o cadastro

            voto = new Voto();

        } else { // Consultado para a alteração

            voto = repository.findById(dto.getId()).get();
        }

        voto.setNomeEleitor(dto.getNomeEleitor());
        voto.setNumeroRegistroEleitoral(dto.getNumeroRegistroEleitoral());
        voto.setDataVotacao(dto.getDataVotacao());
        voto.setNumeroCandidatoDepFederal(dto.getNumeroCandidatoDepFederal());
        voto.setNumeroCandidatoDepEstadual(dto.getNumeroCandidatoDepEstadual());
        voto.setNumeroCandidatoSenador(dto.getNumeroCandidatoSenador());
        voto.setNumeroCandidatoGovernador(dto.getNumeroCandidatoGovernador());
        voto.setNumeroCandidatoPresidente(dto.getNumeroCandidatoPresidente());
        return voto;
    }

    @Transactional
    public Voto cadastrar(VotoDTO dto) {
        Voto voto = build(dto);
        voto.setHabilitado(true);
        return repository.save(voto);
    }

    public List<Voto> listar() {
        return repository.findAll();
    }

    @Transactional
    public void remover(Long id) {

        Voto voto = repository.findById(id).get();
        voto.setHabilitado(false);
        repository.save(voto);
    }

    @Transactional
    public Voto atualizar(VotoDTO dto) {
        Voto voto = build(dto);
        return repository.save(voto);
    }
      public Voto buscarPorId(Long id) {

        return repository.findById(id).get();
    }

}
