import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {

        // Lendo a letra
        Scanner scanner = new Scanner(System.in);

        // Definindo a palavra a ser advinhada
        String palavraSecreta = "JAVA";

        // Acertar a letra substitui o sublinhado pela mesma
        char[] palavraOculta = new char[palavraSecreta.length()];

        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraOculta[i] = '_';
        }

        // Número máximo de tentativas
        int tentativas = 6;
        boolean venceu = false;

        // Loop que solicita as letras para o usuário
        while (tentativas > 0) {
            System.out.println("Palavra: " + String.valueOf(palavraOculta));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");

            char letra = scanner.next().toUpperCase().charAt(0);

            System.out.println(letra);

            boolean acertou = false;

            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    palavraOculta[i] = letra;
                    acertou = true;
                }
            }

            // Dedução de tentativas
            if (!acertou) {
                tentativas--;
                System.out.println("Letra incorreta.");
            } else {
                System.out.println("Letra correta.");
            }

            if (String.valueOf(palavraOculta).equals(palavraSecreta)) {
                venceu = true;
                break;
            }
        }

        // Condição de vitória
        if (venceu) {
            System.out.println("Parabéns, você venceu! Ainda restavam " + tentativas + " tentativas.");
        } else {
            System.out.println("Você perdeu!");
        }

        System.out.println("A palavra era: " + palavraSecreta);

        // Fechando scanner
        scanner.close();

    }
}