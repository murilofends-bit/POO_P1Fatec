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

    Personagem(int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        mochila = new ArrayList<>();
        repertorio = new ArrayList<>();
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

    // método comer
    void comer() {
        if (fome >= 1) {
            System.out.println(nome + " comendo");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            System.out.println(nome + " sem fome");
        }
    }

    // método dormir
    void dormir() {
        if (sono >= 1) {
            System.out.print(nome + " dormindo\n");
            energia = energia == 10 ? energia : energia + 1;
            sono -= 1;
        } else {
            System.out.println(nome + " sem sono");
        }
    }

    boolean estaVivo() {
        return energia > 0;
    }

    void aprenderMusica(ArrayList<Musica> disponiveis) {

        Musica musicaSorteada = disponiveis.get(
            random.nextInt(disponiveis.size())
        );

        if (repertorio.contains(musicaSorteada)) {
            System.out.println(nome + " já conhece: " + musicaSorteada);
        } else {
            repertorio.add(musicaSorteada);
            System.out.println(nome + " aprendeu: " + musicaSorteada);
        }
    }

    public String toString() {
        return String.format(
            "%s: e:%d, f:%d, s:%d, mochila:%s, repertorio:%s",
            nome, energia, fome, sono, mochila, repertorio
        );
    }
}