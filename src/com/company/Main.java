package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Pedimos el número y lo asignamos a la variable
        System.out.println("Introduzca un número entre 0 y 9.999:\n");
        int numero;
        Scanner sc=new Scanner(System.in);
        numero=sc.nextInt();
        //Comprobamos que el número introducido esta en el rango que hemos definido, y si no lo está, volvemos a pedir un número por consola
        while(numero<0||numero>9999) {
            System.out.println("Introduzca un número entre 0 y 9.999:\n");
            numero = sc.nextInt();
        }
        //Mostramos el menú y pedimos el número de la opción a realizar, asignandola a su variable.
        System.out.println("Introduzca el número correspondiente a la acción que desea realizar con el número introducido:\n 1.- Decir cuantas cifras tiene.\n 2.- Mostrarlo con las cifras al revés.\n 3.- Decir si es capicúa.\n");
        int numeroMenu=sc.nextInt();
        switch(numeroMenu){
            case 1:
                boolean condicion=false;
                //Variable para comparar con el numero introducido
                double compara=10;
                //Variable contador, para tener el numero de cifras segun itere el bucle while.
                int contador=1;
                //Con este bucle while comparamos nuestro numero con contador, y en caso de que el numero sea mayor, incrementamos contador y multiplicamos compara por 10
                while (!condicion){
                    if(numero>=compara){
                        compara=compara*10;
                        contador++;
                    }else{
                        System.out.printf("El numero tiene %d cifras.", contador);
                        condicion=true;
                    }
                }
                break;
            case 2:
                //A cada cifra del número introducido, le daremos una posición, dividiendo el numero entre 10 y quedandonos con el resto, y repitiendo por cada cifra.
                int pos4, pos3, pos2, pos1;
                pos4=numero%10;
                numero=numero/10;
                pos3=numero%10;
                numero=numero/10;
                pos2=numero%10;
                numero=numero/10;
                pos1=numero;

                //Imprimimos las cifras en orden opuesto, utilizando el if para evitar que se añadan ceros si el número tiene menos de cuatro cifras.
                if(pos3==0){
                    System.out.printf("%d", pos4);
                }else{
                    if(pos2==0){
                        System.out.printf("%d%d", pos4,pos3);
                    }else{
                        if(pos1==0){
                            System.out.printf("%d%d%d", pos4, pos3, pos2);
                        }else{
                            System.out.printf("%d%d%d%d", pos4,pos3,pos2,pos1);
                        }
                    }
                }
                break;
            case 3:
                //Separamos el número en sus componentes.
                int unidades=numero%10;
                numero=numero/10;
                int decenas=numero%10;
                numero=numero/10;
                int centenas=numero%10;
                numero=numero/10;
                int millares=numero;
                boolean capicua=false;


                //Comprobamos cada componente de mayor grado por si es cero, y en función de eso, comprobamos si las cifras del numero son iguales desde los extremos.
                if (millares!=0){
                    if((unidades==millares)&&(decenas==centenas)){
                        capicua=true;
                    }
                }else{
                    if(centenas!=0){
                        if(unidades==centenas){
                            capicua=true;
                        }
                    }else{
                        if(decenas!=0){
                            if(unidades==decenas){
                                capicua=true;
                            }
                        }else{
                            //He añadido esto porque no tenia muy claro si un numero de una sola cifra se considera capicua o no.
                            System.out.println("El número es de una sola cifra.");
                        }
                    }
                }
                //Comprobamos la variable capicua para mostrar el resultado adecuado.
                if(capicua){
                    System.out.println("El número introducido es capicua.");
                }else{
                    System.out.println("El número introducido no es capicua.");
                }
                break;
            default:
                System.out.println("El número de opción seleccionada no existe.\n");
                break;
        }
    }
}
