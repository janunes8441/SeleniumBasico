package framework.selenium.loop;

public class Loops {

	public static void main(String[] args) {
		testeWhile();

	}
	
	public static void testeFor(int maxLoop) {
		
		for (int i=0;i<=maxLoop;++i) {
			System.out.println("Numero: "+i);
		}
		
		
		
	}
	
	public static void testeWhile() {
		
		int i=0;
		
		while(i<= 2) {
			
			System.out.println("Ainda está no loop");
			
			i++;
			
		}
		
		System.out.println("Saiu do loop");
	}
	
	

}
