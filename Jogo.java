import java.util.Random;
import java.util.ArrayList;

public class Jogo {
  public static void main(String[] args) throws InterruptedException {

    Personagem cacador = new Personagem();
    cacador.nome = "John";

    Personagem tico = new Personagem("Tico Trovador", 3, 8, 8);
    tico.adicionarMusicaInicial(new Musica("Morena"));

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

    boolean campeaoDeclarado = false;

    while (true){

        // loop john
        if (cacador.estaVivo()) {
            cacador.aprenderMusica(playlist);

            int acao = random.nextInt(3);

            if (acao == 0) {
                cacador.cacar();
            } else if (acao == 1) {
                cacador.comer();
            } else {
                cacador.dormir();
            }
        }

        // loop tico
        if (tico.estaVivo()) {
            tico.aprenderMusica(playlist);

            int acaoTico = random.nextInt(100);

            if (acaoTico < 20) {
                tico.cacar();
            } else if (acaoTico < 40) {
                tico.comer();
            } else {
                tico.dormir();
            }
        }

        // duelo (só se ambos estiverem vivos)
        if (cacador.estaVivo() && tico.estaVivo()) {
            int quemDuela = random.nextInt(2);

            if (quemDuela == 0) {
                cacador.duelar(tico);
            } else {
                tico.duelar(cacador);
            }
        }

        // morte dos dois
        if (!cacador.estaVivo() && !tico.estaVivo()) {
            System.out.println("Ambos morreram!");
            System.out.println("Relatório final:");
            System.out.println(cacador);
            System.out.println(tico);
            break;
        }

        // morte do john
        if(!campeaoDeclarado){
            if (!cacador.estaVivo() && tico.estaVivo()) {
                System.out.println(cacador.nome + " morreu!");
                System.out.println(cacador);
                System.out.println(tico.nome + " é o campeão!");
                campeaoDeclarado = true;
                
            }
        }

        // morte do tico
        if(!campeaoDeclarado){
            if (!tico.estaVivo() && cacador.estaVivo()) {
                System.out.println(tico.nome + " morreu!");
                System.out.println(tico);
                System.out.println(cacador.nome + " é o campeão!");
                campeaoDeclarado = true;
                
            }
        }

        // estatísticas
        if (cacador.estaVivo()) {
            System.out.println(cacador);
        }

        if (tico.estaVivo()) {
            System.out.println(tico);
        }

        System.out.println("==========================================\n");

        Thread.sleep(5000);
    }
  }
}