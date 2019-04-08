package co.com.almundo.call.modelo;

import co.com.almundo.call.controlador.Dispatcher;

public class Supervisor extends AbsEmpleado{

	public Supervisor(Dispatcher dis, String empleado) {
		super(dis, empleado);
		this.cargo = cargo.SUPERVISOR;
	}


	@Override
	void addDisponible(Dispatcher dis) {
		dis.addEmpleado(new Supervisor(dis, desCargo));
	}

}
