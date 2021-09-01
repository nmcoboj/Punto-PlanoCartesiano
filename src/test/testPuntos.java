package test;

import dominio.Punto;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class testPuntos {

    static Scanner datos = new Scanner(System.in);

    public static void main(String[] args) {

        int cantidadMovimientos;
        System.out.println("Ingrese la cantidad de movimientos que quiera realizar:");
        cantidadMovimientos = datos.nextInt();
        Punto[] puntos = new Punto[cantidadMovimientos+1];
        mover(cantidadMovimientos, puntos);
        distanciaTotalRecorrida(cantidadMovimientos, puntos);
    }

    public static void mover(int n, Punto p[]) {
        String direccion = "";
        int x = 0;
        int y = 0;
        int i = 0;
        int aux;
        int valor = 0;
        p[0] = new Punto(x, y);
        for (i = 1; i < n+1; i++) {
            System.out.println("Digite el valor del movimiento Nro." + i + ":");
            valor = datos.nextInt();
            direccion = direccion();
            if ("Izquierda".equals(direccion)) {
                x = p[i-1].getX();
                x = x-valor;
            }
            else if ("Derecha".equals(direccion)) {
                x = p[i-1].getX();
                x= x+valor;
            }

            else if ("Arriba".equals(direccion)) {
                y = p[i-1].getY() ;
                y = y+valor;
            }
            else if ("Abajo".equals(direccion)) {
                y = p[i-1].getY();
                y = y-valor;
            }
            
            p[i] = new Punto(x, y);
            System.out.println("La nueva direccion es: "+ direccion);
            System.out.println("Las nuevas coordenadas son: " + "("+ x +","+ y +")");        
        }
    }

    public static String direccion() {
        String[] direcciones = {"Izquierda", "Derecha", "Arriba", "Abajo"};
        int numAleatorio = numeroAleatorio(0, direcciones.length - 1);
        return direcciones[numAleatorio];
    }

    public static int numeroAleatorio(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public static void distanciaTotalRecorrida(int n, Punto p[]){
        int d_x=0;
        int d_y=0;
        double d_total=0;
        double d_parcial=0;
        for (int i =0; i < n; i++) {
            d_x = p[i+1].getX()-p[i].getX();
            double d_xf = Math.pow(d_x, 2);
            d_y = p[i+1].getY()-p[i].getY();
            double d_yf = Math.pow(d_y, 2);
            d_parcial = Math.sqrt(d_xf + d_yf);
            d_total = d_total + Math.sqrt(d_xf + d_yf);
            int j= i+1;
            System.out.println("La distancia del punto "+ i + " al punto " + j +" es: " + d_parcial+ " unidades."); 
       }
       System.out.println("La distancia recorrida total es: " + d_total + " unidades."); 
    }
}
