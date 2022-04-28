/**
* Escreva uma descrição da classe provaP1 aqui.
* Prova P1 realizada por Matheus Fernandes da Rosa
* @Matheus Fernandes da Rosa - Matrícula 22110685
* Descrição detalhada dos autores ao final do código.
* @v1.0
*/

import java.util.Scanner;

public class provaP1 {

    public static void main(String[] args) {
            System.out.println("Exercício 1: ");
        ex1();
        
            System.out.println("Exercício 2: ");
            ex2();
        
            System.out.println("Exercício 3: ");
            ex3();
    }
    
    public static void ex1(){
                    
            Scanner sc = new Scanner(System.in);

            double baseRet, alturaRet, areaRet;
            System.out.println("Digite a base do retângulo verde: ");
            baseRet = sc.nextDouble();
            System.out.println("Digite a altura do retângulo verde: ");
            alturaRet = sc.nextDouble();
        
            areaRet = baseRet * alturaRet;
        
        double baseTri1, alturaTri1, areaTri1;
        System.out.println("Digite a base do triângulo azul: ");
        baseTri1 = sc.nextDouble();
        System.out.println("Digite a altura do triângulo azul: ");
        alturaTri1 = sc.nextDouble();
        
        areaTri1 = (baseTri1 * alturaTri1)/2;
        
        double baseTri2, alturaTri2, areaTri2;
        System.out.println("Digite a base do triângulo verde: ");
        baseTri2 = sc.nextDouble();
        System.out.println("Digite a altura do triângulo verde: ");
        alturaTri2 = sc.nextDouble();
        
        areaTri2 = (baseTri2 * alturaTri2)/2;
        
        double ladoQuad, areaQuad;
        System.out.println("Digite o lado do quadrado vermelho: ");
        ladoQuad = sc.nextDouble();
        
        areaQuad = ladoQuad * ladoQuad;
        
        double raioC, areaC;
        System.out.println("Digite o raio do círculo verde: ");
        raioC = sc.nextDouble();
        
        areaC = Math.PI*(raioC*raioC);
        
        double areaTotalVerde, areaTotalAzul, areaTotalVerm;
        
        areaTotalVerde = areaRet - areaTri1 - areaQuad + areaTri2 + raioC;
        areaTotalAzul = areaTri1 - areaTri2;
        areaTotalVerm = areaQuad - areaC;
        
        System.out.println("Total de área da tinta VERDE: "+areaTotalVerde);
        System.out.println("Total de área da tinta AZUL: "+areaTotalAzul);
        System.out.println("Total de área da tinta VERMELHA: "+areaTotalVerm);
        System.out.println();   
       
    }
    
    public static void ex2() {
        Scanner sc = new Scanner(System.in);
        
        double cima, tudo;
        System.out.println("Digite o valor de x: ");
        double x = sc.nextDouble();
        System.out.println("Digite o valor de y: ");
        double y = sc.nextDouble();
        
        cima = (Math.pow(3,7) * (Math.sqrt(x))) - (4 * (Math.pow(y, 32)) + (Math.pow(x, (Math.pow(y, 2)))));
        tudo = cima / (2*y);
        
        System.out.println("\n"+tudo);
        System.out.println();
        
        
        
    }
    
    public static void ex3() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Verificar se dois valores são amigos e se a soma é divisível por 5: ");
        System.out.println("2 - Quantidade de números primos (de dois dígitos) nos 500 primeiros números naturais: ");
        int option = sc.nextInt();
        
        switch(option) {
        case 1:
            doisVal();
            System.out.println();
            break;
        case 2:
            System.out.println("Existem "+numPrimo()+" números primos entre 0 e 500 (de dois dígitos).");
            System.out.println();
            break;
        default:
            System.out.println("Opção inválida.");
            System.out.println();
        }
    }
    
    public static boolean doisVal() {
            int i, suma = 0, n1, n2;
            boolean retorno;
        Scanner sc = new Scanner(System.in);
         
         System.out.print("Digite o primeiro valor: ");
         n1 = sc.nextInt();
         System.out.print("Digite o segundo valor: ");
         n2 = sc.nextInt();
      
         for(i = 1;i < n1;i++){  
             if(n1%i==0){
                 suma=suma+i;
             }
         }
            if(suma==n2){
                suma=0;
                for(i = 1;i < n2;i++){  
                    if(n2%i==0){
                       suma=suma+i;
                    }
                }
                
                if(suma==n1){
                    if ( (n1 + n2) % 5 == 0) {
                        System.out.println("São amigos e a soma dos dois é divisível por 5");
                        retorno = true;
                    } else {
                        System.out.println("São amigos, mas a soma dos dois não é divisível por 5");
                        retorno = false;
                    }
                    
                } else {
                  System.out.println("Não são amigos");
                  retorno = false;
                }
            } else {
                System.out.println("Não são amigos");
                retorno = false;
            }
            
            return retorno;


    }
    
    public static int numPrimo() {
        int[] primosArr = null;
        int contador = 0;
        
        for(int i = 2; i <= 499; i++) {
            boolean primo = true;
            
            for(int j = 2; j < i; j++) {            
                if(i % j == 0) {
                    primo = false;
                }
            }
            
            if(primo) {
                primosArr = new int[i+1];
                primosArr[i] = i;
                if (i >= 10 && i <= 99) {
                    contador++;
                }                
            }          
        }
        return contador;
    }

}
