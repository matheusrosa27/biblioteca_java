/**
* Escreva uma descrição da classe trabalho1 aqui.
* Trabalho 1 realizado por Eduardo Pasqualotto Riboli e Matheus Fernandes da Rosa
* @Matheus Fernandes da Rosa - Matrícula 22110685
* @Eduardo Pasqualotto Riboli - Matrícula 22106234
* Descrição detalhada dos autores ao final do código.
* @v1.0
*/
import java.time.*; // Importa tudo de "time"
import java.util.Scanner; // Importa o "Scanner" para pegar o que o usuário digitar.
import java.util.Date; // Importa "Date"

public class trabalho1 {
   public static void main(String[] args){
       // Cria-se o método main e executa o menu();
       menu();
   }

   // Menu
   public static void menu() {
       // No menu, ele oferece as opções que o usuário pode digitar.
       System.out.println("Digite o número da opção abaixo");
       System.out.println("1 - Descobrir quantos dias, horas e minutos que você já viveu. ");
       System.out.println("2 - Descobrir se a pessoa está de aniversário. ");
       System.out.println("3 - Descobrir o dia da semana que a pessoa nasceu. ");
       System.out.println("4 - Sair do programa");

       // Cria uma variável e atribui ela o valor do método "menuOption()";
       int option = menuOption();

       switch (option){
           // Caso o usuário digite 1, ele vai para o método diasVida();
           case 1:
               diasVida();
               System.out.println();
               break;
           // Caso o usuário digite 2, ele vai para o método aniversario();
           case 2:
               aniversario();
               System.out.println();
               break;
           // Caso o usuário digite 3, ele vai para o método diaSemana();
           case 3:
               diaSemana();
               System.out.println();
               break;
           // Caso o usuário digite 4, ele encerra o programa;
           case 4:
               System.exit(0);
               System.out.println();
               break;
           // Qualquer outro número, ele invalida essa opção e chama novamente o menu(), repetindo o processo.
           default:
               System.out.println("Você digitou uma opção inválida, por favor, digite um número de 1 a 4");
               menu();
               break;
       }
       // Chama sempre o menu(), para continuar o loop após cada questão.
       menu();
   }

   // Menu que armazena a opção digitada pelo usuário
   public static int menuOption(){
       // Cria-se uma variável do tipo inteiro.
       int option;
       // Utiliza-se o try para qualquer excessão, ele mostre no catch.
       try{
           // Nessa parte, ele realiza a leitura do número digitado pelo usuário no método menu();
           Scanner teclado = new Scanner(System.in);
           System.out.println();
           // Armazena a opção na variável "option";
           option = teclado.nextInt();
       } catch (Exception exception) {
           // Caso o usuário digite um número fora das opções, ocorrerá essa excessão.
           System.out.println("Você não digitou um número, por favor, digite um número novamente.");
           menu();
           // Nesse caso, ele mostra novamente o menu e pede para o usuário digitar novamente uma opção
           option = menuOption();
       }
       // Retorna essa opção
       return option;
   }

