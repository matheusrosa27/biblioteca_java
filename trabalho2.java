
/**
 * Escreva uma descrição da classe Trabalho2 aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import java.util.*;

public class trabalho2{
    public static void main(String[] args){
        menu();
    }
    
    public static void menu(){
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1 - Conjulgar verbo no PRESENTE");
        System.out.println("2 - Conjulgar verbo no PRETÉRITO PERFEITO");
        System.out.println("3 - Conjulgar verbo no FUTURO DO PRESENTE");
        
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        
        switch(option){
            case 1:
                System.out.println("");
                presente();
                break;
            case 2:
                System.out.println("");
                preteritoPerfeito();
                break;
            case 3:
                System.out.println("");
                futuroDoPresente();
                break;
            default:
                System.out.println("");
                System.out.println("Opção Inválida, digite novamente.");
                menu();
        }
    }
    
    public static void presente(){
        System.out.println("Presente");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um verbo no infinitivo terminado com \"er\": ");
        String verbo = sc.next();
        verbo = verbo.toLowerCase();
        
        if(verbo.endsWith("er")){
            int tam = verbo.length();
            int prefixoER = tam-2;
            String prefixo = verbo.substring(0,prefixoER);
            
            System.out.println("");
            System.out.println("Eu "+prefixo+"o");
            System.out.println("Tu "+prefixo+"e");
            System.out.println("Ele "+prefixo+"e");
            System.out.println("Nós "+prefixo+"emos");
            System.out.println("Vós "+prefixo+"eis");
            System.out.println("Eles "+prefixo+"em");
            System.out.println("");
            menu();
        } else {
            System.out.println("Verbo inválido, comece de novo.");
            System.out.println("");
            menu();
        }
    }
    
    public static void preteritoPerfeito(){
        System.out.println("Pretérito Perfeito");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um verbo no infinitivo terminado com \"er\": ");
        String verbo = sc.next();
        verbo = verbo.toLowerCase();
        
        if(verbo.endsWith("er")){
            int tam = verbo.length();
            int prefixoER = tam-2;
            String prefixo = verbo.substring(0,prefixoER);
            
            System.out.println("");
            System.out.println("Eu "+prefixo+"i");
            System.out.println("Tu "+prefixo+"este");
            System.out.println("Ele "+prefixo+"eu");
            System.out.println("Nós "+prefixo+"emos");
            System.out.println("Vós "+prefixo+"estes");
            System.out.println("Eles "+prefixo+"eram");
            System.out.println("");
            menu();
        } else {
            System.out.println("Verbo inválido, comece de novo.");
            System.out.println("");
            menu();
        }
    }
    
    public static void futuroDoPresente(){
        System.out.println("Futuro do Presente");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um verbo no infinitivo terminado com \"er\": ");
        String verbo = sc.next();
        verbo = verbo.toLowerCase();
        
        if(verbo.endsWith("er")){
            int tam = verbo.length();
            int prefixoER = tam-2;
            String prefixo = verbo.substring(0,prefixoER);
            
            System.out.println("");
            System.out.println("Eu "+prefixo+"erei");
            System.out.println("Tu "+prefixo+"erás");
            System.out.println("Ele "+prefixo+"erá");
            System.out.println("Nós "+prefixo+"eremos");
            System.out.println("Vós "+prefixo+"ereis");
            System.out.println("Eles "+prefixo+"erão");
            System.out.println("");
            menu();
        } else {
            System.out.println("Verbo inválido, comece de novo.");
            System.out.println("");
            menu();
        }
    }
}
