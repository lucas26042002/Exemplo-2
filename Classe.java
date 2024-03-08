package Dungeon_Clash;

import Dungeon_Clash.Habilidade;
import Dungeon_Clash.PesosDeAtributos;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Classe {
  private int forca;
  private int agilidade;
  private int inteligencia;
  private final List<Habilidade> habilidades;

  public Classe(int forca, int agilidade, int inteligencia, Habilidade[] habilidades) {
    this.forca = forca;
    this.agilidade = agilidade;
    this.inteligencia = inteligencia;
    this.habilidades = new ArrayList<>(Arrays.asList(habilidades));
  }

  public float getForca() {
    return forca;
  }

  public void setForca(int forca) {
    this.forca = forca;
  }

  public float getAgilidade() {
    return agilidade;
  }

  public void setAgilidade(int agilidade) {
    this.agilidade = agilidade;
  }

  public float getInteligencia() {
    return inteligencia;
  }

  public void setInteligencia(int inteligencia) {
    this.inteligencia = inteligencia;
  }

  public void adicionarHabilidade(Habilidade habilidade) {
    habilidades.add(habilidade);
  }
}
