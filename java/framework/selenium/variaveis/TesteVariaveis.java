package framework.selenium.variaveis;

/**
 * Classe de teste para demonstrar o comportamento de:
 * - Variáveis de instância (não estáticas)
 * - Variáveis de classe (estáticas)
 */
public class TesteVariaveis {

    // Variável global (estática) da classe
    public static String curso = "Variavel Global";

    public static void main(String[] args) {
        testeVariaveis();         // Testa variáveis de instância
        testeVariavelEstatica();  // Testa variáveis estáticas
    }

    /**
     * Demonstra o comportamento de variáveis não estáticas (instância)
     * Cada objeto possui sua própria cópia da variável
     */
    public static void testeVariaveis() {

        // Variável local do método
        String curso = "Variavel Local";

        // Criando várias instâncias de VariaveisNaoEstaticas
        VariaveisNaoEstaticas naoEstatica1 = new VariaveisNaoEstaticas();
        VariaveisNaoEstaticas naoEstatica2 = new VariaveisNaoEstaticas();
        VariaveisNaoEstaticas naoEstatica3 = new VariaveisNaoEstaticas();
        VariaveisNaoEstaticas naoEstatica4 = new VariaveisNaoEstaticas();

        System.out.println("-------------testeVariaveis Antes-------------");

        // Cada instância possui seu próprio valor da variável 'nome'
        System.out.println(naoEstatica1.nome);
        System.out.println(naoEstatica2.nome);
        System.out.println(naoEstatica3.nome);
        System.out.println(naoEstatica4.nome);

        // Mostra a variável local do método
        System.out.println(curso);

        // Alterando o valor da variável de uma instância
        naoEstatica2.nome = "Curso basico Java";

        System.out.println("-------------testeVariaveis Depois-------------");

        // Mostra que apenas a instância alterada mudou
        System.out.println(naoEstatica1.nome);
        System.out.println(naoEstatica2.nome);
        System.out.println(naoEstatica3.nome);
        System.out.println(naoEstatica4.nome);
    }

    /**
     * Demonstra o comportamento de variáveis estáticas
     * Todas as instâncias compartilham a mesma cópia da variável
     */
    public static void testeVariavelEstatica() {

        System.out.println("-------------testeVariavelEstatica Antes-------------");

        // Acessando a variável estática diretamente pela classe
        System.out.println(VariaveisEstaticas.cor);
        System.out.println(VariaveisEstaticas.cor);
        System.out.println(VariaveisEstaticas.cor);
        System.out.println(VariaveisEstaticas.cor);

        // Mostra a variável global
        System.out.println(curso);

        // Alterando a variável estática
        VariaveisEstaticas.cor = "Vermelho Ferrari";

        System.out.println("-------------testeVariavelEstatica Depois-------------");

        // Todas as instâncias refletem a alteração, pois é estática
        System.out.println(VariaveisEstaticas.cor);
        System.out.println(VariaveisEstaticas.cor);
        System.out.println(VariaveisEstaticas.cor);
        System.out.println(VariaveisEstaticas.cor);
    }
}
