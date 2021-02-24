
public class Intermediario1 {

	private BuzonProductor buzonProductor;
	
	private BuzonIntermedio buzonIntermedio;
	
	private int unidades;

	public Intermediario1(BuzonProductor buzonProductor, BuzonIntermedio buzonIntermedio, int unidades){
		
		this.buzonProductor = buzonProductor;
		this.buzonIntermedio = buzonIntermedio;
		this.unidades = unidades;
		
	}

	public void transferir(){
		
		String tipo;
		int contador = 0;
		
		while(contador<unidades){
		
			tipo = buzonProductor.eliminar();
			buzonIntermedio.agregar(tipo);
			contador++;
		}
	}
}
