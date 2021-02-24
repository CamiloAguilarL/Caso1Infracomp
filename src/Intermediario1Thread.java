
public class Intermediario1Thread extends Thread{
	
	private Intermediario1 ref;

	public Intermediario1Thread(Intermediario1 ref){
		this.ref = ref;	
	}
	
	@Override
	public void run(){
		super.run();
		System.out.println("Inicio ejecuci�n thread intermediario 1");
		ref.transferir();
		System.out.println("Final ejecuci�n thread intermediario 1");
	}
}
