
public class BuzonProductor {

	private int capacidad;

	private static int contadorA;

	private static int contadorB;

	public BuzonProductor(int capacidad){
		this.capacidad = capacidad;
		this.contadorA = 0;
		this.contadorB = 0;
	}

	public void agregar(String tipo){

		boolean validante = true;

		while(validante){
			while( contadorA + contadorB >= capacidad ){
				Thread.yield();
			}

			synchronized(this){

				if(contadorA+1+contadorB <= capacidad && tipo.equals("A")){
					contadorA++;
					System.out.println("Agregar Unidad Buzón Productores \nA: " + contadorA + "\nB: " + contadorB + "\nCapacidad: "+ capacidad +"\n----------------");
					validante = false;
					notify();
				}else if(contadorA+1+contadorB <= capacidad && tipo.equals("B")){
					contadorB++;
					System.out.println("Agregar Unidad Buzón Productores \nA: " + contadorA + "\nB: " + contadorB + "\nCapacidad: "+ capacidad +"\n----------------");
					validante = false;
					notify();
				}			

				if(contadorA+contadorB>capacidad){
					System.out.println("Error - Agregar Unidad Buzón Productores \nA: " + contadorA + "\nB: " + contadorB + "\nCapacidad: "+ capacidad +"\n----------------");
				}
			}
		}
	}

	public synchronized String eliminar(){

		String tipo;

		if(contadorA+contadorB<=0){
			try {
				wait();
			} catch (Exception e) {

			}
		}

		Double aleatorio = Math.random();

		if(contadorA>0 && aleatorio >= 0.5){
			contadorA--;
			tipo = "A";
		}else if(contadorB>0 && aleatorio <0.5){
			contadorB--;
			tipo = "B";
		}else if(contadorA>0){
			contadorA--;
			tipo = "A";
		}else{
			contadorB--;
			tipo = "B";
		}
		
		System.out.println("Eliminar Unidad Buzón Productores \nA: " + contadorA + "\nB: " + contadorB + "\nCapacidad: "+ capacidad +"\n----------------");

		if(contadorA<0){
			System.out.println("Error - Eliminar Unidad Buzón Productores\n"+ "A: " + contadorA);
		}

		if(contadorB<0){
			System.out.println("Error - Eliminar Unidad Buzón Productores\n"+ "B: " + contadorB);
		}

		return tipo;
	}

}
