
public class ConsumidorThread extends Thread{
	
	private String tipoProducto;
	
	private Consumidor ref;
	
	private int id;
	
	public ConsumidorThread(String tipoProducto, Consumidor ref, int id){
		this.tipoProducto = tipoProducto;
		this.ref = ref;
		this.id = id;
	}
	
	@Override
	public void run(){
		super.run();
		System.out.println("Inicio ejecuci�n thread consumidor: " + Integer.toString(id));
		ref.consumir(tipoProducto);
		System.out.println("Final ejecuci�n thread consumidor: " + Integer.toString(id));
	}
}
