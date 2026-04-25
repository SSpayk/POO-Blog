package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

 public class Publicacion {
    private static int consecutivo = 1;
    private int codigo;
    private String titulo;
    private String texto;
    private String nombreCreador;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;

    public Publicacion(String titulo, String texto, String nombreCreador) {
        this.codigo = consecutivo;
        consecutivo++;
        this.titulo = titulo;
        this.texto = texto;
        this.nombreCreador = nombreCreador;
        this.fechaPublicacion = LocalDateTime.now();
        this.comentarios = new ArrayList<Comentario>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void agregarComentario(String email, String ip, String texto) {
        Comentario c = new Comentario(email, ip, texto);
        comentarios.add(c);
    }

    public void borrarComentario(int posicion) throws Exception {
        if (posicion < 0 || posicion >= comentarios.size())
            throw new Exception("Posición de comentario inválida.");
        comentarios.remove(posicion);
    }

    public String toString() {
        String resultado = "Publicación #" + codigo + "\n" +
                           "Título: " + titulo + "\n" +
                           "Autor: " + nombreCreador + "\n" +
                           "Fecha: " + fechaPublicacion + "\n" +
                           "Texto: " + texto + "\n" +
                           "Comentarios (" + comentarios.size() + "):\n";
        for (int i = 0; i < comentarios.size(); i++) {
            resultado = resultado + "  " + i + ". " + comentarios.get(i) + "\n";
        }
        return resultado;
    }
}
