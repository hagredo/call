package co.com.almundo.call.modelo;

import co.com.almundo.call.controlador.Dispatcher;
import co.com.almundo.call.modelo.Director;
//import co.com.almundo.call.modelo.TipoEmpleado;

public class Director extends AbsEmpleado{
	public Director(Dispatcher dis, String empleado){
		super(dis, empleado);
		this.cargo = cargo.DIRECTOR;
	}

	@Override
	void addDisponible(Dispatcher dis) {
		dis.addEmpleado(new Director(dis, desCargo));
	}

}
