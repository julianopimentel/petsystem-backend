package br.com.demo.devinAdotion.modelos;

import jakarta.persistence.*;
import lombok.*;
// import jakarta.validation.constraints.NotBlank;


@Data
@Entity
@Table (name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    //@NotBlank(message = " O preenchimento deste campo é obrigatório. ")
    @Column(nullable = false)
    private  String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;



}
