package co.com.almundo.call.modelo;

import co.com.almundo.call.controlador.Dispatcher;

public class Operador extends AbsEmpleado{

	
	public Operador(Dispatcher dis, String empleado) {
		super(dis, empleado);
		this.cargo = cargo.OPERADOR;
	}


	@Override
	void addDisponible(Dispatcher dis) {
		dis.addEmpleado(new Operador(dis, desCargo));
	}
	
}
