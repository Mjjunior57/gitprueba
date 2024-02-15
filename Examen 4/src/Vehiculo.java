
public class Vehiculo {

	private String marca;
	private String matricula;
	private int km;
	private double precio;
	private String descripcion;
	private Propietario propietario;

	public Vehiculo(String marca, String matricula, int km, double precio, String descripcion) {
		this.descripcion = descripcion;
		this.km = km;
		this.marca = marca;
		this.matricula = matricula;
		this.precio = precio;
	}

	public Vehiculo() {
		this.descripcion = "desconocida";
		this.km = 0;
		this.marca = "desconocida";
		this.matricula = "0000AAA";
		this.precio = 0;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public boolean equals(String matricula) {
		return this.matricula.equals(matricula);
	}

	public String toString() {
		return String.format("Matricula: %7s , Marca: %15s , km: %7s , precio: %7s \nDescripcion: %90s \n",
				this.matricula, this.marca, this.km, this.precio, this.descripcion);
	}

	public boolean matriculaValida(String matricula) {
		boolean valido = true;
		if (matricula.length() == 7) {
			char[] matriculaPrincipal = this.matriculaAArray(matricula);
			for (int i = 0; i < 6; i++) {
				if (i < 4) {
					if (matriculaPrincipal[i] == '0' || matriculaPrincipal[i] == '1' || matriculaPrincipal[i] == '2'
							|| matriculaPrincipal[i] == '3' || matriculaPrincipal[i] == '4'
							|| matriculaPrincipal[i] == '5' || matriculaPrincipal[i] == '6'
							|| matriculaPrincipal[i] == '7' || matriculaPrincipal[i] == '8'
							|| matriculaPrincipal[i] == '9') {
					} else {
						valido = false;
					}
				} else {
					if (matriculaPrincipal[i] >= 66 && matriculaPrincipal[i] <= 68
							|| matriculaPrincipal[i] >= 70 && matriculaPrincipal[i] <= 72
							|| matriculaPrincipal[i] >= 74 && matriculaPrincipal[i] <= 78
							|| matriculaPrincipal[i] >= 80 && matriculaPrincipal[i] <= 84
							|| matriculaPrincipal[i] >= 86 && matriculaPrincipal[i] <= 90) {

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

	private char[] matriculaAArray(String matricula) {
		char[] arrayMatricula = new char[7];
		for (int i = 0; i < arrayMatricula.length; i++) {
			arrayMatricula[i] = matricula.charAt(i);
		}
		return arrayMatricula;
	}

	public String muestraMatricula() {
		return String.format("%7s \n", this.matricula);
	}
}
