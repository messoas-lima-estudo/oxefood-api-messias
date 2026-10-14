package br.edu.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// faz o getter e o setter na mesma lina o@DAta
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

   @NotNull(message = "O Nome é de preenchimento obrigatório")
   @NotEmpty(message = "O Nome é de preenchimento obrigatório")
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres") // lengt so presta pra string

    private String nome;

    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF é de preenchimento obrigatório") // sibstotio o not null e not Empty
    @CPF

    private String cpf;
    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String foneCelular;

    private String foneFixo;

}
