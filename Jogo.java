import java.util.Random;

public class Jogo {
  public static void main(String[] args) throws InterruptedException {

    Personagem cacador = new Personagem();
    cacador.nome = "John";

    Random random = new Random();

    while (true){

      int acao = random.nextInt(3);

      if (acao == 0) {
        cacador.cacar();
      } else if (acao == 1) {
        cacador.comer();
      } else {
        cacador.dormir();
      }

      System.out.println(cacador);
      System.out.println("====================");

      Thread.sleep(5000);
    }
  }
}