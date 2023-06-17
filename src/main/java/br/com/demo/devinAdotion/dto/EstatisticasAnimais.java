package br.com.demo.devinAdotion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EstatisticasAnimais
{
    private long total;
    private long totalComAntipulgas;
    private long totalComAntiparasitario;
    private double mediaRacao;
}
