
/**
 * Escreva uma descrição da classe exercicio aqui.
 * 
 * @author (Matheus Fernandes da Rosa) 
 * @version (v1.0)
 */
import java.util.Scanner;

public class exercicio
{
    public static void main(String[] args){
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
        } else if (x == 0 && y == 0){
            System.out.println("Está na origem, seu x é igual a "+x+" e seu y é igual a "+y);
        } else if (x > 0 && y == 0){
            System.out.println("Está no eixo X na parte positiva, seu x é igual a "+x+" e seu y é igual a "+y);
        } else if (x < 0 && y == 0){
            System.out.println("Está no eixo X na parte negativa, seu x é igual a "+x+" e seu y é igual a "+y);
        } else if (x == 0 && y > 0){
            System.out.println("Está no eixo Y na parte positiva, seu x é igual a "+x+" e seu y é igual a "+y);
        } else if (x == 0 && y < 0){
            System.out.println("Está no eixo Y na parte negativa, seu x é igual a "+x+" e seu y é igual a "+y);
        } else {
            System.out.println("Não foi possível localizar seu ponto");
        }
        
    }
}
