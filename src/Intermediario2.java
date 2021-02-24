
public class Intermediario2 {

	private BuzonIntermedio buzonIntermedio;	

	private BuzonConsumidor buzonConsumidor;
	
	private int unidades;

	public Intermediario2(BuzonIntermedio buzonIntermedio, BuzonConsumidor buzonConsumidor, int unidades){
		this.buzonIntermedio = buzonIntermedio;
		this.buzonConsumidor = buzonConsumidor;
		this.unidades = unidades;
	}

	public void transferir(){

		String tipo;
		int contador = 0;

		while(contador<unidades){
			tipo = buzonIntermedio.eliminar();
			buzonConsumidor.agregar(tipo);
			contador++;
		}
	}
}
