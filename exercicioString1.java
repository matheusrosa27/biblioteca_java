
/**
 * Escreva uma descrição da classe exercicioString1 aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import java.util.Scanner;
import java.util.*;

public class exercicioString1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Exercício 1 - Digite uma palavra: ");
        String frase1 = sc.next();
        System.out.println("A quantidade de vogais é igual a: "+vogais(frase1));
        
        System.out.println("Exercício 2 - Digite uma frase: ");
        String frase2 = sc.nextLine();
        System.out.println("Digite uma palavra: ");
        String palavra2 = sc.next();
        System.out.println("A quantidade de vezes que a palavra "+palavra2+" apareceu é igual a: "+vezes(frase2,palavra2));
    }
    
    public static int vogais(String palavra){
        int total = 0;
        for(int cont = 0; cont < palavra.length(); cont++)
        {
            char letra = palavra.charAt(cont);
            if(letra == 'a' || letra == 'e' || letra =='i' || letra == 'o' || letra=='u'){
                total++;
            } 
        }
        return total;
    }
    
    public static int vezes(String frase, String palavra){
        return 1;
    }
}
