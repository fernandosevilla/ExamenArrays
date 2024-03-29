/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/

package com.mycompany.examenarrays;

/**
 * @author Fer
*/

public class ExamenArrays {

    public static void main(String[] args) {
        int[] tabla = {3, 6, 8, 13, 19, 22, 23, 25, 28, 32, 49};
        
        // EJERCICIO 1
        
        System.out.println("Contenido de la tabla antes de empezar a insertar valores:");
        mostrarArray(tabla);
        
        System.out.println("Insertamos el valor 10");
        tabla = insertarDatos(tabla, 10);
        mostrarArray(tabla);
        
        System.out.println("Insertamos el valor 22, no se debe de añadir nada porque ya existe este numero");
        tabla = insertarDatos(tabla, 22);
        mostrarArray(tabla);
        
        System.out.println("Insertamos el valor 50");
        tabla = insertarDatos(tabla, 50);
        mostrarArray(tabla);
        
        System.out.println("Insertamos el valor 1");
        tabla = insertarDatos(tabla, 1);
        mostrarArray(tabla);
        
        System.out.println("Insertamos el valor 4");
        tabla = insertarDatos(tabla, 4);
        mostrarArray(tabla);
        
        System.out.println("Insertamos el valor 1000");
        tabla = insertarDatos(tabla, 1000);
        mostrarArray(tabla);
        System.out.println("Insertamos el valor -20");
        tabla = insertarDatos(tabla, -20);
        mostrarArray(tabla);

        // EJERCICIO 2
        System.out.println("\n\nPrueba de busqueda de un array de enteros ordenado");
        mostrarArray(tabla);
        System.out.println("Buscamos el valor 25 y esta en la posicion " + buscar(tabla, 25));
        System.out.println("Buscamos el valor 5 y esta en la posicion " + buscar(tabla, 5));
        System.out.println("Buscamos el valor 2 y esta en la posicion " + buscar(tabla, 2));
        System.out.println("Buscamos el valor 55 y esta en la posicion " + buscar(tabla, 55));
        System.out.println("Buscamos el valor 24 y esta en la posicion " + buscar(tabla, 24));
        System.out.println("Buscamos el valor 3 y esta en la posicion " + buscar(tabla, 3));
        System.out.println("Buscamos el valor 8 y esta en la posicion " + buscar(tabla, 8));
        System.out.println("Buscamos el valor 8 y esta en la posicion " + buscar(tabla, 8));
        System.out.println("Buscamos el valor 48 y esta en la posicion " + buscar(tabla, 48));
        System.out.println("Buscamos el valor 49 y esta en la posicion " + buscar(tabla, 49));
    }
    
    // Metodo para mostrar todo el contenido del array
    static void mostrarArray(int[] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            System.out.print(tabla[i] + "\t");
        }
        
        System.out.println();
    }
    
    // EJERCICIO 1
    static int[] insertarDatos(int[] tabla, int valor) {       
        if (existe(tabla, valor)) { // Si existe el valor que se le da devuelve al tabla antes de insertar nada
            return tabla;
        } else {
            int[] tablaNueva = new int[tabla.length + 1]; // se hace un nuevo array incrementando 1
            int posicion = 0;
            
            while (posicion < tabla.length && tabla[posicion] < valor) { // Mientras que la posicion sea menor que la longitud de la tabla y la posicion del array mayor que el valor
                tablaNueva[posicion] = tabla[posicion]; // Se copia la tabla
                posicion++; // Se incrementa 1 a la variable posicion
            }

            tablaNueva[posicion] = valor;

            while (posicion < tabla.length) { // Mientras que la posicion sea menor que la longitud de la tabla
                tablaNueva[posicion + 1] = tabla[posicion];  // A la posicion se le suma 1 e iguala al parametro tabla
                posicion++; // Se incrementa 1 a la variable posicion
            }

            return tablaNueva; // devuelve la tabla con el dato insertado
        }
    }
    
    // Este metodo verifica si el valor que se le introduce ya existe en la tabla
    static boolean existe(int tabla[], int valor) {
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] == valor) {
                return true;
            }
        }

        return false;
    }
    
    // EJERCICIO 2
    // Este metodo busca el valor que se le introduce y te devuelve la posicion
    static int buscar(int[] tabla, int valor) {
        int inicio = 0;
        int fin = tabla.length - 1;
        
        while (inicio <= fin) {
            int media = (inicio + fin) / 2;

            if (tabla[media] == valor) { // Si la posicion de la tabla es igual al valor que estamos buscando 
                return media; // devuelve la media que seria la posicion del valor que buscamos
            } else if (tabla[media] < valor) { // Si la posicion es menor al valor buscado
                inicio = media + 1;  // continuamos buscando por la derecha
            } else {
                fin = media - 1; // sino seguimos buscando por la izquierda
            }
        }

        return -1; // no se ha encontrado el valor
    }
}
