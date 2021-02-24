
public class Consumidor {

	private int numProductos;

	private BuzonConsumidor buffer;

	public Consumidor(BuzonConsumidor buffer, int numProductos){
		this.buffer = buffer;
		this.numProductos = numProductos;
	}

	public void consumir(String tipo){

		for (int i = 0; i < numProductos; i++) {
			buffer.eliminar(tipo);
		}
	}

	public BuzonConsumidor getBuffer(){
		return this.buffer;
	}

}
