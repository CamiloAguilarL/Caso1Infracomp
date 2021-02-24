
public class ProductorThread extends Thread{
	
	private String tipoProducto;
	
	private Productor ref;
	
	private int id;
	
	public ProductorThread(String tipoProducto, Productor ref, int id){
		this.tipoProducto = tipoProducto;
		this.ref = ref;
		this.id = id;
	}
	
	@Override
	public void run(){
		super.run();
		System.out.println("Inicio ejecución thread productor: " + Integer.toString(id));
		ref.producir(tipoProducto);
		System.out.println("Final ejecución thread productor: " + Integer.toString(id));
		
	}
}
