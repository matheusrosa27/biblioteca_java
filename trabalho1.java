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

    public class trabalho1 {
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
            
            /*
            System.out.println("");
            System.out.println("Que dia você nasceu?");
            int dia = teclado.nextInt();
            diaValido(dia);
            System.out.println("");

            System.out.println("Que mês você nasceu?");
            int mes = teclado.nextInt();
            mesValido(mes);
            System.out.println("");

            System.out.println("Que ano você nasceu?");
            int ano = teclado.nextInt();
            anoValido(ano);
            System.out.println("");
            */
           
           int dia = Integer.parseInt(nascSeparado[0]);
           diaValido(dia);
           
           int mes = Integer.parseInt(nascSeparado[1]);
           mesValido(mes);
           
           int ano = Integer.parseInt(nascSeparado[2]);
           anoValido(ano);

           System.out.println("Que horas você nasceu? Digite como no exemplo: (22:10)");
           String hora = teclado.next();
           String[] horaSeparada = hora.split(":");
           System.out.println("");

           System.out.println("Dia " + dia + ", Mês " + mes + ", Ano " + ano + ", Hora " + horaSeparada[0] + ", Minuto " + horaSeparada[1]);


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
            System.out.print("Digite o dia que você nasceu: ");
            int dia = numberUser.nextInt();
            diaValido(dia);
            System.out.println("");

            System.out.print("Digite o mês que você nasceu: ");
            int mes = numberUser.nextInt();
            mesValido(mes);
            System.out.println("");

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

            System.out.print("Que dia você nasceu? ");
            int dia = numberUser.nextInt();

            System.out.print("Que mês você nasceu? (Ex: Janeiro): ");
            String mes = numberUser.next();

            System.out.print("Que ano você nasceu? ");
            int ano = numberUser.nextInt();

            int A = ano - 1900;
            int B = A / 4;
            int C = mesC(mes);
            int D = dia - 1;

            int result = (A + B + C + D) % 7;

            switch (result) {
                case 0:
                    System.out.print("Segunda-feira!");
                    break;
                case 1:
                    System.out.print("Terça-feira!");
                    break;
                case 2:
                    System.out.print("Quarta-feira!");
                    break;
                case 3:
                    System.out.print("Quinta-feira!");
                    break;
                case 4:
                    System.out.print("Sexta-feira!");
                    break;
                case 5:
                    System.out.print("Sábado");
                    break;
                case 6:
                    System.out.print("Domingo");
                    break;
            }


        }

        public static int diaValido(int dia){
            Scanner numberUser = new Scanner(System.in);
            if (dia >= 1 && dia <= 31){
                return dia;
            } else {
                System.out.print("ERRO! Insira um dia válido: ");
                dia = numberUser.nextInt();
                return diaValido(dia);
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
            if (ano >= 1900){
                return ano;
            } else {
                System.out.print("ERRO! Insira um ano válido: ");
                int erro = numberUser.nextInt();
                return anoValido(erro);
            }
        }

        public static int mesC(String mes){
            Scanner numberUser = new Scanner(System.in);

            int C = 0;
            if (mes.equals("Janeiro") || mes.equals("Outubro")) {
                C = 0;
            } else if (mes.equals("Fevereiro") || mes.equals("Março") || mes.equals("Novembro")) {
                C = 3;
            } else if (mes.equals("Abril") || mes.equals("Julho")) {
                C = 6;
            } else if (mes.equals("Maio")) {
                C = 1;
            } else if (mes.equals("Junho")) {
                C = 4;
            } else if (mes.equals("Agosto")) {
                C = 2;
            } else if (mes.equals("Setembro") || mes.equals("Dezembro")) {
                C = 5;
            } else {
                System.out.print("Mês Inválido, digite novamente: ");
                String erro = numberUser.next();
                mesC(erro);
            }
            return C;
        }
    }