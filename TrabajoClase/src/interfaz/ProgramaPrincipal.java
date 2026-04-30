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
				System.out.println("Error " + e.getMessage());
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
			System.out.println("Listado de publicaciones del blog actual: ");
			try {
				System.out.println(controladora.obtenerPublicaciones(codigoBlog));
			}catch(Exception e) {
				System.out.println("Error " + e.getMessage());
				return;
			}
			
			System.out.println("Seleccione un codigo de publicacion para trabajar: ");
			int codigoPublicacion = sc.nextInt();
			sc.nextLine();
			try {
				System.out.println(controladora.obtenerPublicacion(codigoBlog, codigoPublicacion));
			}catch(Exception e) {
				System.out.println("Error " + e.getMessage());
				
			}
			
			System.out.println("----------------------------------------------");
			System.out.println("Opciones: ");
			System.out.println(" 1. Crear comentario");
			System.out.println(" 2. Borrar comentario ");
			System.out.println(" 3. Regresar ");
			System.out.println(" ");
			
			int opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1:
				System.out.println("Email: ");
				String email = sc.nextLine();
				
				System.out.println("IP: ");
				String ip = sc.nextLine();
				
				System.out.println("Texto: ");
				String texto = sc.nextLine();
				try {
				controladora.agregarComentario(codigoBlog, codigoPublicacion, email, ip, texto);
				}catch(Exception e) {
					System.out.println("Error " + e.getMessage());
				}
				break;
				
			case 2:
				System.out.println("Posicion: ");
				int posicion = sc.nextInt();
				sc.nextLine();
				
				try {
				controladora.borrarComentario(codigoBlog, codigoPublicacion, posicion);
				}catch(Exception e) {
					System.out.println("Error " + e.getMessage());
				}
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
	
	public static void main(String[] args) {
		controladora = new Controladora();
		Scanner sc = new Scanner(System.in);
		
		controladora.crearBlog("Elena Bellatierra", "Sobre calidad de productos de aseo personal");
		controladora.crearBlog("Jose Quesada", " Estadisticas de los partidos del mundial 2026");
		
		try {
		controladora.crearPublicacion(1, "Cual es el mejor shampoo", "No se, solo queria publicar", "Elena Bellatierra");
		controladora.crearPublicacion(1, "Porque debemos usar bloquedor solar", "Pa no quemarnos del sol","Elena Bellatierra");
		
		controladora.crearPublicacion(2, "Analisis de la fase de grupos", "Esta demasiado complicado analizar todo", "Jose Quesada");
		controladora.crearPublicacion(2, "Maximos goleadores hasta la fecha", "Podemos deducir que el maximo goleador es el Mambo Nuñez","Jose Quesada");
		}catch(Exception e) {
			System.out.println("Error :" + e.getMessage());
		}
		
		try {
		controladora.agregarComentario(1, 1, "alvarito98@jobmail.com", "1.7263662.3827", "Buena publicacion, ojala sea la ultima");
		controladora.agregarComentario(1, 1, "juanvazquesjeje@gmail.com", "324.332", " Gracias por la informacion(soy calvo)");
		controladora.agregarComentario(1, 2, "palmajuegos@gmail.com", "4.76323.8372", "Mi protector solar suele ser no salir");
		controladora.agregarComentario(1, 2, "crisnonimo777@hotmail.com", "8265.38926.282", " Hay algun bloquedor solar casero?");
		
		controladora.agregarComentario(2, 3, "jimenesjuli927@yahoo.com", "0.7292684532.3827", "Espero que los angeles Lakers clasifiquen");
		controladora.agregarComentario(2, 3, "gspmeu90d", "73.2953.927372", "Me impresiona que Costa Rica no llegara al mundial!");
		controladora.agregarComentario(2, 4, "romerocubero11@gmail.com", "99.99.9992", "Mbappe se encargara de golear a todos los equipos");
		controladora.agregarComentario(2, 4, "crisnonimo777@estudiantec.cr", "8263.34546.73564", "Espero este mundial el maximo goleador sea Navas");
		}catch(Exception e) {
			System.out.println("Error :" + e.getMessage());
		}
		
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
				System.out.println("Blog creado exitosament.");
				
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
					System.out.println("Error " + e.getMessage());
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
