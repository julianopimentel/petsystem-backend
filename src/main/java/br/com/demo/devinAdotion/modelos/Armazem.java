package br.com.demo.devinAdotion.modelos;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_armazem")
public class Armazem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    //@NotBlank(message = " O preenchimento deste campo é obrigatório. ")
    @Column(nullable = false, unique = true)
    private  String nome;

    @Column(nullable = false)
    private String animal;

    @Column(nullable = false) // colocar a regra no front de vir defaul "true"
    private Boolean situacao;


}
