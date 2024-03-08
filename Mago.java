package Dungeon_Clash;

import Dungeon_Clash.Habilidade;
import Dungeon_Clash.PesosDeAtributos;
import java.lang.Math;

public class Mago extends Classe {
  private int nivel;

  public Mago(int nivel, int forca, int agilidade, int inteligencia, Habilidade[] habilidades) {
    super(forca, agilidade, inteligencia, habilidades);
    this.nivel = nivel;
    Habilidade socar = new Habilidade("Socar", new PesosDeAtributos(nivel * Math.ceil(agilidade * 0.1 + forca * 0.1)),
        new PesosDeAtributos(0), 2, false, false, 1);
    Habilidade enfraquecer = new Habilidade("Enfraquecer",
        new PesosDeAtributos(nivel * Math.ceil(agilidade * 0.2 + forca * 0.3 + inteligencia * 0.5)),
        new PesosDeAtributos(nivel * Math.ceil(inteligencia * 0.5)), 5, false, false, 2);
    Habilidade curaAmigo = new Habilidade("Cura Amigo",
        new PesosDeAtributos(nivel * Math.ceil(agilidade * 0.2 + forca * 0.5 + inteligencia * 0.8)),
        new PesosDeAtributos(nivel * Math.ceil(inteligencia * 0.7)), 4, false, true, 3);

    adicionarHabilidade(socar);
    adicionarHabilidade(enfraquecer);
    adicionarHabilidade(curaAmigo);
  }
}
