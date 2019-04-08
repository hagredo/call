package co.com.almundo.call.controlador;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import co.com.almundo.call.modelo.AbsEmpleado;
import co.com.almundo.call.modelo.Llamada;


public class Dispatcher extends Thread{
	BlockingQueue<AbsEmpleado> empleadosDisponibles;
	BlockingQueue<Llamada> llamadas;
	public Dispatcher(){
		System.out.println("Ingresa dispatcher");
		empleadosDisponibles = new PriorityBlockingQueue<AbsEmpleado>();
		llamadas = new LinkedBlockingQueue<Llamada>();
	}
	
	public void dispatchCall(Llamada llamada){
		try {
			System.out.println("Ingresa llamada "+llamada.getNumeroLlamada());
			llamadas.put(llamada);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		Llamada llamada;
		AbsEmpleado empleado;
		try {
			while(true) {
				llamada = llamadas.take();
				System.out.println("Esperando acesores disponibles para atender la llamada " + llamada.getNumeroLlamada());
				empleado = empleadosDisponibles.take();
				System.out.println("El empleado " + empleado.getEmpleado() + " contesto la llamada " + llamada.getNumeroLlamada());
				empleado.contestarLlamada(llamada);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addEmpleado(AbsEmpleado empleado){
		this.empleadosDisponibles.add(empleado);
	}
	
	public Queue<Llamada> getLlamadas(){
		return llamadas;
	}
	
	public Queue<AbsEmpleado> getEmpleadosDisponibles(){
		return empleadosDisponibles;
	}
}
