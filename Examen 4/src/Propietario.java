import java.util.ArrayList;

public class Propietario {

	private String dni;
	private String nombre;
	private String direccion;
	private ArrayList<Vehiculo> listaVehiculo;

	public Propietario(String dni, String nombre, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaVehiculo = new ArrayList<Vehiculo>();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Vehiculo> getListaVehiculo() {
		return listaVehiculo;
	}

	public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
		this.listaVehiculo = listaVehiculo;
	}

	public boolean equals(String dni) {
		return this.dni.equals(dni);
	}

	public String toString() {
		return String.format("DNI: %8s , %40s , %40s ", this.dni, this.nombre, this.direccion);
	}

	public void annadeVehiculo(Vehiculo vehiculo) {
		this.listaVehiculo.add(vehiculo);
	}

	public boolean dniValido(String dni) {
		boolean valido = true;
		if (dni.length() == 9) {
			char[] dniPrincipal = this.dniAArray(dni);
			for (int i = 0; i < 9; i++) {
				if (i < 8) {
					if (dniPrincipal[i] == '0' || dniPrincipal[i] == '1' || dniPrincipal[i] == '2'
							|| dniPrincipal[i] == '3' || dniPrincipal[i] == '4' || dniPrincipal[i] == '5'
							|| dniPrincipal[i] == '6' || dniPrincipal[i] == '7' || dniPrincipal[i] == '8'
							|| dniPrincipal[i] == '9') {
					} else {
						valido = false;
					}
				} else {
					if (dniPrincipal[i] >= 65 && dniPrincipal[i] <= 90
							|| dniPrincipal[i] >= 97 && dniPrincipal[i] <= 122) {

					} else {
						valido = false;
					}
				}
			}
		} else {
			valido = false;
		}
		return valido;
	}

	private char[] dniAArray(String dni) {
		char[] arrayDni = new char[9];
		for (int i = 0; i < arrayDni.length; i++) {
			arrayDni[i] = dni.charAt(i);
		}
		return arrayDni;
	}

	public String muestraMatriculas() {
		String listaVehiculo = "";
		int contador = 1;
		for (Vehiculo vehiculo : this.listaVehiculo) {
			listaVehiculo = listaVehiculo + "Matricula vehiculo " + contador + " : " + vehiculo.muestraMatricula();
			contador++;
		}
		return listaVehiculo;
	}

}
