
/**
 * Escreva uma descrição da classe minha_biblioteca aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;

public class minha_biblioteca
{
    public static void main (String args[]){
        Scanner falaVar = new Scanner(System.in);
        String falas = falaVar.next();
        
        //Criação de strings
        String strg1 = "Fundamentos";
        String strg2 = "Programação";
        
        //Criação de strings
        String fala1 = ("Hello world");
        String fala2 = (strg1+" e "+strg2);
        
        //Condicionais
        if (falas.equals("A")){
            System.out.print(fala1);
        } else if (falas.equals("B")) {
            System.out.print(fala2);
        } else {
            System.out.print("O mundo é uma grande bola");
        }
    }
    
    public static void sec (String args[]){
        System.out.print("Hello Worldz");
    }
    
    public static int  menor1(int a, int b, int c) //usando operadores logicos
    {
        if ((a<b) && (a <c))  return a;//opcional usar { }
              else 
                  {if ((b<a) &&(b <c))  {return b;}
                   else {return c;}
                    }
    }
  
    public static int  menor2(int a, int b, int c) //encadeando
    {
        if (a<b) { if (b<c) {return a;} 
                       else { return c;}
                  }
            else {if (b<c) {return b;} 
                       else {return c;}
            }
    }

    public static int  menor3(int a, int b, int c) //com auxiliar 
    {
        int aux=a;//suponho que o 1o valor e o menor
        if ( b<aux) {aux=b;}
        if ( c<aux) {aux=c;}
        return aux;
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
}


