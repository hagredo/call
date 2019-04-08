package co.com.almundo.call.controlador;

import co.com.almundo.call.modelo.Director;
import co.com.almundo.call.modelo.Llamada;
import co.com.almundo.call.modelo.Operador;
import co.com.almundo.call.modelo.Supervisor;
import junit.framework.TestCase;

public class DispatcherTest extends TestCase{
	
	public void test() {
		try {
			Dispatcher dis = new Dispatcher();
			dis.start();
			dis.addEmpleado(new Operador(dis, "Operador1"));
			dis.addEmpleado(new Operador(dis, "Operador2"));
			
			dis.addEmpleado(new Supervisor(dis, "Supervisor"));
			//dis.addEmpleado(new Operador(dis, "Operador3"));
			dis.addEmpleado(new Director(dis, "Director"));
			//dis.addEmpleadoDisponible(new Operador(dis, "Operador3"));
			Llamada llamada = new Llamada("número 1");
			llamada.setDuracionLlamada(6);
			Llamada llamada2 = new Llamada("número 2");
			llamada2.setDuracionLlamada(10);
			Llamada llamada3 = new Llamada("número 3");
			llamada3.setDuracionLlamada(5);
			Llamada llamada4 = new Llamada("número 4");
			llamada4.setDuracionLlamada(5);
			Llamada llamada5 = new Llamada("número 5");
			llamada5.setDuracionLlamada(6);
			Llamada llamada6 = new Llamada("número 6");
			llamada6.setDuracionLlamada(8);
			Llamada llamada7 = new Llamada("número 7");
			llamada7.setDuracionLlamada(7);
			Llamada llamada8 = new Llamada("número 8");
			llamada8.setDuracionLlamada(9);
			Llamada llamada9 = new Llamada("número 9");
			llamada9.setDuracionLlamada(6);
			Llamada llamada10 = new Llamada("número 10");
			llamada10.setDuracionLlamada(7);
			
			dis.dispatchCall(llamada);
			dis.dispatchCall(llamada2);
			dis.dispatchCall(llamada3);
			dis.dispatchCall(llamada4);
			dis.dispatchCall(llamada5);
			dis.dispatchCall(llamada5);
			dis.dispatchCall(llamada6);
			dis.dispatchCall(llamada7);
			dis.dispatchCall(llamada8);
			dis.dispatchCall(llamada9);
			dis.dispatchCall(llamada10);
			Thread.sleep(100000);
			assertTrue(dis.getLlamadas().isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
