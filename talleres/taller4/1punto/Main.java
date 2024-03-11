public class Main {
    public static void main(String[] args) {


        Libro objLibro = new Libro("100 años de soledad","Gabriel Garcia M","01-mayo-1967",false);

        System.out.println(objLibro.getTitulo());

        objLibro.setTitulo("el rastro de tu sangre en la nieve");

        System.out.println(objLibro.getTitulo());

        System.out.println(objLibro.toString());


    }

}
