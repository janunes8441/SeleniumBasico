package framework.selenium.variaveis;


public class TesteVariaveis {
	
	public static String curso = "Variavel Global";
	
	public static void main(String[] args) {
		testeVariaveis();
		testeVariavelEstatica();
	}
	
	public static void testeVariaveis(){
		
		
	String curso = "Variavel Local";
	
	VariaveisNaoEstaticas naoEstatica1 = new VariaveisNaoEstaticas();
	VariaveisNaoEstaticas naoEstatica2 = new VariaveisNaoEstaticas();
	VariaveisNaoEstaticas naoEstatica3 = new VariaveisNaoEstaticas();
	VariaveisNaoEstaticas naoEstatica4 = new VariaveisNaoEstaticas();
	
	System.out.println("-------------testeVariaveis Antes-------------");
	
	System.out.println(naoEstatica1.nome);
	System.out.println(naoEstatica2.nome);
	System.out.println(naoEstatica3.nome);
	System.out.println(naoEstatica4.nome);
	
	System.out.println(curso);
	
	naoEstatica2.nome="Curso basico Java";
	
	System.out.println("-------------testeVariaveis Depois-------------");
	
	System.out.println(naoEstatica1.nome);
	System.out.println(naoEstatica2.nome);
	System.out.println(naoEstatica3.nome);
	System.out.println(naoEstatica4.nome);
	
}

	public static void testeVariavelEstatica() {
		
		
		VariaveisEstaticas estatica1 = new VariaveisEstaticas();
		VariaveisEstaticas estatica2 = new VariaveisEstaticas();
		VariaveisEstaticas estatica3 = new VariaveisEstaticas();
		VariaveisEstaticas estatica4 = new VariaveisEstaticas();
		
		System.out.println("-------------testeVariavelEstatica Antes-------------");
		
		System.out.println(estatica1.cor);
		System.out.println(estatica2.cor);
		System.out.println(estatica3.cor);
		System.out.println(estatica4.cor);
		
		System.out.println(curso);
		
		estatica2.cor="Vermelho Ferrari";
		
		System.out.println("-------------testeVariavelEstatica Depois-------------");
		
		System.out.println(estatica1.cor);
		System.out.println(estatica2.cor);
		System.out.println(estatica3.cor);
		System.out.println(estatica4.cor);
	}
		
		
	}
