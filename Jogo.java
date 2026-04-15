import java.util.Random;
import java.util.ArrayList;

public class Jogo {
  public static void main(String[] args) throws InterruptedException {

    Personagem cacador = new Personagem();
    cacador.nome = "John";

    Random random = new Random();

    ArrayList<Musica> playlist = new ArrayList<>();
    playlist.add(new Musica("Evidencias"));
    playlist.add(new Musica("Dormi na praca"));
    playlist.add(new Musica("Chora me Liga"));
    playlist.add(new Musica("Smells Like Teen Spirit"));
    playlist.add(new Musica("Pais tropical"));
    playlist.add(new Musica("Sweet Child O' Mine"));
    playlist.add(new Musica("Pense em mim"));
    playlist.add(new Musica("As it was"));
    playlist.add(new Musica("Despacito"));
    playlist.add(new Musica("Mockingbird"));

    while (true){

      int acao = random.nextInt(4);

      if (acao == 0) {
        cacador.cacar();
      } else if (acao == 1) {
        cacador.comer();
      } else if (acao == 2) {
        cacador.dormir();
      }
      else {
        cacador.aprenderMusica(playlist);
      }
    
    if (!cacador.estaVivo()) {
        System.out.println(cacador.nome + " morreu!");
        System.out.println("Relatório final:");
        System.out.println(cacador); // mostra mochila final
        break; // encerra o jogo
    }

      System.out.println(cacador);
      System.out.println("====================");

      Thread.sleep(5000);
    }
  }
}