   // Opção 1
   public static void diasVida(){
       // Declarada a variável que armazena o Scanner.
       Scanner teclado = new Scanner(System.in);

       System.out.println("");
       System.out.println("Digite sua data de nascimento: (Exemplo: 27/05/2002)");
       // Armazena a data de nascimento digitada pelo usuário.
       String nasc = teclado.next();
       // Separa a data de nascimento em um array por "/".
       String[] nascSeparado = nasc.split("/");
       System.out.println("");

       // Atrubui na variável "dia" o valor do array na posição 0;
       // Além disso, verifica se o dia é válido chamando o método diaValido();
       int dia = diaValido(Integer.parseInt(nascSeparado[0]));

       // Atrubui na variável "dia" o valor do array na posição 1;
       // Além disso, verifica se o dia é válido chamando o método mesValido();
       int mes = mesValido(Integer.parseInt(nascSeparado[1]));

       // Atrubui na variável "dia" o valor do array na posição 2;
       // Além disso, verifica se o dia é válido chamando o método anoValido();
       int ano = anoValido(Integer.parseInt(nascSeparado[2]));

       System.out.println("Que horas você nasceu? Digite como no exemplo: (22:10)");
       String hora = teclado.next();
       // Aloca em um array as horas e os minutos, separados por ":"
       String[] horaSeparada = hora.split(":");
       System.out.println("");

       // Atrubui na variável "horaCorreta" o valor do array da horaSeparada na posição 0;
       // Além disso, verifica se a hora é válida chamando o método horaValida();
       int horaCorreta = horaValida(Integer.parseInt(horaSeparada[0]));

       // Atrubui na variável "minutoCorreto" o valor do array da horaSeparada na posição 1;
       // Além disso, verifica se o minuto é válida chamando o método minutoValido();
       int minutoCorreto = minutoValido(Integer.parseInt(horaSeparada[1]));

       // Mostra todas as opções digitadas pelo usuário
       System.out.println("Dia " + dia + ", Mês " + mes + ", Ano " + ano + ", Hora " + horaCorreta + ", Minuto " + minutoCorreto);

       // Instância uma variável "date" para o método Date();
       Date date = new Date();
       // Instância uma variável localDate para o método LocalDate() para capturar, junto com a variável "date", o dia, mes, ano no instante em que o usuário utilizar o programa.
       LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       // Pega o dia atual;
       int diaHoje = localDate.getDayOfMonth();
       // Pega o mês atual;
       int mesHoje = localDate.getMonthValue();
       // Pega o ano atual;
       int anoHoje = localDate.getYear();
       // Pega a hora atual;
       int horaAtual = date.getHours();
       // Pega o minuto atual;
       int minutoAtual = date.getMinutes();

       // Cálculo dos dias vividos:
       // Primeiro, pega-se o dia de hoje - 1, pois ainda não vivemos totalmente esse ano e subtrai pelo ano digitado pelo usuário e multiplica o resultado pela quantidade de dias por ano.
       // Após isso, soma-se com o mês de hoje, que é subtraído por -1 e multiplicado pela média de dias de cada mês
       // Por fim, soma-se com os dias até hoje.
       int diasCalc = ((((anoHoje - 1) - ano) * 365) + ((mesHoje - 1) * 30) + diaHoje);
       // Cálculo das horas vividas:
       // Primeiro, pega-se os dias calculados anteriormente acima e multiplica por 24, que seria a quantidade de horas por dia mais a hora atual que o usuário digitou no console menos a hora que ele nasceu.
       int horasCalc = ((diasCalc * 24) + horaAtual - Integer.parseInt(horaSeparada[0]));
       // Cálculo dos minutos vividos:
       // Pega-se as horas calculadas, multiplica-se por 60 que é a quantidade de minutos por hora, mais os minutos atuais menos os minutos que o usuário nasceu.
       int minutosCalc = ((horasCalc * 60) + minutoAtual - Integer.parseInt(horaSeparada[1]));
       //Calculo dos segundos vividos:
       // Pega-se os minutos calculados e multiplica-se por 60 que é a quantidade de segundos por minutos.
       int segundosCalc = (minutosCalc * 60);

       // Imprime os resultados das operações acima.
       System.out.println("Você tem "+diasCalc+" dias de vida!"); // Quantos dias se passaram até hoje.
       System.out.println("Você tem "+horasCalc+" horas de vida!"); // Quantas horas se passarama até hoje.
       System.out.println("Você tem "+minutosCalc+" minutos de vida!"); // Quantos minutos se passaram até hoje.
       System.out.println("Você tem "+segundosCalc+" segundos de vida!"); // Quantos segundo se passaram até hoje.
   }

