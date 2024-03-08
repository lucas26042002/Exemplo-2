package Dungeon_Clash;

import Dungeon_Clash.PesosDeAtributos;

public class Habilidade {
  private String nome;
  private PesosDeAtributos pesosDano, pesosMana;
  private int tempo;
  private boolean afetaTodos;
  private boolean afetaAmigos;
  private int ID;

  public Habilidade(String nome, PesosDeAtributos pesosDano, PesosDeAtributos pesosMana,
      int tempo, boolean afetaTodos, boolean afetaAmigos, int ID) {

    this.nome = nome;
    this.pesosDano = pesosDano;
    this.pesosMana = pesosMana;
    this.tempo = tempo;
    this.afetaTodos = afetaTodos;
    this.afetaAmigos = afetaAmigos;
    this.ID = ID;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public PesosDeAtributos getPesosDano() {
    return pesosDano;
  }

  public void setPesosDano(PesosDeAtributos pesosDano) {
    this.pesosDano = pesosDano;
  }

  public PesosDeAtributos getPesosMana() {
    return pesosMana;
  }

  public void setPesosMana(PesosDeAtributos pesosMana) {
    this.pesosMana = pesosMana;
  }

  public int getTempo() {
    return tempo;
  }

  public void setTempo(int tempo) {
    this.tempo = tempo;
  }

  public boolean isAfetaTodos() {
    return afetaTodos;
  }

  public void setAfetaTodos(boolean afetaTodos) {
    this.afetaTodos = afetaTodos;
  }

  public boolean isAfetaAmigos() {
    return afetaAmigos;
  }

  public void setAfetaAmigos(boolean afetaAmigos) {
    this.afetaAmigos = afetaAmigos;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }
}
