package framework.selenium.condicionais;

public class SwithCase {

	public static void main(String[] args) {

		animal("gato");

	}

	// switch-case

	public static void animal(String nomeAnimal) {

		String animal = "URSO";
		if (animal.equalsIgnoreCase("urso")) {
			System.out.println("Achou");

		} else {
			System.out.println("Errado");
		}

		switch (nomeAnimal) {

		case "gato":
			System.out.println("Animal de estimação");
			break;

		case "tubarão":
			System.out.println("Animal marinho");
			break;

		case "passarinho":
			System.out.println("Ave");
			break;

		default:
			System.out.println("Animal não identificado!");

		}

	}
}
