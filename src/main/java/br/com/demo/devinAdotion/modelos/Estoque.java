package br.com.demo.devinAdotion.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_estoque")
public class Estoque {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private  String produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private  String animal;

    @Column(nullable = false)
    private  String categoria;

    @ManyToOne
    @JoinColumn(name = "armazem_id", nullable = false)
    @NotNull
    private Armazem armazem;

}
