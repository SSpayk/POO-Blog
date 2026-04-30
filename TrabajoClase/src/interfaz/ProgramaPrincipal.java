package interfaz;

import control.Controladora;

import java.util.Scanner;

public class ProgramaPrincipal {
	
	private static Controladora controladora;
	
	public static void menuBlogs(Scanner sc) {
		while(true) {
		System.out.println(" ******MENU BLOGS****** ");
		System.out.println("Listado de blogs: ");
		System.out.println(controladora.obtenerBlogs());
		System.out.println("Seleccione un codigo de blog para trabajar: ");
		int codigoBlog = sc.nextInt();
		sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("Opciones: ");
		System.out.println(" 1. Crear publicación ");
		System.out.println(" 2. Ver publicación y comentarios ");
		System.out.println(" 3. Regresar ");
		System.out.println(" ");
		System.out.println("Digite la opción que desea usar: ");
		int opcion = sc.nextInt();
		sc.nextLine();
		
		switch(opcion) {
		case 1:
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
			break;
			
		case 2:
			menuPublicaciones(sc, codigoBlog);
			break;
		
		case 3:
			System.out.println(" ");
			System.out.println(" Regresando... ");
			return;
			
		default:
		    System.out.println("Opción Invalida.");
		    System.out.println(" ");
		    break;
	}
	}
	}
	
	
	public static void menuPublicaciones(Scanner sc, int codigoBlog) {
		while(true) {
			System.out.println(" ******MENU PUBLICACIONES****** ");
			try {
				System.out.println(controladora.obtenerPublicaciones(codigoBlog));
				System.out.println("Blog encontrado exitosamente");
			}catch(Exception e) {
				System.out.println("Error" + e.getMessage());
			}
			
			System.out.println("Listado de publicaciones del blog actual: ");
			System.out.println("Seleccione un codigo de publicacion para trabajar: ");
			int codigoPublicacion = sc.nextInt();
			sc.nextLine();
			
			System.out.println("----------------------------------------------");
			System.out.println("Opciones: ");
			System.out.println(" 1. Crear comentario");
			System.out.println(" 2. Borrar comentario ");
			System.out.println(" 3. Regresar ");
			System.out.println(" ");
			
			
			
			
		}
		
		
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
				
			case 3:
				System.out.println("codigoBlog: ");
				int codigoBlog = sc.nextInt();
				sc.nextLine();
				try {
				controladora.borrarBlog(codigoBlog);
				System.out.println("Blog eliminado correctamente");
				}catch(Exception e) {
					System.out.println("Error" + e.getMessage());
				}
				break;
			
			case 4:
				System.out.println(" ");
				System.out.println(" Saliendo... ");
				sc.close();
				return;
				
			default:
			    System.out.println("Opción Invalida.");
			    System.out.println(" ");
			    break;
			}
			
		}

	}

}
