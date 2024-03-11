import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

public class Inventario {

    private java.util.ArrayList<Producto> listaProductos;


    public Inventario() {
        this.listaProductos = new java.util.ArrayList<>();
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
    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            showMessageDialog(null, "La lista de productos está vacía");
        } else {
            String listaProducto = "";
            for (Producto producto : listaProductos) {
                listaProducto += "id: " + producto.getId() + " Nombre: " + producto.getNombre() + " Precio: " + producto.getPrecio() + "\n";
            }

            JOptionPane.showMessageDialog(null, "LISTA DE PRODUCTOS\n"+"\n"+listaProducto);
        }
    }
    /*public void listarProductos() {
        if (listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista de productos está vacía");
        } else {
            StringBuilder formattedList = new StringBuilder("LISTA DE PRODUCTOS\n\n");
            String header = String.format(" %-4s  %-20s  %-10s %n", "ID", "NOMBRE", "PRECIO");
            formattedList.append(header);
            for (Producto producto : listaProductos) {
                String productoRow = String.format(" %-4d  %-20s  %-10.2f %n", producto.getId(), producto.getNombre(), producto.getPrecio());
                formattedList.append(productoRow);
            }
            JOptionPane.showMessageDialog(null, formattedList.toString());
        }
    }*/


    public void agregarProducto(int id, String nombreProducto, double precioProducto) {
        Producto producto = new Producto(id, nombreProducto, precioProducto);
        agregarProducto(producto);
    }
}