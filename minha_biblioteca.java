/**
 * Escreva uma descrição da classe minha_biblioteca aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */

import java.time.*; // Importa tudo de "time"
import java.util.Scanner; // Importa o "Scanner" para pegar o que o usuário digitar.
import java.util.Date; // Importa "Date"

public class minha_biblioteca
{
    public static void main (String args[]){
        
    }
    
    
    public static int menor1(){
        Scanner number = new Scanner(System.in);
        
        System.out.println("Digite o 1º número: ");
        int a = number.nextInt();
        System.out.println("Digite o 2º número: ");
        int b = number.nextInt();
        System.out.println("Digite o 3º número: ");
        int c = number.nextInt();
        
        if ((a<b) && (a <c)){
            return a;
        } else {
            if ((b<a) &&(b <c)){
                return b;
            } else {
                return c;
            }
        }
    }
    
    public static void coord(){
        Scanner numberUser = new Scanner (System.in);
        
        System.out.println("Digite as coordenadas que deseja: (Exemplo: 1,2)");
        String coord = numberUser.next();
        String[] coordSeparado = coord.split(",");
        
        int x = Integer.parseInt(coordSeparado[0]);
        int y = Integer.parseInt(coordSeparado[1]);
        
        if (x > 0 && y > 0){
            System.out.println("Está no primeiro quadrante, seu x é igual a "+x+" e seu y é igual a "+y);
        } else if (x < 0 && y > 0){
            System.out.println("Está no segundo quadrante, seu x é igual a "+x+" e seu y é igual a "+y);
        } else if (x < 0 && y < 0){
            System.out.println("Está no terceiro quadrante, seu x é igual a "+x+" e seu y é igual a "+y);
        } else if (x > 0 && y < 0){
            System.out.println("Está no quarto quadrante, seu x é igual a "+x+" e seu y é igual a "+y);
        }
    }
    
    public static int somaDivisores(int a){
        int numero = a;
        int n = 1;
        int qtd = 0;
        int numeroFinal = 0;
       
        do {
            if (numero%n == 0){
                numeroFinal = numeroFinal + n;
                qtd++;
                n++;
            } else {
                n++;
            }
        } while (n<=numero);
        
        return numeroFinal;
    }
    
    public static void primo(){
        Scanner number = new Scanner(System.in);
        System.out.println("Digite um número: ");
        
        double numero = number.nextDouble();
        double n = 1;
        double qtd = 0;
        
        do {
            if (numero%n == 0){
                qtd++;
                n++;
            } else {
                n++;
            }
        } while (n<=numero);
        
        if (qtd<=2){
            System.out.println("É primo.");
        } else {
            System.out.println("Não é primo.");
        }
    }
    
    

    /** RESUMO CLASSE MATH 
       pow(base, expoente)   == potencia
       sqrt(num)             == raiz quadrada
       cbrt(num)             == raiz cúbica
       exp(num)              == euler
       double num = ramdom() == retorna um num randomico
       */
    
    
    /** FÓRMULAS MATEMÁTICAS*/
    
    //Calcula a área de um círculo
    public  static double areaCirculo (double raio){
        return Math.PI*raio*raio; // ou return Math.PI*Math.pow(raio,2);
    }
    
    //Calcula a área de um triângulo
    public  static double areaTriangulo (double base, double altura){
        return (base*altura)/2;
    }
    
    //Calcula o volume do paralelepipedo
    public  static double volumeParalelepipedo(double lado1, double lado2,double lado3){
        return (lado1*lado2*lado3);
    }

    //Calcula o volume de uma pirâmide
    public  static double volumePiramide(double ladobase1,double ladobase2,double altura){
        return (ladobase1*ladobase2*altura)/3;
    }
    
    //Calcula o volume do cilindro
    public  static double volumeCilindro(double raio,double altura){
        return (Math.PI*Math.pow(raio,2)*altura);
    }
    
    //Calcula o volume de uma esfera
    public  static double volumeEsfera(double raio){
        return (4*Math.PI*Math.pow(raio,3)/3);
    }
    
    //Calcula a superfície de um paralelepipedo
    public  static double superficieParalelepipedo(double lado1, double lado2,double lado3){ 
        return (2*lado1*lado2+2*lado1*lado3+2*lado2*lado3);
    }
    
    //Calcula a superfície de uma pirâmide
    public  static double superficiePiramide(double ladobase1,double ladobase2,double altura){
        //recebe o lado da base e a altura de uma piramide e retorna a area de sua superficie
        double alturaLado1 = Math.sqrt( Math.pow(ladobase1/2.,2) + Math.pow(altura,2));
        double alturaLado2 = Math.sqrt( Math.pow(ladobase2/2.,2) + Math.pow(altura,2));
        double areaTriangulo1 = (alturaLado1*ladobase1)/2.;
        double areaTriangulo2 = (alturaLado2*ladobase2)/2.;
        return (2*(areaTriangulo1)+2*(areaTriangulo2)+ ladobase1*ladobase2);
    }
    
    //Calcula a superfície de um cilindro
    public  static double superficieCilindro(double raio,double altura){
        return (2*Math.PI*Math.pow(raio,2)+2*Math.PI*raio*altura);
    }
    
    //Calcula a superfície de uma esfera
    public  static double superficieEsfera(double raio){
        return (4*Math.PI*Math.pow(raio,2));
    }


// Primos:
    public static int divisor1(int num){
            int contador=0;//contador dos divisores
            int aux=1;//gerador de antecedentes do numero
            
            while (aux<=num) 
            { 
            if (num%aux==0) contador++;
            aux++;
                    
            }
            return contador;
                   
    }
    
    public static boolean primo(int num){
        if (divisor1(num)==2){
            return true;
        } else {
            return false;
        }   
    } 
    
    public static boolean amigos( int num1, int num2){ 
        boolean aux=true;
        int soma1=somaDivisores(num1);
        int soma2=somaDivisores(num2);
        if ((num1==soma2)&&(num2==soma1)){
            return aux;
        } else {
            aux=false;
            return aux;
        }
    
    }
    
    //Um número se diz perfeito se é igual à soma de seus divisores próprios. 
    public static boolean perfeito(int num){ 
       if (somaDivisores(num) == num ){
           return true;
        } else {
           return false;
        }
    }
    
}