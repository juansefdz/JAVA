
/*Ejercicio 1: Sistema de Control de Inventarios
Objetivo: Crear un sistema para manejar el inventario de un almacén, aplicando
encapsulamiento y herencia, y utilizando ArrayList para almacenar los productos.

Principios de POO aplicados: Encapsulamiento, Herencia.

Requisitos:

Clase Producto: Base para todos los productos, con propiedades como id, nombre, y
precio. Implementa getters y setters para aplicar el encapsulamiento.
Clase ProductoEspecifico: Hereda de Producto y añade propiedades específicas, como
categoria o marca.
Clase Inventario: Utiliza un ArrayList de objetos Producto para gestionar el inventario.
Implementa métodos para añadir, eliminar, y listar productos, además de buscar productos
por nombre o categoría.*/
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();

    }


}