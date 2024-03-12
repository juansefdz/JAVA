public class Estudiante {

    private int id;
    private String nombre;
    private  String correo;

//constructor

    public Estudiante(int id,String nombre,  String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }


    //métodos


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }




    //metodos especificos


    //string


    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", correo='" + correo + '\'' +
                '}';
    }
}
