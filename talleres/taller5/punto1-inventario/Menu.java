import javax.swing.*;

public class Menu {

    public void menu() {

        Inventario objInventario = new Inventario();
        int id=1;
        int option=0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "GESTOR DE PRODUCTOS \n Digite: \n 1. MOSTRAR PRODUCTOS \n 2. AGREGAR PRODUCTOS \n 3. ELIMINAR PRODUCTOS \n 4. BUSCAR PRODUCTO ESPECIFICO \n 5. SALIR. \n \n DIGITE UNA OPCIÓN: "));
            try {
                switch (option) {
                    case 1:
                        objInventario.listarProductos();

                        break;
                    case 2:

                        String nombreProducto = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                        double precioProducto= Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el precio de "+ nombreProducto));

                        objInventario.agregarProducto(id,nombreProducto,precioProducto);
                        id++;
                        break;
                    case 3:
                        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del producto a eliminar: "));
                        boolean productoEliminado = objInventario.eliminarProducto(idEliminar);
                        if (productoEliminado) {
                            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "El producto con ID " + idEliminar + " no existe");
                        }
                        break;
                    case 4:
                        String nombreBuscar = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto a buscar: ");
                        Producto encontrado = objInventario.buscarPorNombre(nombreBuscar);
                        if (encontrado != null) {
                            JOptionPane.showMessageDialog(null, "Producto encontrado:\nID: " + encontrado.getId() + "\nNombre: " + encontrado.getNombre() + "\nPrecio: " + encontrado.getPrecio());
                        } else {
                            JOptionPane.showMessageDialog(null, "Producto no encontrado");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el gestor de productos");
                        break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ingrese una opción valida ");
            }

        } while (option != 5);


    }
}
