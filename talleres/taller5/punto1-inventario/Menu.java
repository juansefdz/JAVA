import javax.swing.*;

public class Menu {

    public void menu() {

        Inventario objInventario = new Inventario();

        int option=0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "GESTOR DE PRODUCTOS \n Digite: \n 1. MOSTRAR PRODUCTOS \n 2. AGREGAR PRODUCTOS \n 3. ELIMINAR PRODUCTOS \n 4. AGREGAR PRODUCTO ESPECIFICO \n 5. SALIR. \n \n DIGITE UNA OPCIÓN: "));
            try {
                switch (option) {
                    case 1:
                        objInventario.listarProductos();

                        break;
                    case 2:

                        String nombreProducto = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                        double precioProducto= Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el precio de "+ nombreProducto));
                        int id=1;
                        objInventario.agregarProducto(id,nombreProducto,precioProducto);
                        id++;
                        break;
                    case 3:
                        JOptionPane.showInputDialog(null, "eliminar un producto");
                        //objInventario.eliminarProducto();
                        break;
                    case 4:
                        JOptionPane.showInputDialog(null, "buscar un producto");
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

