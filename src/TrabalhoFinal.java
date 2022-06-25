import java.security.PublicKey;
import java.sql.Array;
import java.util.Scanner;

public class TrabalhoFinal {
    public TrabalhoFinal() {
        Scanner teclado = new Scanner(System.in);
        String[][] palavras = new String[5][2];
        String[][] mapa = new String[10][5];
        do {
            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("opção 1: chamar o método palavrasImprimir;\n" +
                    "opção 2: chamar o método mapaImprimir;\n" +
                    "opção 3: chamar o método palavrasRepostas;\n" +
                    "opção 4: sair;\n" + ""
                    + "consistir se foi digitado uma opção errada 'Opção ERRADA!...'");

            palavrasEntrada(palavras);
            mapaEntrada();
            mapaPesquisa();
        } while ();
    }
    public void palavrasEntrada(String[][]palavras){
        palavras[0][0] = "IFELSE";
        palavras[1][0] = "FORA";
        palavras[2][0] = "WHILE";
        palavras[3][0] = "OBJETO";
        palavras[4][0] = "VETOR";
    }
    public void palavrasImprimir(){

    }

    public static void main(String[] args) {
    new TrabalhoFinal();
    }
}
