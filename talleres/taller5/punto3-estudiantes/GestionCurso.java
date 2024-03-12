import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {

    private ArrayList<Curso>ListaCursos;

    public GestionCurso(){
        this.ListaCursos=new ArrayList<>();
    }

    public ArrayList<Curso> getListaCursos() {
        return ListaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        ListaCursos = listaCursos;
    }


    public void guardarCursos(Scanner objScanner){
        System.out.println("Agregar curso:");

        System.out.println("Ingresa el nombre del curso:");
        String nombre=objScanner.next();
        System.out.println("Ingresa el código del curso");
        String codigo=objScanner.next();
        if(this.buscarPorCodigo(codigo)!=null){
            System.out.println("el código ingresado ya se encuentra usado!");
        }else {
            Curso obCurso=new Curso(codigo,nombre);
            this.ListaCursos.add(obCurso);
        }
    }

    public Curso buscarPorCodigo(String codigoBuscar){
        for (Curso cursoTemporal:this.ListaCursos){
            if(cursoTemporal.getCodigo().equalsIgnoreCase(codigoBuscar)){
                return cursoTemporal;
            }
        }
        return null;
    }

    public void listarCurso(){
        if (this.ListaCursos.isEmpty()){
            System.out.println("no hay cursos registrados");
        }else{
            for (Curso temp : this.ListaCursos) {
                System.out.println(temp.toString());
            }

        }
    }

}
