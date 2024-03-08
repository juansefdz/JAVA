
/*Clase básica de un Libro: Crea una clase Libro que tenga los atributos
título, autor, año de publicación y si está o no prestado. Incluye métodos
para modificar y obtener el estado de los atributos. Por último, implementa
un método para prestar y devolver el libro, cambiando el estado de prestado
acorde.*/

public class Libro {

    //atributos
    private String titulo;
    private String autor;
    private String publicacion;
    private boolean prestado;

    //constructor


    public Libro(String titulo, String autor, String publicacion, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.prestado = prestado;
    }


//métodos


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void cambiarEstado(){
        this.prestado=!this.prestado;
        System.out.println("estado del libro actualizado correctamente");
    }

    @Override //es un decorador
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", publicacion='" + publicacion + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}

