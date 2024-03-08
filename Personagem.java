package Dungeon_Clash;

import Dungeon_Clash.Classe;
import Dungeon_Clash.Gerenciar;
import java.util.ArrayList;
import java.lang.Float;

public class Personagem {
  private String nome;
  private int nivel;
  private int PE;
  private float PV;
  private float PM;
  private int tempoEspera;
  private Classe classe;
  private final int ID;

  public Personagem(String nome, int nivel, int PE, float PV,
      float PM, int tempoEspera, Classe classe, int ID) {
    this.nome = nome;
    this.nivel = nivel;
    this.PE = PE;
    this.PV = PV;
    this.PM = PM;
    this.tempoEspera = tempoEspera;
    this.classe = classe;
    this.ID = ID;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public int getPE() {
    return PE;
  }

  public void setPE(int PE) {
    this.PE = PE;
  }

  public float getPV() {
    return PV;
  }

  public void setPV(float PV) {
    this.PV = PV;
  }

  public float calcularPVMax(float PVMax) {
    return nivel * classe.forca + (nivel * classe.agilidade / 2);
  }

  public float getPM() {
    return PM;
  }

  public void setPM(float PM) {
    this.PM = PM;
  }

  public float calcularPMMax() {
    return nivel * classe.inteligencia + (nivel * classe.agilidade / 3);
  }

  public int getTempoEspera() {
    return tempoEspera;
  }

  public void setTempoEspera(int tempoEspera) {
    this.tempoEspera = tempoEspera;
  }

  public Classe getClasse() {
    return classe;
  }

  public void setClasse(Classe classe) {
    this.classe = classe;
  }

  public int getID() {
    return ID;
  }

  public void receiveEXP(int enemyLevel) {
    PE += enemyLevel * 5;
  }

  public void levelUp(int EXP) {
    PE += EXP;
    int expToLevelUp = 25 * nivel;
    if (PE >= expToLevelUp) {
      nivel++;
      PE -= expToLevelUp;
    }
  }

  public void attack(Personagem enemy, float dano) {
    enemy.damageSuffered(dano);
  }

  public void groupAttack(Personagem[] group, float dano) {
    for (Personagem aliado : group) {
      aliado.damageSuffered(dano);
    }
  }

  public void damageSuffered(float dano) {
    PV -= dano;
    if (PV <= 0) {
      // Personagem morre
      System.out.println(nome + "morreu...");
      Gerenciar.removerPersonagem(this.ID);
    }
  }

  public enum Classe {
    ARQUEIRO(1, 3, 2),
    GUERREIRO(4, 1, 1),
    MAGO(1, 2, 3),
    MONSTRO(4, 1, 0);

    private final int forca;
    private final int agilidade;
    private final int inteligencia;

    Classe(int forca, int agilidade, int inteligencia) {
      this.forca = forca;
      this.agilidade = agilidade;
      this.inteligencia = inteligencia;
    }
  }
}
