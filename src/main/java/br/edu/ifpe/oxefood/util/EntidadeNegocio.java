package br.edu.ifpe.oxefood.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@MappedSuperclass

public abstract class EntidadeNegocio {
// o @Id faz ele ser chave primaria, generatedvalue deve falar a estrategia pra gerar
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

      @JsonIgnore
    @Column

    private Boolean habilitado;
    
}