   // Opção 2
   public static void aniversario(){
       // Declarada a variável que armazena o Scanner.
       Scanner numberUser = new Scanner(System.in);

       System.out.println("");
       System.out.println("Digite o dia e o mês de nascimento: (Exemplo: 27/05)");
       // Captura o dia e o mês digitado pelo usuário e armazena na string nascimento.
       String nascimento = numberUser.next();
       // Separa em um array a string nascimento por "/"
       String[] nascSeparado = nascimento.split("/");
       System.out.println("");

       // O array nascSeparado na posição 0 equivale ao dia.
       // Verifica se o dia digitado pelo usuário é válido.
       int dia = diaValido(Integer.parseInt(nascSeparado[0]));

       // O array nascSeparado na posição 1 equivale ao mês.
       // Verifica se o mês digitado pelo usuário é válido.
       int mes = mesValido(Integer.parseInt(nascSeparado[1]));

       // Instância uma variável "date" para o método Date();
       Date date = new Date();
       // Instância uma variável localDate para o método LocalDate() para capturar, junto com a variável "date", o dia, mes, ano no instante em que o usuário utilizar o programa.
       LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

       // A variável diaHoje irá obter o valor do dia atual;
       int diaHoje = localDate.getDayOfMonth();
       // A variável mesHoje irá obter o valor do mês atual;
       int mesHoje = localDate.getMonthValue();
       // Define uma variável calcMes para ser utilizada para obter o valor das diferenças dos meses.
       int calcMes;
       if (mes <= mesHoje){
           // Se o mês de hoje for maior ou igual ao mês que o usuário digitar, ele somará 12 e subtrairá com o mês atual a fim de obter essa diferença.
           calcMes = ((mes + 12) - mesHoje);
       } else {
           // Caso não o mês for maior que o mês atual, ele subtrairá o mês digitado pelo mês atual.
           calcMes = (mes - mesHoje);
       }

       // Define uma variável calcMes para ser utilizada para obter o valor das diferenças dos meses.
       int calcDias;
       if (dia <= diaHoje) {
           // Se o dia de hoje for maior ou igual ao dia que o usuário digitar, ele somará 30 e subtrairá com o dia atual a fim de obter essa diferença.
           calcDias = ((dia + 30) - diaHoje);
       } else {
           // Caso não o dia for maior que o dia atual, ele subtrairá o dia digitado pelo dia atual.
           calcDias = (dia - diaHoje);
       }

       // Caso o dia e o mês digitado pelo usuário for igual ao dia e o mês atual, o usuário estará de aniversário.
       if (dia == diaHoje && mes == mesHoje){
           System.out.println("PARABÉNS!!! Você está de aniversário hoje!!!");
       // Caso o if seja falso, ele mostrará quando foi seu aniversário ou quando será.
       } else if (mesHoje > mes) {
           // if else para ver quando vai ser o aniversario ou quando foi o aniversario
           System.out.println("Infelizmente hoje não é seu aniversário, seu aniversário foi dia "+dia+"/"+mes); // variavel com dia do aniversaio
           System.out.println("Seu aniversário será daqui a "+calcMes+" mês(es) e "+calcDias+" dias.");
       } else {
           System.out.println("Seu aniversário será daqui a "+calcMes+" mês(es) e "+calcDias+" dias.");
       }

   }

