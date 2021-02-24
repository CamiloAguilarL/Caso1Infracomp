
public class Intermediario2Thread extends Thread{
	
	private Intermediario2 ref;

	public Intermediario2Thread(Intermediario2 ref){
		this.ref = ref;	
	}

	@Override
	public void run(){
		super.run();
		System.out.println("Final ejecución thread intermediario 2");
		ref.transferir();
		System.out.println("Final ejecución thread intermediario 2");
	}
}
