
public class BuzonConsumidor {

	private int capacidad;

	private static int contadorA;

	private static int contadorB;

	public BuzonConsumidor(int capacidad){
		this.capacidad = capacidad;
		this.contadorA = 0;
		this.contadorB = 0;
	}

	public void eliminar(String tipo){

		boolean validante = true;

		while(validante){

			while(contadorA <= 0 && tipo.equals("A")){
				Thread.yield();
			}

			while(contadorB <= 0 && tipo.equals("B")){
				Thread.yield();
			}

			synchronized(this){

				if(contadorA-1>=0 && tipo.equals("A")){
					contadorA--;
					System.out.println("Eliminar Unidad Buzón Consumidores \nA: " + contadorA + "\nB: " + contadorB + "\nCapacidad: "+ capacidad +"\n----------------");
					validante=false;
					notify();
				}else if(contadorB-1>=0 && tipo.equals("B")){
					contadorB--;
					System.out.println("Eliminar Unidad Buzón Consumidores \nA: " + contadorA + "\nB: " + contadorB + "\nCapacidad: "+ capacidad +"\n----------------");
					validante=false;
					notify();
				}
				
				if(contadorA<0){
					System.out.println("Error - Eliminar Unidad Buzón Consumidores\n" + "A: " + contadorA);
				}
				
				if(contadorB<0){
					System.out.println("Error - Eliminar Unidad Buzón Consumidores\n" + "B: " + contadorB);
				}
			}
		}
	}

	public synchronized void agregar(String tipo){

		if(contadorA+contadorB>=capacidad){
			try {
				wait();
			} catch (Exception e) {}
		}

		if(tipo.equals("A")){
			contadorA++;
		}else{
			contadorB++;
		}
		
		System.out.println("Agregar Unidad Buzón Consumidores \nA: " + contadorA + "\nB: " + contadorB + "\nCapacidad: "+ capacidad +"\n----------------");

		if(contadorA+contadorB>capacidad){
			System.out.println("Error - Agregar Unidad Buzón Consumidores \n A: " + contadorA + "\nB: " + contadorB + "\nCapacidad: " + capacidad + "\n----------------");
		}

	}
}
