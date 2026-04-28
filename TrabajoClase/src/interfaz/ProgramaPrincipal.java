package interfaz;

import control.Controladora;

import java.util.Scanner;

public class ProgramaPrincipal {
	
	private static Controladora controladora;
	
	public static void menuBlogs(Scanner sc) {
		System.out.println(" ******MENU BLOGS****** ");
		System.out.println(" 1. Crear publicación ");
		System.out.println(" 2. Ver publicación y comentarios ");
		System.out.println(" 3. Regresar ");
		System.out.println(" ");
		System.out.println("Digite la opción que desea usar: ");
		int opcion = sc.nextInt();
		sc.nextLine();
		switch(opcion) {
		case 1:
			System.out.println("Codigo Blog: ");
			int codigoBlog = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Titulo: ");
			String titulo = sc.nextLine();
			
			System.out.println("Texto: ");
			String texto = sc.nextLine();
			
			System.out.println("nombreCreador: ");
			String creador = sc.nextLine();
			
			
			try {
				controladora.crearPublicacion(codigoBlog, titulo, texto, creador);
				System.out.println("Publicacion agregada");
			} catch(Exception e) {
				System.out.println("Error" + e.getMessage());
			}
			
		case 2:
			System.out.println("Codigo Blog: ");
			codigoBlog = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Codigo Publicacion: ");
			int codigoPublicacion = sc.nextInt();
			sc.nextLine();
			
			try {
			String publicacion = controladora.obtenerPublicacion(codigoBlog, codigoPublicacion);
			System.out.println(publicacion);
			System.out.println("Publicacion encontrada");
			}catch(Exception e) {
				System.out.println("Error " + e.getMessage());
			}
	}
	}
	
	public static void menuPublicacion() {
		
	}

	public static void main(String[] args) {
		
		controladora = new Controladora();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(" ******MENU PRINCIPAL****** ");
			System.out.println(" 1. Crear blog nuevo ");
			System.out.println(" 2. Trabajar con blog ");
			System.out.println(" 3. Borrar Blog ");
			System.out.println(" 4. Salir ");
			System.out.println(" ");
			System.out.println("Digite la opción que desea usar: ");
			int opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				System.out.println("Nombre: ");
				String nombre = sc.nextLine();
				
				System.out.println("Descripcion: ");
				String descripcion = sc.nextLine();
				
				controladora.crearBlog(nombre, descripcion);
				
				break;
			
			case 2:
				menuBlogs(sc);
				break;
			}
			
		}

	}

}
