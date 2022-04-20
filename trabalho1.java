/**
 * Escreva uma descrição da classe trabalho1 aqui.
 * Trabalho 1 realizado por Eduardo Pasqualotto Riboli e Matheus Fernandes da Rosa
 * @Matheus Fernandes da Rosa - Matrícula 22110685
 * @Eduardo Pasqualotto Riboli - Matrícula 22106234
 * @v1.0
 */
import java.time.*;
import java.util.Scanner;
import java.util.Date;

public class Trabalho1 {
    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        System.out.println("Digite o número da opção abaixo");
        System.out.println("1 - Descobrir quantos dias, horas e minutos que você já viveu. ");
        System.out.println("2 - Descobrir se a pessoa está de aniversário. ");
        System.out.println("3 - Descobrir o dia da semana que a pessoa nasceu. ");
        System.out.println("4 - Sair do programa");

        int option;

        option = menuOption();

        switch (option){
            case 1:
                diasVida();
                System.out.println();
                break;
            case 2:
                aniversario();
                System.out.println();
                break;
            case 3:
                diaSemana();
                System.out.println();
                break;
            case 4:
                System.exit(0);
                System.out.println();
                break;
            default:
                System.out.println("Você digitou uma opção inválida, por favor, digite um número de 1 a 4");
                menu();
                break;
        }
        menu();
    }

    public static int menuOption(){
        int option;
        try{
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            option = teclado.nextInt();
        } catch (Exception exception) {
            System.out.println("Você não digitou um número, por favor, digite um número novamente.");
            menu();
            option = menuOption();
        }
        return option;
    }

    public static void diasVida(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("");
        System.out.println("Digite sua data de nascimento: (Exemplo: 27/05/2002)");
        String nasc = teclado.next();
        String[] nascSeparado = nasc.split("/");
        System.out.println("");

        int dia = diaValido(Integer.parseInt(nascSeparado[0]));

        int mes = mesValido(Integer.parseInt(nascSeparado[1]));

        int ano = anoValido(Integer.parseInt(nascSeparado[2]));

        System.out.println("Que horas você nasceu? Digite como no exemplo: (22:10)");
        String hora = teclado.next();
        String[] horaSeparada = hora.split(":");
        System.out.println("");
        
        int horaCorreta = horaValida(Integer.parseInt(horaSeparada[0]));
        int minutoCorreto = minutoValido(Integer.parseInt(horaSeparada[1]));
        

        System.out.println("Dia " + dia + ", Mês " + mes + ", Ano " + ano + ", Hora " + horaCorreta + ", Minuto " + minutoCorreto);


        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int diaHoje = localDate.getDayOfMonth();
        int mesHoje = localDate.getMonthValue();
        if (mesHoje <= mes) {
            mesHoje = mesHoje+12;
        } else {
            localDate.getMonthValue();
        };
        int anoHoje = localDate.getYear();

        int diasCalc = ((((anoHoje - 1) - ano) * 365) + ((mesHoje - 1) * 30) + diaHoje);
        int horasCalc = ((diasCalc * 24) - Integer.parseInt(horaSeparada[0]));
        int minutosCalc = ((horasCalc * 60) - Integer.parseInt(horaSeparada[1]));
        int segundosCalc = (minutosCalc * 60);

        System.out.println("Você tem "+diasCalc+" dias de vida!"); // Quantos dias se passaram até hoje.
        System.out.println("Você tem "+horasCalc+" horas de vida!"); //
        System.out.println("Você tem "+minutosCalc+" minutos de vida!");
        System.out.println("Você tem "+segundosCalc+" segundos de vida!");
    }

    public static void aniversario(){
        Scanner numberUser = new Scanner(System.in);

        System.out.println("");
        System.out.println("Digite o dia e o mês de nascimento: (Exemplo: 27/05)");
        String nascimento = numberUser.next();
        String[] nascSeparado = nascimento.split("/");
        System.out.println("");

        int dia = diaValido(Integer.parseInt(nascSeparado[0]));

        int mes = mesValido(Integer.parseInt(nascSeparado[1]));

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int diaHoje = localDate.getDayOfMonth();
        int mesHoje = localDate.getMonthValue();
        int calcMes;
        if (mes <= mesHoje){
            calcMes = ((mes + 12) - mesHoje);
        } else {
            calcMes = (mes - mesHoje);
        }

        int calcDias;
        if (dia <= diaHoje) {
            calcDias = ((dia + 30) - diaHoje);
        } else {
            calcDias = (dia - diaHoje);
        }

        if (dia == diaHoje && mes == mesHoje){
            System.out.println("PARABÉNS!!! Você está de aniversário hoje!!!");
        } else if (mesHoje > mes) {
            // if else para ver quando vai ser o aniversario ou quando foi o aniversario
            System.out.println("Infelizmente hoje não é seu aniversário, seu aniversário foi dia "+dia+"/"+mes); // variavel com dia do aniversaio
            System.out.println("Seu aniversário será daqui a "+calcMes+" mês(es) e "+calcDias+" dias.");
        } else {
            System.out.println("Seu aniversário será daqui a "+calcMes+" mês(es) e "+calcDias+" dias.");
        }

    }

    public static void diaSemana(){
        Scanner numberUser = new Scanner(System.in);
        System.out.println("");

        System.out.println("Digite sua data de nascimento: (Exemplo: 27/Março/2002)");
        String nasc = numberUser.next();
        String[] nascSeparado = nasc.split("/");
        System.out.println("");

        int dia = diaValido(Integer.parseInt(nascSeparado[0]));

        String mes = nascSeparado[1];

        int ano = anoValido(Integer.parseInt(nascSeparado[2]));

        int A = ano - 1900;
        int B = A / 4;
        int C = mesC(mes);
        int D = dia - 1;

        int result = (A + B + C + D) % 7;

        switch (result) {
            case 0:
                System.out.print("Você nasceu na Segunda-feira!");
                System.out.println("");
                break;
            case 1:
                System.out.print("Você nasceu na Terça-feira!");
                System.out.println("");
                break;
            case 2:
                System.out.print("Você nasceu na Quarta-feira!");
                System.out.println("");
                break;
            case 3:
                System.out.print("Você nasceu na Quinta-feira!");
                System.out.println("");
                break;
            case 4:
                System.out.print("Você nasceu na Sexta-feira!");
                System.out.println("");
                break;
            case 5:
                System.out.print("Você nasceu no Sábado!");
                System.out.println("");
                break;
            case 6:
                System.out.print("Você nasceu no Domingo!");
                System.out.println("");
                break;
        }


    }

    public static int diaValido(int dia){
        Scanner numberUser = new Scanner(System.in);
        if (dia >= 1 && dia <= 31){
            return dia;
        } else {
            System.out.print("ERRO! Insira um dia válido: ");
            int erro = numberUser.nextInt();
            return diaValido(erro);
        }
    }

    public static int mesValido(int mes) {
        Scanner numberUser = new Scanner(System.in);
        if (mes >= 1 && mes <= 12) {
            return mes;
        } else {
            System.out.print("ERRO! Insira um mês válido: ");
            int erro = numberUser.nextInt();
            return mesValido(erro);
        }
    }

    public static int anoValido(int ano){
        Scanner numberUser = new Scanner(System.in);
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int anoHoje = localDate.getYear(); 
        
        if (ano >= 1900 && ano <= anoHoje){
            return ano;
        } else {
            System.out.print("ERRO! Insira um ano válido: ");
            int erro = numberUser.nextInt();
            return anoValido(erro);
        }
    }
    
    public static int horaValida(int hora){
        Scanner numberUser = new Scanner(System.in);
        if (hora >= 0 && hora <= 24){
            return hora;
        } else {
            System.out.println("ERRO! Insira uma hora válida: ");
            int erro = numberUser.nextInt();
            return horaValida(erro);
        }
    }

    public static int minutoValido(int minuto){
        Scanner numberUser = new Scanner(System.in);
        if (minuto >= 0 && minuto <= 59){
            return minuto;
        } else {
            System.out.println("ERRO! Insira minutos válidos: ");
            int erro = numberUser.nextInt();
            return minutoValido(erro);
        }
    }
    public static int mesC(String mes){
        Scanner numberUser = new Scanner(System.in);

        int C = 0;
        if (mes.equalsIgnoreCase("Janeiro") || mes.equalsIgnoreCase("Outubro")) {
            C = 0;
        } else if (mes.equalsIgnoreCase("Fevereiro") || mes.equalsIgnoreCase("Março") || mes.equalsIgnoreCase("Novembro")) {
            C = 3;
        } else if (mes.equalsIgnoreCase("Abril") || mes.equalsIgnoreCase("Julho")) {
            C = 6;
        } else if (mes.equalsIgnoreCase("Maio")) {
            C = 1;
        } else if (mes.equalsIgnoreCase("Junho")) {
            C = 4;
        } else if (mes.equalsIgnoreCase("Agosto")) {
            C = 2;
        } else if (mes.equalsIgnoreCase("Setembro") || mes.equalsIgnoreCase("Dezembro")) {
            C = 5;
        } else {
            System.out.print("Mês Inválido, digite novamente: ");
            String erro = numberUser.next();
            return mesC(erro);
        }
        return C;
    }
    
    /* COMENTÁRIOS SOBRE O TRABALHO:

     * Matheus Fernandes da Rosa:
     * As principais dificuldades encontradas foram a "tradução" da minha lógica para o BlueJ devido à falta de conhecimento da linguagem
     Java, porém, aos poucos e com bastante pesquisa na internet e exemplos em aula, consegui contribuir significativamente, mesmo entrando
     um pouco mais tarde na disciplina.
     
     * Eduardo Pasqualotto Riboli:
     * 
     */
}