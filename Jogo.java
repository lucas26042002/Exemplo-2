package Dungeon_Clash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Jogo {
  public void iniciarBatalha(String filePath) {
    BufferedReader br = null;

    Equipe group = new Equipe();
    group.addPersonagem(new Arqueiro(1, 2, 3, 4, new Habilidade[] {}));
    group.addPersonagem(new Guerreiro(1, 2, 3, 4, new Habilidade[] {}));
    group.addPersonagem(new Mago(1, 2, 3, 4, new Habilidade[] {}));

    try {
      br = new BufferedReader(new FileReader(filePath));
      String line;
      while ((line = br.readLine()) != null) {
        if (line.equals("fase")) {
          List<Inimigo> inimigos = new ArrayList<>();
          while ((line = br.readLine()) != null && !line.equals("fase")) {
            String[] enemyInfo = line.split(" ");
            String nome = enemyInfo[0];
            String classe = enemyInfo[1];
            int nivel = Integer.parseInt(enemyInfo[2]);
            Inimigo inimigo = new Inimigo(nome, nivel, 0.0f, 0.0f, 0, classe);
            inimigos.add(inimigo);
          }

          // Exibir informações dos personagens e inimigos
          exibirInformacoes(group, inimigos);
          // Sortear primeiro atacante
          Personagem primeiroAtacante = sortearPrimeiroAtacante(group.getPersonagens());
          // Iniciar batalha
          batalha(group, inimigos, primeiroAtacante);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  private void exibirInformacoes(Equipe group, List<Inimigo> inimigos) {
    System.out.println("INFORMAÇÕES DOS PERSONAGENS:");
    for (Personagem personagem : group.getPersonagens()) {
      System.out.println(personagem.toString());
    }
    System.out.println("INIMIGOS:");
    for (Inimigo inimigo : inimigos) {
      System.out.println(inimigo.toString());
    }
  }

  private Personagem sortearPrimeiroAtacante(List<Personagem> personagens) {
    Random random = new Random();
    int indice = random.nextInt(personagens.size());
    return personagens.get(indice);
  }

  public void batalha(Equipe group, List<Inimigo> inimigos, Personagem primeiroAtacante) {
    System.out.println("É HORA DO DUELO!");

    while (!inimigos.isEmpty()) {
      Inimigo inimigo = inimigos.get(0);
      Personagem atacante = group.nextAttack();
      if (atacante != null) {
        int dano = atacante.attack(inimigo);
        inimigo.damageSuffered(dano);
        if (inimigo.getPV() <= 0) {
          inimigos.remove(inimigo);
        }
      }

      for (Inimigo enemy : inimigos) {
        if (inimigo.getPV() > 0) {
          for (Personagem personagem : Objects.requireNonNull(group.getPersonagens())) {
            if (personagem.getPV() > 0) {
              inimigo.attack(personagem);
              if (personagem.getPV() <= 0) {
                System.out.println(personagem.getNome() + " foi derrotado!");
                group.removerPersonagem(personagem.getNome());
                break;
              }
            }
          }
        }
      }
    }
    if (!group.getPersonagens().isEmpty()) {
      System.out.println("GANHAMO!");
    } else {
      System.out.println("PERDEMO!");
    }
  }
}
