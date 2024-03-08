package Dungeon_Clash;

import Dungeon_Clash.Habilidade;
import Dungeon_Clash.PesosDeAtributos;
import java.lang.Math;

public class Arqueiro extends Classe {
  private int nivel;

  public Arqueiro(int nivel, int forca, int agilidade, int inteligencia, Habilidade[] habilidades) {
    super(forca, agilidade, inteligencia, habilidades);
    this.nivel = nivel;
    Habilidade socar = new Habilidade("Socar", new PesosDeAtributos(nivel * Math.ceil(agilidade * 0.1 + forca * 0.3)),
        new PesosDeAtributos(0), 3, false, false, 1);

    Habilidade atirarFlecha = new Habilidade("Atirar Flecha",
        new PesosDeAtributos(nivel * Math.ceil(forca * 0.3 + agilidade * 0.5)),
        new PesosDeAtributos(0), 4, false, false, 2);

    Habilidade flechaEncantada = new Habilidade("Flecha Encantada",
        new PesosDeAtributos(nivel * Math.ceil(forca * 0.3 + agilidade * 0.5 + inteligencia * 0.4)),
        new PesosDeAtributos(nivel * Math.ceil(inteligencia + agilidade * 0.2)), 7, false, false, 3);

    adicionarHabilidade(socar);
    adicionarHabilidade(atirarFlecha);
    adicionarHabilidade(flechaEncantada);
  }
}
