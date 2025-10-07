package framework.selenium.condicionais;

public class IfElse {

    // Variável de classe
    public static String nomeAnimal = "passarinho";

    public static void main(String[] args) {
    
        // Chamando o método para verificar o animal
        animal(nomeAnimal);

    }
    
    // if / else / else if
    public static void animal(String nomeAnimal) {
        
        if(nomeAnimal.equals("gato") || nomeAnimal.equals("cachorro")) {
            System.out.println("Esse é um animal de estimação!");
        } else if (nomeAnimal == "passarinho") {
        	System.out.println("Aves");
        } else {
            System.out.println("Esse animal não é um animal de estimação conhecido.");
        }
        
    }

}
