import java.util.Scanner;
public class cacaPalavras {

        public cacaPalavras() {
            Scanner teclado = new Scanner(System.in);
            String[][] palavras = new String[5][2];
            char[][] mapa = new char[10][5];
            palavrasEntrada(palavras);
            mapaEntrada(mapa);
            mapaPesquisa(palavras,mapa);
            do {
                System.out.println("_____ Menu: Caça Palavras _____");
                System.out.println("Opção 1: chamar o método palavrasImprimir;\n" +
                        "Opção 2: chamar o método mapaImprimir;\n" +
                        "Opção 3: chamar o método palavrasRepostas;\n" +
                        "Opção 4: sair;\n");
                System.out.print("Opção : ");
                String opcao = teclado.nextLine();
                switch (opcao){
                    case "1" -> palavrasImprimir(palavras);
                    case "2" -> mapaImprimir(mapa);
                    case "3" -> palavrasRepostas(palavras);
                    case "4" -> {return;}
                    default -> System.out.println("Opção ERRADA!...");
                }
            }while (true);


        }
    private void palavrasImprimir(String[][] palavras){
        System.out.println();
        for (int i = 0; i < palavras.length; i++) {
            System.out.println((i+1)+" : "+palavras[i][0]);
        }
    }
        public void palavrasRepostas(String[][] palavras) {
            for (String[] string : palavras) {
                String resposta = string[1];
                if (string[1] != null) {
                    System.out.println(resposta + " : " + string[0]);
                } else {
                    System.out.println("Palavra não foi encontrada      : " + string[0]);
                }
                System.out.println("---------------------------------");
            }
        }


        private void palavrasEntrada(String[][] palavras){
            palavras[0][0] = "IFELSE";
            palavras[1][0] = "FORA";
            palavras[2][0] = "WHILE";
            palavras[3][0] = "OBJETO";
            palavras[4][0] = "VETOR";
        }

        private void mapaEntrada(char[][]mapa){
            mapa[ 0][ 0]='D';  mapa[ 0][ 1]='C';  mapa[ 0][ 2]='Q';  mapa[ 0][ 3]='W';  mapa[ 0][ 4]='E';
            mapa[ 1][ 0]='I';  mapa[ 1][ 1]='X';  mapa[ 1][ 2]='F';  mapa[ 1][ 3]='O';  mapa[ 1][ 4]='R';
            mapa[ 2][ 0]='F';  mapa[ 2][ 1]='F';  mapa[ 2][ 2]='R';  mapa[ 2][ 3]='G';  mapa[ 2][ 4]='F';
            mapa[ 3][ 0]='E';  mapa[ 3][ 1]='L';  mapa[ 3][ 2]='I';  mapa[ 3][ 3]='H';  mapa[ 3][ 4]='W';
            mapa[ 4][ 0]='L';  mapa[ 4][ 1]='S';  mapa[ 4][ 2]='F';  mapa[ 4][ 3]='O';  mapa[ 4][ 4]='U';
            mapa[ 5][ 0]='S';  mapa[ 5][ 1]='D';  mapa[ 5][ 2]='G';  mapa[ 5][ 3]='T';  mapa[ 5][ 4]='S';
            mapa[ 6][ 0]='E';  mapa[ 6][ 1]='J';  mapa[ 6][ 2]='H';  mapa[ 6][ 3]='E';  mapa[ 6][ 4]='T';
            mapa[ 7][ 0]='I';  mapa[ 7][ 1]='I';  mapa[ 7][ 2]='I';  mapa[ 7][ 3]='J';  mapa[ 7][ 4]='M';
            mapa[ 8][ 0]='X';  mapa[ 8][ 1]='C';  mapa[ 8][ 2]='K';  mapa[ 8][ 3]='B';  mapa[ 8][ 4]='G';
            mapa[ 9][ 0]='V';  mapa[ 9][ 1]='E';  mapa[ 9][ 2]='T';  mapa[ 9][ 3]='O';  mapa[ 9][ 4]='R';
        }


        public void mapaPesquisa(String[][] palavras,char[][] mapa) {
            for (int palavraAtual = 0; palavraAtual < palavras.length; palavraAtual++) {
                int letraAtual = 0;
                for (int l = 0; l < 10; l++) {
                    for (int i = 0; i < 5; i++) {
                        if (mapa[l][i] == palavras[palavraAtual][0].charAt(letraAtual)) {
                            letraAtual++;
                            if (letraAtual == palavras[palavraAtual][0].length()) {
                                palavras[palavraAtual][1] = "[" + l + "," + (i - palavras[palavraAtual][0].length() + 1) + "]";
                                letraAtual = 0;
                            }
                        } else {
                            letraAtual = 0;
                        }
                    }
                }
                letraAtual = 0;
                for (int l = 0; l < 10; l++) {
                    for (int i = 5 - 1; i >= 0; i--) {
                        if (mapa[l][i] == palavras[palavraAtual][0].charAt(letraAtual)) {
                            letraAtual++;
                            if (letraAtual == palavras[palavraAtual][0].length()) {
                                palavras[palavraAtual][1] = "[" + l + "," + (i + palavras[palavraAtual][0].length() - 1) + "]";
                                letraAtual = 0;
                            }
                        } else {
                            letraAtual = 0;
                        }
                    }
                }
                letraAtual = 0;
                for (int c = 0; c < 5; c++) {
                    for (int i = 0; i < 10; i++) {
                        if (mapa[i][c] == palavras[palavraAtual][0].charAt(letraAtual)) {
                            letraAtual++;
                            if (letraAtual == palavras[palavraAtual][0].length()) {
                                palavras[palavraAtual][1] = "[" + (i - palavras[palavraAtual][0].length() + 1) + "," + c + "]";
                                letraAtual = 0;
                            }
                        } else {
                            letraAtual = 0;
                        }
                    }
                }
                letraAtual = 0;
                for (int c = 0; c < 5; c++) {
                    for (int i = 10 - 1; i >= 0; i--) {
                        if (mapa[i][c] == palavras[palavraAtual][0].charAt(letraAtual)) {
                            letraAtual++;
                            if (letraAtual == palavras[palavraAtual][0].length()) {
                                palavras[palavraAtual][1] = "[" + (i + palavras[palavraAtual][0].length() - 1) + "," + c + "]";
                                letraAtual = 0;
                            }
                        } else {
                            letraAtual = 0;
                        }
                    }
                }
            }
        }

        private void mapaImprimir(char[][] mapa){
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(" | " + mapa[i][j] + " ");
                }
                System.out.println(" | ");
            }
        }

    public static void main(String[] args) {
        new cacaPalavras();
    }
    }


