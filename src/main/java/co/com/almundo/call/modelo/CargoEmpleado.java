package co.com.almundo.call.modelo;

public enum CargoEmpleado {
	OPERADOR(1),
	SUPERVISOR(2),
	DIRECTOR(3);
	
	private int prioridad;
	
	CargoEmpleado(int prioridad){
		this.prioridad = prioridad;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
}
