import java.util.ArrayList;

public class Concesionario {

	private ArrayList<Vehiculo> garage;
	private ArrayList<Propietario> listaPropietarios;

	public Concesionario() {
		this.garage = new ArrayList<Vehiculo>();
		garage.ensureCapacity(50);
		garage.trimToSize(); 
		this.listaPropietarios = new ArrayList<Propietario>();
	}

	private Vehiculo getVehiculo(int posicion) {
		return this.garage.get(posicion);
	}

	private Propietario getPropietario(int posicion) {
		return this.listaPropietarios.get(posicion);
	}

	private void setKilometros(int posicion, int kilometros) {
		this.garage.get(posicion).setKm(kilometros);
	}

	private void setPropietario(int posicion, Propietario propietario) {
		this.garage.get(posicion).setPropietario(propietario);
	}

	private void annadeVehiculoAPropietario(int posicion, Vehiculo vehiculo) {
		this.listaPropietarios.get(posicion).annadeVehiculo(vehiculo);
	}

	private int estaEnGarage(String matricula) {
		int posicion = -1;
		for (int i = 0; i < this.garage.size(); i++) {
			if (this.garage.get(i).equals(matricula)) {
				posicion = i;
			} else {

			}
		}
		return posicion;
	}

	private int estaEnPropietarios(String dni) {
		int posicion = -1;
		for (int i = 0; i < this.listaPropietarios.size(); i++) {
			if (this.listaPropietarios.get(i).equals(dni)) {
				posicion = i;
			} else {

			}
		}
		return posicion;
	}

	private boolean matriculaValida(String matricula) {
		Vehiculo coche = new Vehiculo();
		return coche.matriculaValida(matricula);
	}

	private boolean dniValido(String dni) {
		Propietario paco = new Propietario("", "", "");
		return paco.dniValido(dni);
	}

	public int nuevoVehiculo(String marca, String matricula, int km, double precio, String descripcion) {
		if (this.matriculaValida(matricula)) {
			if (this.estaEnGarage(matricula) == -1) {
				if (this.garage.size() != 50) {
					this.garage.add(new Vehiculo(marca, matricula, km, precio, descripcion));
					return 0;
				} else {
					return -3;
				}
			} else {
				return -2;
			}
		} else {
			return -1;
		}

	}

	public String listarVehiculos() {
		String listaVehiculos = "";
		for (Vehiculo coche : this.garage) {
			listaVehiculos = listaVehiculos + coche.toString();
		}
		return listaVehiculos;
	}

	private String muestraVehiculo(int posicion) {
		return this.garage.get(posicion).toString();
	}

	public String infoVehiculo(String matricula) {
		if (this.estaEnGarage(matricula) != -1) {
			return this.muestraVehiculo(this.estaEnGarage(matricula));
		} else {
			return "No existe vehiculo con la matricula introducida";
		}
	}

	public int modificarKmVehiculo(String matricula, int km) {
		if (this.estaEnGarage(matricula) != -1) {
			this.setKilometros(this.estaEnGarage(matricula), km);
			return 0;
		} else {
			return -1;
		}
	}

	public int nuevoPropietario(String dni, String nombre, String direccion) {
		if (this.estaEnPropietarios(dni) == -1) {
			if (this.dniValido(dni)) {
				this.listaPropietarios.add(new Propietario(dni, nombre, direccion));
				return 0;
			} else {
				return -1;
			}
		} else {
			return -2;
		}
	}

	public int asociarPropietarioAVehiculo(String dni, String matricula) {
		if (this.estaEnPropietarios(dni) != -1) {
			int posicionPropietarios = this.estaEnPropietarios(dni);
			if (this.estaEnGarage(matricula) != -1) {
				int posicionVehiculo = this.estaEnGarage(matricula);
				this.annadeVehiculoAPropietario(posicionPropietarios, getVehiculo(posicionVehiculo));
				this.setPropietario(posicionVehiculo, getPropietario(posicionPropietarios));
				return 0;
			} else {
				return -2;
			}
		} else {
			return -1;
		}
	}

	public String listarVehiculos(String dni) {
		if (this.estaEnPropietarios(dni) != -1) {
			int posicion = this.estaEnPropietarios(dni);
			return this.getPropietario(posicion).muestraMatriculas();
		} else {
			return "El propietario no existe";
		}
	}

}
