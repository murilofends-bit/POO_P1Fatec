import java.util.ArrayList;
import java.util.Random;

public class Personagem {

    String nome;
    private int energia;
    private int fome;
    private int sono;
    private ArrayList<String> mochila;
    private ArrayList<Musica> repertorio;

    private Random random = new Random();

    Personagem() {
        System.out.println("Construindo novo personagem");
        energia = 10;
        fome = 0;
        sono = 0;
        mochila = new ArrayList<>();
        repertorio = new ArrayList<>();
    } 

    Personagem(String nome, int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem\n");
        this.nome = nome;
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        repertorio = new ArrayList<>();
        mochila = new ArrayList<>();
    }

    void cacar() {
        if (energia >= 2) {
            System.out.printf("%s caçando\n", nome);
            energia -= 2;

            String[] itens = {"pena", "couro", "osso", "presa", "garra"};
            String itemSorteado = itens[random.nextInt(itens.length)];

            mochila.add(itemSorteado);
            System.out.println(nome + " encontrou: " + itemSorteado);

        } else {
            System.out.printf("%s sem energia para caçar\n", nome);
        }

        if (fome < 10) {
            fome = fome + 1;
        }

        sono = sono == 10 ? sono : sono + 1;
    }

    void comer() {
        if (fome >= 1) {
            System.out.println(nome + " comendo");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            System.out.println(nome + " sem fome");
        }
    }

    void dormir() {
        if (sono >= 1) {
            System.out.print(nome + " dormindo\n");
            energia = energia == 10 ? energia : energia + 1;
            sono -= 1;
        } else {
            System.out.println(nome + " deitou sem sono");
        }
    }

    boolean estaVivo() {
        return energia > 0;
    }

    void aprenderMusica(ArrayList<Musica> disponiveis) {
        Musica musicaSorteada = disponiveis.get(random.nextInt(disponiveis.size()));

        if (repertorio.contains(musicaSorteada)) {
            System.out.println(nome + " já conhece: " + musicaSorteada);
        } else {
            repertorio.add(musicaSorteada);
            System.out.println(nome + " aprendeu: " + musicaSorteada);
        }
    }
    
    void adicionarMusicaInicial(Musica musica) {
        repertorio.add(musica);
    }

    Musica sortearMusicaDoRepertorio() {
        if (repertorio.isEmpty()) {
            return null;
        }
        return repertorio.get(random.nextInt(repertorio.size()));
    }

    void perderEnergia() {
        energia = energia - 1;
    }    

    void aprenderMusica(Musica musica) {
        if (!repertorio.contains(musica)) {
            repertorio.add(musica);
        }
    }

    void duelar(Personagem adversario) {
        Musica musica = sortearMusicaDoRepertorio();

        if (musica == null) {
            System.out.println(nome + " tentou duelar, mas não conhece nenhuma música");
            return;
        }

        System.out.println(nome + " iniciou duelo com: " + musica);

        if (adversario.repertorio.contains(musica)) {
            System.out.println("Ambos conhecem a música! Público entediado...");
            this.perderEnergia();
            adversario.perderEnergia();
        } else {
            System.out.println(adversario.nome + " não conhece a música! Perdeu o duelo");
            adversario.perderEnergia();
            adversario.aprenderMusica(musica);
            System.out.println(adversario.nome + " aprendeu: " + musica);
        }
    }

    public String toString() {
        return String.format(
            "\n*****Status*****\n%s: e:%d, f:%d, s:%d\nmochila:%s\nrepertorio:%s",
            nome, energia, fome, sono, mochila, repertorio
        );
    }
}