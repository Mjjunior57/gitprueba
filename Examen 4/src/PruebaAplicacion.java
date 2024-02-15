import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaAplicacion {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean salir = false;

		Concesionario sartopina = new Concesionario();

		try {
			while (!salir) {

				System.out.println("\n*** Opciones ***\n");
				System.out.println("1. NUEVO vehiculo ");
				System.out.println("2. LISTAR vehiculos ");
				System.out.println("3. BUSCAR vehiculo ");
				System.out.println("4. MODIFICAR KM vehiculo ");
				System.out.println("5. NUEVO PROPIETARIO ");
				System.out.println("6. ASOCIAR vehiculo A propietario ");
				System.out.println("7. VEHICULOS de un PROPIETARIO ");
				System.out.println("8. Salir ");

				System.out.println("\nSeleciona un opcion: ");
				int opcion = sc.nextInt();
				sc.nextLine();

				if (opcion == 1) {
					System.out.println("Introduce la marca: ");
					String marca = sc.nextLine();
					System.out.println("Introduce la matricula: ");
					String matricula = sc.nextLine();
					System.out.println("Indica los KM del automovil");
					int km = sc.nextInt();
					System.out.println("Indica el PRECIO: ");
					double precio = sc.nextDouble();
					System.out.println("Descripcion del estado del vehiculo");
					String descripcion = sc.nextLine();

					int codigo = sartopina.nuevoVehiculo(marca, matricula, km, precio, descripcion); ///////////////////////////////////////

					if (codigo == 0) {
						System.err.println("VEHICULO ANNIADIDO al concesionario");
					} else if (codigo == -1) {
						System.err.println("FORMATO DE MATRICULA INCORRECTO");
					} else if (codigo == -2) {
						System.err.println("YA EXISTE UN VEHICULO CON ESA MATRICULA");
					} else if (codigo == -3) {
						System.err.println("SE HA ALCANZADO LA CAPACIDAD MAXIMA DE LA CAMPA DEL CONCESIONARIO");
					}
					sc.nextLine();
				} else if (opcion == 2) {
					System.out.println(sartopina.listarVehiculos()); ////////////////////////////////

				} else if (opcion == 3) {
					System.out.println("Introduce la MATRICULA del VEHICULO A BUSCAR: ");
					String matricula = sc.nextLine();

					System.out.print(sartopina.infoVehiculo(matricula)); ////////////////////////////

				} else if (opcion == 4) {
					System.out.println("Introduce la matricula: ");
					String matricula = sc.nextLine();
					System.out.println("Indica los KM del automovil");
					int km = sc.nextInt();

					int codigo = sartopina.modificarKmVehiculo(matricula, km); ////////////////////////////

					if (codigo == -1) {
						System.err.println("NO EXISTE NINGUN VEHICULO CON ESA MATRICULA");
					} else {
						System.err.println("KM DEL VEHICULO MODIFICADOS");
					}

				} else if (opcion == 5) {

					System.out.println("DNI del propietario: ");
					String dni = sc.nextLine();
					System.out.println("Su nombre es... ");
					String nombre = sc.nextLine();
					System.out.println("Y su direccion... ");
					String direccion = sc.nextLine();

					int codigo = sartopina.nuevoPropietario(dni, nombre, direccion); ///////////////////////////////////////

					if (codigo == 0) {
						System.err.println("PROPIETARIO ANNIADIDO al concesionario");
					} else if (codigo == -1) {
						System.err.println("FORMATO DE DNI INCORRECTO");
					} else if (codigo == -2) {
						System.err.println("YA EXISTE UN PROPIETARIO CON ESE DNI");
					}

				} else if (opcion == 6) {

					System.out.println("Matricula del vehiculo: ");
					String matricula = sc.nextLine();
					System.out.println("DNI del propietario: ");
					String dni = sc.nextLine();

					int codigo = sartopina.asociarPropietarioAVehiculo(dni, matricula);

					if (codigo == 0) {
						System.err.println("ASOCIACION REALIZADA CON EXITO");
					} else if (codigo == -1) {
						System.err.println("NO EXISTE UN PROPIETARIO CON ESE DNI");
					} else if (codigo == -2) {
						System.err.println("NO EXISTE UN VEHICULO CON ESA MATRICULA");
					}

				} else if (opcion == 7) {

					System.out.println("DNI del propietario: ");
					String dni = sc.nextLine();

					System.err.println(sartopina.listarVehiculos(dni));

				} else if (opcion == 8) {
					salir = true;
				}

			}
		} catch (InputMismatchException e) {
			System.err.println("\nDebes escribir un n�mero" + e);
		}

	}

}