   // Opção 3
   public static void diaSemana(){
       // Declarada a variável que armazena o Scanner.
       Scanner numberUser = new Scanner(System.in);
       System.out.println("");

       // Decidimos colocar o mês por escrito para pegarmos o valor númerico referente a cada mês.
       System.out.println("Digite sua data de nascimento: (Exemplo: 27/Março/2002)");
       // Armazena a data de nascimento digitada pelo usuário;
       String nasc = numberUser.next();
       // Separa a data de nascimento, escrita pelo usuário, por "/"
       String[] nascSeparado = nasc.split("/");
       System.out.println("");

       // Armazena o dia, que está na posição 0 do array nascSeparado e verifica se esse dia é válido chamando o método diaValido();
       int dia = diaValido(Integer.parseInt(nascSeparado[0]));
       // Armazena o mês na variável mes, que pegará o valor do array nascSeparado na posição 1;
       String mes = nascSeparado[1];
       // Armazena o ano, que está na posição 2 do array nascSeparado e verifica se esse ano é válido chamando o método anoValido();
       int ano = anoValido(Integer.parseInt(nascSeparado[2]));

       // Pega o ano digitado pelo usuário e subtrai 1900 e armazena esse resultado na variável A.
       int A = ano - 1900;
       // Pega o resultado dessa subtração e divide por 4 e armazena esse resultado na variável B.
       int B = A / 4;
       // Pega o mês que o usuário digitou e aplica no método mesC() e, para cada mês, ele retornará um valor para C, como proposto no exercício.
       // Além disso, ele verifica se o mês que o ussário digitou é válido ou não.
       int C = mesC(mes);
       // Pega o dia digitado pelo usuário e subtrai por 1, armazenando na vari=iável D.
       int D = dia - 1;

       // Cria-se uma variável para obter o resultado do resto da soma das letras, dividido por 7.
       int result = (A + B + C + D) % 7;

       // switch para imprimir o dia que o usuário nasceu na tela.
       // Ele obtem como parâmetro o resultado da variável result e, a partir disso, verifica qual dia a pessoa nasceu.
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

   // Método para verificar se o dia é válido ou não
   public static int diaValido(int dia){
       Scanner numberUser = new Scanner(System.in);
       // Se o dia for igual ou maior que 1 e igual ou menor que 31, ele somente retornará o dia.
       if (dia >= 1 && dia <= 31){
           return dia;
       } else {
           // Caso for diferente, ele dirá que o dia escrito está inválido e pedirá para o usuário escrever novamente outro dia.
           System.out.print("ERRO! Insira um dia válido: ");
           int erro = numberUser.nextInt();
           // Após o usuário corrigir o dia, ele retornará esse número para o método diaValido() para verificar se ele está correto e, se estiver, ele retornará esse dia.
           return diaValido(erro);
       }
   }

   // Método para verificar se o mês é válido ou não
   public static int mesValido(int mes) {
       Scanner numberUser = new Scanner(System.in);
       // Se o mês for igual ou maior que 1 e igual ou menor que 12, ele somente retornará o mês.
       if (mes >= 1 && mes <= 12) {
           return mes;
       } else {
           // Caso for diferente, ele dirá que o mês escrito está inválido e pedirá para o usuário escrever novamente outro mês.
           System.out.print("ERRO! Insira um mês válido: ");
           int erro = numberUser.nextInt();
           // Após o usuário corrigir o mês, ele retornará esse número para o método mesValido() para verificar se ele está correto e, se estiver, ele retornará esse mês.
           return mesValido(erro);
       }
   }

   // Método para verificar se o ano é válido ou não
   public static int anoValido(int ano){
       Scanner numberUser = new Scanner(System.in);
       // Utiliza-se o método Date() e LocalDate() para obter o ano atual.
       Date date = new Date();
       LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       int anoHoje = localDate.getYear();

       // Se o ano for igual ou maior que 1900 e igual ou menor que o ano atual, ele somente retornará o ano.
       if (ano >= 1900 && ano <= anoHoje){
           return ano;
       } else {
           // Caso for diferente, ele dirá que o ano escrito está inválido e pedirá para o usuário escrever novamente outro ano.
           System.out.print("ERRO! Insira um ano válido: ");
           int erro = numberUser.nextInt();
           // Após o usuário corrigir o ano, ele retornará esse número para o método anoValido() para verificar se ele está correto e, se estiver, ele retornará esse ano.
           return anoValido(erro);
       }
   }

   // Método para verificar se a hora é válida
   public static int horaValida(int hora){
       Scanner numberUser = new Scanner(System.in);
       // Se a hora for igual ou maior que 0 e igual ou menor que 24, ele retornará essa hora.
       if (hora >= 0 && hora <= 24){
           return hora;
       } else {
           // Caso for diferente, ele dirá que a hora escrita está inválida e pedirá para o usuário escrever novamente outra hora.
           System.out.println("ERRO! Insira uma hora válida: ");
           int erro = numberUser.nextInt();
           // Após o usuário corrigir a hora, ele retornará esse número para o método horaValida() para verificar se ela está correto e, se estiver, ele retornará essa hora.
           return horaValida(erro);
       }
   }

   // Método para verificar se o minuto é válido
   public static int minutoValido(int minuto){
       Scanner numberUser = new Scanner(System.in);
       // Se o minuto for igual ou maior que 0 e igual ou menor que 59, ele retornará esse minuto.
       if (minuto >= 0 && minuto <= 59){
           return minuto;
       } else {
           // Caso for diferente, ele dirá que o minuto escrito está inválido e pedirá para o usuário escrever novamente outro minuto.
           System.out.println("ERRO! Insira minutos válidos: ");
           int erro = numberUser.nextInt();
           // Após o usuário corrigir o minuto, ele retornará esse número para o método minutoValido() para verificar se ela está correto e, se estiver, ele retornará esse minuto.
           return minutoValido(erro);
       }
   }

   // Método para ver o número correspondente ao mês que o usuário digitar além de verificar se ele é válido.
   public static int mesC(String mes){
       Scanner numberUser = new Scanner(System.in);

       // Inicializa-se a variável C = 0;
       int C = 0;
       // Se o mês for igual à janeiro ou outubro, C = 0;
       if (mes.equalsIgnoreCase("Janeiro") || mes.equalsIgnoreCase("Outubro")) {
           C = 0;
       // Se o mês for igual à fevereiro, março ou novembro, C = 3;
       } else if (mes.equalsIgnoreCase("Fevereiro") || mes.equalsIgnoreCase("Março") || mes.equalsIgnoreCase("Novembro")) {
           C = 3;
       // Se o mês for igual à abril ou julho, C = 6;
       } else if (mes.equalsIgnoreCase("Abril") || mes.equalsIgnoreCase("Julho")) {
           C = 6;
       // Se o mês for igual à maio, C = 1;
       } else if (mes.equalsIgnoreCase("Maio")) {
           C = 1;
       // Se o mês for igual a junho, C = 4;
       } else if (mes.equalsIgnoreCase("Junho")) {
           C = 4;
       // Se o mês for igual a agosto, C = 2;
       } else if (mes.equalsIgnoreCase("Agosto")) {
           C = 2;
       // Se o mês for igual a setembro ou dezembro, C = 5;
       } else if (mes.equalsIgnoreCase("Setembro") || mes.equalsIgnoreCase("Dezembro")) {
           C = 5;
       } else {
       // Se o mês for diferente de qualquer um acima, aparece mês inválido e pede para o usuário digitar novamente outro mês, para assim, passar por esse processo novamente.
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
    * Eu gostei dessa atividade pois foi uma atividade bem parecida com o que eu fiz no processo seletivo da Dell. Esse trabalho me fez pensar bastante,
    * discutir diversas ideias com o matheus até chegarmos em conclusões e, aos poucos, encaminhando o trabalho. Tive um pouco de dificuldades em
    * relação aos métodos do Java, pois não sabia quais existiam e que podiam facilitar demais a nossa vida. Como estou acostumado com C#, a linguagem
    * não me foi um problema já que Java e C# são bem semelhantes, então em questão de lógica e raciocínio, tive bastante tranquilidade para resolver
    * os problemas solicitados.

    * Não pedimos ajuda a nenhum colega, utilizamos apenas conhecimento próprio e diversos sites de referência da internet para consultarmos
    * como seria realizada diversas operações em java e, por final mas não menos importante, consultamos materias de aula para nos auxiliar em
    * outras diversas ocasiões que tivemos dúvida.
    */
}