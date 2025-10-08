package framework.selenium.operadores;

public class Operadores {

    public static void main(String[] args) {
        
        // Operador de atribuição
        System.out.println("Operadores de atribuição");
        
        int numero = 0;
        
        System.out.printf("Valor inicial da variável numero: %d%n", numero);
        
        numero = 10;
        System.out.printf("Novo valor da variável numero: %d%n", numero);
        
        // Linha em branco
        System.out.println();
        
        // Operadores aritméticos
        System.out.println("Operadores Aritiméticos");
        
        // Adição
        numero = numero + 1;
        System.out.printf("Adição +1: %d%n", numero);
        
        // Subtração
        numero = numero - 1;
        System.out.printf("Subtração -1: %d%n", numero);
        
        // Multiplicação
        numero = numero * 2;
        System.out.printf("Multiplicação x2: %d%n", numero);
        
        // Divisão
        numero = numero / 2;
        System.out.printf("Divisão /2: %d%n", numero);
        
        // Resto
        numero = numero % 3;
        System.out.printf("Resto %%3: %d%n", numero);
        
        numero = numero + 40 - 15 * 2 / 10;
        System.out.printf("Expressão escrita em notação infixa com precedência implícita: %d%n", numero);
        
        numero = (numero + 40) - (15 * 2) / 10;
        System.out.printf("Expressão escrita em notação parentetizada: %d%n", numero);
        
        // Linha em branco
        System.out.println();
        
        // Operadores relacionais
        System.out.println("Operadores relacionais");
        
        int A = 10;
        int B = 20;
        int C = 50;
        
        System.out.println("A == B? " + ((A == B) ? "verdadeiro" : "falso"));
        System.out.println("A != B? " + ((A != B) ? "verdadeiro" : "falso"));
        System.out.println("A > B? " + ((A > B) ? "verdadeiro" : "falso"));
        System.out.println("A < B? " + ((A < B) ? "verdadeiro" : "falso"));
        System.out.println("A >= B? " + ((A >= B) ? "verdadeiro" : "falso"));
        System.out.println("A <= B? " + ((A <= B) ? "verdadeiro" : "falso"));
        
        // Linha em branco
        System.out.println();
        
        //Operadores lógicos
        System.out.println("Operadores lógicos");
        
        // AND (&&)
        System.out.println("(A < B) && (B < C)? " + ((A < B && B < C) ? "verdadeiro" : "falso"));
        System.out.println("(A > B) && (B < C)? " + ((A > B && B < C) ? "verdadeiro" : "falso"));

        // OR (||)
        System.out.println("(A < B) || (B > C)? " + ((A < B || B > C) ? "verdadeiro" : "falso"));
        System.out.println("(A > B) || (B > C)? " + ((A > B || B > C) ? "verdadeiro" : "falso"));

        // NOT (!)
        System.out.println("!(A == B)? " + (!(A == B) ? "verdadeiro" : "falso"));
        System.out.println("!(A < B)? " + (!(A < B) ? "verdadeiro" : "falso"));
        
        // Linha em branco
        System.out.println();
        
        //Operadores incremento e decremento
        System.out.println("Operadores incremento e decremento");
        
        // Incremento prefixo
        System.out.println("++A = " + (++A)); // A é incrementado antes de imprimir
        System.out.println("++B = " + (++B));

        // Incremento sufixo
        System.out.println("C++ = " + (C++)); // C é impresso primeiro, depois incrementado
        System.out.println("C agora = " + C); // Mostra o novo valor de C

        // Decremento prefixo
        System.out.println("--A = " + (--A)); // A é decrementado antes de imprimir
        System.out.println("--B = " + (--B));

        // Decremento sufixo
        System.out.println("C-- = " + (C--)); // C é impresso primeiro, depois decrementado
        System.out.println("C agora = " + C); // Mostra o novo valor de C
        
        
    }
}
