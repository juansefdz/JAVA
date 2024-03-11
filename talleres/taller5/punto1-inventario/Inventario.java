import javax.swing.*;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    //métodos especificos

    public void agregarProducto(Producto producto) {
        this.listaProductos.add(producto);

    }
    public boolean eliminarProducto(int id){
        return listaProductos.removeIf(producto -> producto.getId()==id);

        //el return un boolean.
    }
    public Producto buscarPorNombre(String nombreBuscar){
        for (Producto objProducto:this.listaProductos){
            if (objProducto.getNombre().equalsIgnoreCase(nombreBuscar)){
                return objProducto;
            }
        }
        return null;
    }

    public void listarProductos (){
        if (Producto.isEmpty()){
            JOptionPane.showMessageDialog(("La lista de productos esta vacia"));
        }else {
            String listaProducto ="";
            Producto producto;
            listaProducto+= "id: "+producto.getId()+"Nombre: "+producto.getNombre()+"Precio: "+producto.getPrecio();

        }

        System.out.println(("entro"));

    }

    public void agregarProducto(int id, String nombreProducto, double precioProducto) {
    }
}
