
public class BuzonIntermedio {

	private int contador;

	private String tipo;

	public BuzonIntermedio(){
		this.contador = 0;
		this.tipo = "";
	}

	public synchronized void agregar(String tipo){

		if(contador == 1){
			try {	
				wait();
			} catch (Exception e) {}
		}

		contador++;
		this.tipo = tipo;
		
		System.out.println("Agregar Unidad Buzón Intermedio \nUnidades: " + contador + "\nCapacidad: "+ 1 +"\n----------------");
		
		if(contador >1 || contador < 0){
			System.out.println("Error - Agregar Unidad Buzón Intermedio\n" + "Unidades: " + contador +"\n----------------");
		}

		notify();

	}

	public synchronized String eliminar(){

		if(contador == 0){
			try {	
				wait();
			} catch (Exception e) {}
		}

		contador--;
		String temp = this.tipo;
		this.tipo = "";
		
		System.out.println("Eliminar Unidad Buzón Intermedio \nUnidades: " + contador + "\nCapacidad: "+ 1 +"\n----------------");

		if(contador >1 || contador < 0){
			
			System.out.println("Error - Eliminar Unidad Buzón Intermedio\n" + "Unidades: " + contador +"\n----------------");
		}
		
		notify();

		return temp;

	}
}
