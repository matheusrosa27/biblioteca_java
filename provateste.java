
/**
 * Escreva uma descrição da classe provateste aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import java.util.*;

public class provateste
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        System.out.println("A:");
        a = sc.nextInt();
        System.out.println("B:");
        b = sc.nextInt();
        System.out.println("C:");
        c = sc.nextInt();
        
        if ((a+b > c) && (a+c > b) && (b+c > a)){
            if ((a==b) && (a==c)){
                System.out.println("EQUILATERO");
            } else {
                if ((a==b) || (b==c) || a==c){
                    System.out.println("ISOSCELES");
                } else {
                    System.out.println("ESCALENO");
                }
            }
        } else {
            System.out.println("Não é um triangulo");
        }
    }
}
