package co.com.almundo.call.modelo;

import co.com.almundo.call.controlador.Dispatcher;

public abstract class AbsEmpleado extends Thread implements Comparable<AbsEmpleado>{
	
	protected String desCargo;
	protected CargoEmpleado cargo;
	
	private Llamada llamada;
	private Dispatcher dis;
	
	public AbsEmpleado(Dispatcher dis, String empleado) {
		this.dis = dis;
		this.desCargo = empleado;
	}
	
	public int getPrioridad(){
		return this.cargo.getPrioridad();
	}
	
	public int compareTo(AbsEmpleado e2) {
		if (this.getPrioridad() < e2.getPrioridad()){
			return -1;
		}
		if (this.getPrioridad() > e2.getPrioridad()){
			return 1;
		}
		return 0;	
	}
	
	public void contestarLlamada(Llamada llamada) {
		System.out.println("Se contesta llamada " + llamada.getNumeroLlamada());
		this.llamada = llamada;
		this.start();
	}
	
	
	
	public void run(){
		try {
			System.out.println("Ingresa llamada con duración " + llamada.getDuracionLlamada() * 1000);
			Thread.sleep(llamada.getDuracionLlamada() * 1000);
			System.out.println("Llamada "+llamada.getNumeroLlamada() + " atendida en : " + llamada.getDuracionLlamada() + " minutos Por el empleado " + desCargo);
			this.addDisponible(dis);
			System.out.println("Empleado " + this.getEmpleado() + " disponible");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getEmpleado() {
		return desCargo;
	}

	public void setEmpleado(String empleado) {
		this.desCargo = empleado;
	}

	abstract void addDisponible(Dispatcher dis);
}
