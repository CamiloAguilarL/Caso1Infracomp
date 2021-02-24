import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Productor {

	private int numProductos;

	private BuzonProductor buffer;

	public Productor(BuzonProductor buffer, int numProductos){
		this.buffer = buffer;
		this.numProductos = numProductos;
	}

	public void producir(String tipo){

		for (int i = 0; i < numProductos; i++) {
			buffer.agregar(tipo);
		}
	}

	public BuzonProductor getBuffer(){
		return this.buffer;
	}

	
	
	public static void main(String[] args) {
		
		/*
		 * Camilo Aguilar León c.aguilarl
		 * Juan RIcardo Diaz jr.diaz
		 */
		System.out.println("Hecho por: Camilo Aguilar León (c.aguilarl) y Juan Ricardo Diaz (jr.diaz)");
		System.out.println("Inicio ejecución productores y consumidores");
		System.out.println("Se valido de tal manera que se imprime en la consola un mensaje iniciando por ERROR cuando no se cumple un requerimiento.");
		System.out.println("También se imprime todos los cambios en los buzones que permiten ver su evolución y así validar manualmente los requerimientos");
		System.out.println("---------------------------------------------------------------------------------");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

        FileInputStream fis = null;
        Properties prop = null;
        try {
        	
            fis = new FileInputStream("config.properties");
            // create Properties class object
            prop = new Properties();
            // load properties file into it
            prop.load(fis);
            
            int numProdCons = Integer.parseInt(prop.getProperty("concurrencia.numProdCons"));
            int numProductos = Integer.parseInt(prop.getProperty("concurrencia.numProductos"));
            int buzonesProd = Integer.parseInt(prop.getProperty("concurrencia.buzonesProd"));
            int buzonesCons = Integer.parseInt(prop.getProperty("concurrencia.buzonesCons"));

    		BuzonProductor buzonProductor = new BuzonProductor(buzonesProd);
    		Productor productor = new Productor(buzonProductor, numProductos);

    		BuzonIntermedio buzonIntermedio = new BuzonIntermedio();

    		BuzonConsumidor buzonConsumidor = new BuzonConsumidor(buzonesCons);
    		Consumidor consumidor = new Consumidor(buzonConsumidor, numProductos);

    		for (int i = 0; i < numProdCons; i++) {
    			if(i%2 == 0){
    				new ProductorThread("A",productor, i).start();
    				new ConsumidorThread("A", consumidor, i).start();
    			}
    			else{
    				new ProductorThread("B",productor, i).start();
    				new ConsumidorThread("B", consumidor, i).start();
    			}
    		}

    		new Intermediario1Thread( new Intermediario1(productor.getBuffer(), buzonIntermedio, numProductos*numProdCons) ).start();
    		new Intermediario2Thread( new Intermediario2(buzonIntermedio, consumidor.getBuffer(), numProductos*numProdCons)).start();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

}
