package Dungeon_Clash;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Equipe {
  private Personagem[] personagens;
  private List<Personagem> group;

  public Equipe(Personagem[] personagens) {
    this.personagens = personagens;
    this.group = new ArrayList<>();
  }

  public void addPersonagem(Personagem p) {
    for (int i = 0; i < personagens.length; i++) {
      if (personagens[i] == null) {
        personagens[i] = p;
        return;
      }
    }
  }

  public Personagem searchPersonagem(String nome) {
    for (Personagem p : personagens) {
      if (p != null && p.getNome().equals(nome)) {
        return p;
      }
    }
    return null;
  }

  public Personagem removerPersonagem(String nome) {
    for (int i = 0; i < personagens.length; i++) {
      if (personagens[i] != null && personagens[i].getNome().equals(nome)) {
        Personagem removido = personagens[i];
        personagens[i] = null;
        return removido;
      }
    }
    return null;
  }

  public List<Personagem> getPersonagens() {
    return Arrays.asList(personagens);
  }

  public List<Personagem> returnGroup() {
    return group;
  }

  public void groupEXP(int enemyLevel) {
    for (Personagem p : personagens) {
      if (p != null) {
        p.receiveEXP(enemyLevel);
      }
    }
  }

  public Personagem nextAttack() {
    for (Personagem p : personagens) {
      if (p != null && p.getTempoEspera() == 0) {
        return p;
      }
    }
    return null;
  }

  public void attCooldown() {
    for (Personagem p : personagens) {
      if (p != null && p.getTempoEspera() > 0) {
        p.setTempoEspera(p.getTempoEspera() - 1);
      }
    }
  }
}
