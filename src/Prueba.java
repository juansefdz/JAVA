import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Prueba {

    public void prueba() {

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna

// Creamos los componentes de entrada
        JTextField tituloLibro = new JTextField();
        JTextField nombreAutor = new JTextField();
        JTextField fechaPublicacion = new JTextField();
        JTextField precio = new JTextField();
        JTextField IdAutor = new JTextField();

// Añadimos los componentes al panel
        panel.add(new JLabel("Titulo del libro:"));
        panel.add(tituloLibro);

        panel.add(new JLabel("Nombre del autor:"));
        panel.add(nombreAutor);

        panel.add(new JLabel("Fecha de publicacion:"));
        panel.add(fechaPublicacion);

        panel.add(new JLabel("Precio:"));
        panel.add(precio);

        panel.add(new JLabel("ID del autor:"));
        panel.add(IdAutor);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese los datos del libro", JOptionPane.OK_CANCEL_OPTION);


        if (result == JOptionPane.OK_OPTION) {
            String titulo = tituloLibro.getText();
            String autor = nombreAutor.getText();
            String fecha = fechaPublicacion.getText();
            String valor = precio.getText();
            String id = IdAutor.getText();


            System.out.println("Título del libro: " + titulo);
            System.out.println("Nombre del autor: " + autor);
            System.out.println("año publicacion" + fecha);
            System.out.println("precio" + valor);
            System.out.println("ID Author " + id);

        }


    }

}

