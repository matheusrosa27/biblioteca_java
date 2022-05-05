/**
 * Escreva uma descrição da classe trabalho2 aqui.
 * Trabalho 2 realizado por Eduardo Pasqualotto Riboli e Matheus Fernandes da Rosa
 * @Matheus Fernandes da Rosa - 22110685
 * @Eduardo Pasqualotto Riboli - 221106234
 * Descrição detalhada dos autores ao final do código.
 * @v1.0
 */

import java.util.*; // Importa tudo de "util"

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
        
        if(testaVerbo(verbo) == true){
            System.out.println("O verbo digitado é um verbo irregular, comece novamente.");
            System.out.println("");
            menu();
        } else {
            if(verbo.endsWith("er")){
                int tam = verbo.length();
                int prefixoER = tam-2;
                String prefixo = verbo.substring(0,prefixoER);
                
                System.out.println("");
                System.out.println("Eu "+prefixo+"o");
                System.out.println("Tu "+prefixo+"es");
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
    }
    
    public static void preteritoPerfeito(){
        System.out.println("Pretérito Perfeito");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um verbo no infinitivo terminado com \"er\": ");
        String verbo = sc.next();
        verbo = verbo.toLowerCase();
        
        if(testaVerbo(verbo) == true){
            System.out.println("O verbo digitado é um verbo irregular, comece novamente.");
            System.out.println("");
            menu();
        } else {
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
    }
    
    public static void futuroDoPresente(){
        System.out.println("Futuro do Presente");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um verbo no infinitivo terminado com \"er\": ");
        String verbo = sc.next();
        verbo = verbo.toLowerCase();
        
        if(testaVerbo(verbo) == true){
            System.out.println("O verbo digitado é um verbo irregular, comece novamente.");
            System.out.println("");
            menu();
        } else {
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
    
    public static boolean testaVerbo(String verbo){
        String verbosIrr = ("abster, adjazer, afazer, antever, aprazer, ater, bem-dizer, bem-fazer, bem-querer, bendizer, benfazer, benquerer, caber, circunver, comprazer, condizer, conter, contradizer, contrafazer, crer, desafazer, desprazer, descaber, descomprazer, descrer, desdizer, desprecaver, desprover, desquerer, dessaber, desvaler, desver, deter, disperder, dizer, entredizer, entrefazer, entrequerer, entrever, equivaler, esfazer, fazer, gelifazer, haver, insatisfazer, interdizer, interver, jazer, ler, liquefazer, maisquerer, maldizer, malfazer, malquerer, manter, obter, perder, perfazer, poder, poer, prazer, predizer, prever, prover, putrefazer, querer, raer, rarefazer, reaver, redizer, refazer, reler, reobter, requerer, reter, rever, saber, ser, satisfazer, suster, telever, ter, torrefazer, transfazer, trazer, treler, tresler, tumefazer, valer, ver");
        String[] verbosIrrArr = verbosIrr.split(", ");
        boolean result = false;
        
        for (int i=0;i<verbosIrrArr.length;i++){
            if (verbo.equalsIgnoreCase(verbosIrrArr[i])){ 
                result = true;
                break;
            } else {
                result = false;
            }
            //System.out.println(verbosIrrArr[i]);
        }
        return result;
    }
}
