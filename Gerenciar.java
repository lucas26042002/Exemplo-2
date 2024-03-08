package Dungeon_Clash;

import java.util.ArrayList;
import java.util.List;

public class Gerenciar {
  private List<Personagem> personagens;
  private List<Inimigo> inimigos;

  public Gerenciar() {
    this.personagens = new ArrayList<>();
  }

  public void adicionarPersonagem(Personagem p) {
    personagens.add(p);
  }

  public static void removerPersonagem(int ID) {
    Gerenciar jogo = new Gerenciar();
    for (Personagem personagem : jogo.personagens) {
      if (personagem != null && personagem.getID() == ID) {
        jogo.personagens.remove(personagem);
        break;
      }
    }
  }

  public static void removerInimigo(int ID) {
    Gerenciar jogo = new Gerenciar();
    for (Inimigo inimigo : jogo.inimigos) {
      if (inimigo != null && inimigo.getID() == ID) {
        jogo.inimigos.remove(inimigo);
        break;
      }
    }
  }
}
