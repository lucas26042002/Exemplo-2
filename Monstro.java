package Dungeon_Clash;

import Dungeon_Clash.Habilidade;
import Dungeon_Clash.PesosDeAtributos;
import java.lang.Math;

public class Monstro extends Classe {
  private int nivel;

  public Monstro(int nivel, int forca, int agilidade, int inteligencia, Habilidade[] habilidades) {
    super(forca, agilidade, inteligencia, habilidades);
    this.nivel = nivel;
    Habilidade socar = new Habilidade("Socar", new PesosDeAtributos(nivel * Math.ceil(agilidade * 0.4 + forca * 0.8)),
        new PesosDeAtributos(0), 5, false, false, 1);
    Habilidade chutar = new Habilidade("Chutar", new PesosDeAtributos(nivel * Math.ceil(agilidade * 0.5 + forca * 1.0)),
        new PesosDeAtributos(0), 8, false, false, 2);
    Habilidade gritoAtordoante = new Habilidade("Grito Atordoante",
        new PesosDeAtributos(nivel * Math.ceil(agilidade * 0.2 + forca * 0.4)),
        new PesosDeAtributos(0), 6, true, false, 3);

    adicionarHabilidade(socar);
    adicionarHabilidade(chutar);
    adicionarHabilidade(gritoAtordoante);
  }
}
