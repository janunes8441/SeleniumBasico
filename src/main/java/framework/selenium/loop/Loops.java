package framework.selenium.loop;

/**
 * Classe de exemplo para demonstrar os três tipos de loops em Java:
 * - for
 * - while
 * - do-while
 * 
 * Todos os métodos imprimem:
 * - valor da variável de controle
 * - condição usada no loop
 * - comentários explicativos para melhor entendimento.
 */
public class Loops {

    public static void main(String[] args) {
        System.out.println("=== Loop For ===");
        loopFor(3); // Primeiro: loop for

        System.out.println("\n=== Loop While ===");
        loopWhile(); // Segundo: loop while

        System.out.println("\n=== Loop Do-While ===");
        loopDoWhile(); // Terceiro: loop do-while
    }

    /**
     * Exemplo de loop for
     * @param maxLoop - limite máximo do loop (inclusive)
     */
    public static void loopFor(int maxLoop) {
        System.out.println("Início do loop For: i inicia em 0, condição i <= " + maxLoop + ", i++");

        for (int i = 0; i <= maxLoop; i++) {
            // Imprime o valor atual de 'i' e a condição que ainda é verdadeira
            System.out.println("i = " + i + " (i <= " + maxLoop + " : true)");
        }

        System.out.println("Fim do loop For (i = " + (maxLoop + 1) + ", condição i <= " + maxLoop + " : false)");
    }

    /**
     * Exemplo de loop while
     */
    public static void loopWhile() {
        int i = 0; // inicializa a variável de controle

        System.out.println("Início do loop While: i inicia em 0, condição i <= 2");

        while (i <= 2) {
            // Imprime valor atual de i e a condição avaliada
            System.out.println("i = " + i + " (i <= 2 : true) -> Ainda está no loop");

            // Incrementa i
            i++;
        }

        // Mensagem após sair do loop
        System.out.println("Saiu do loop While (i = " + i + ", condição i <= 2 : false)");
    }

    /**
     * Exemplo de loop do-while
     */
    public static void loopDoWhile() {
        int i = 1; // inicializa a variável de controle

        System.out.println("Início do loop Do-While: i inicia em 1, condição i <= 3");

        do {
            // Imprime valor atual de i e a condição que ainda é verdadeira
            System.out.println("i = " + i + " (i <= 3 : true) -> Ainda está no loop");

            i++; // incrementa i
        } while (i <= 3);

        System.out.println("Saiu do loop Do-While (i = " + i + ", condição i <= 3 : false)");
    }

} 
