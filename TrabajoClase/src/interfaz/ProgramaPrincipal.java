package interfaz;

import control.Controladora;

public class ProgramaPrincipal {
	
	private static Controladora controladora;
	
	public static void MenuBlogs() {
		
	}
	
	public static void MenuPublicacion() {
		
	}

	public static void main(String[] args) {
		controladora = new Controladora();
		
		while(true) {
			System.out.println(" ******MENU PRINCIPAL****** ");
			System.out.println(" 1. Crear blog nuevo ");
			System.out.println(" 2. Trabajar con blog ");
			System.out.println(" 3. Borrar Blog ");
			System.out.println(" 4. Salir ");
			System.out.println(" ");
		}

	}

}
