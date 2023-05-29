import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

class Data {
  private int dia;
  private int mes;
  private int ano;
  
  void Data() {
    entraDia();
    entraMes();
    entraAno();
  }
    
  void Data(int d, int m, int a) {
    entraDia(d);
    entraMes(m);
    entraAno(a);
  }
  
  void entraDia() {
    int d=0;
    Scanner ler = new Scanner(System.in);
    do {
      try {
        System.out.print("Digite o dia: ");
        d = ler.nextInt();
      } catch (Exception e) {
        System.out.println("Informe um número entre 1 e 31.");
        ler.nextLine();
      }
    } while(d<1 || d>31);

    entraDia(d);
  }
  
  void entraMes() {
    int m=0;
    Scanner ler = new Scanner(System.in);
    do {
      try {
        System.out.print("Digite o mês: ");
        m = ler.nextInt();
      } catch (Exception e) {
        System.out.println("Informe um número entre 1 e 12.");
        ler.nextLine();
      }
    } while(m<1 || m>12);

    entraMes(m);
  }
  
  void entraAno() {
    int a=0;
    Scanner ler = new Scanner(System.in);
    do {
      try {
        System.out.print("Digite o ano: ");
        a = ler.nextInt();
      } catch (Exception e) {
        System.out.println("Informe um número maior que zero.");
        ler.nextLine();
      }
    } while(a<1);

    entraAno(a);
  }
  
  void entraDia(int d) {
    this.dia = d;
  }
  
  void entraMes(int m) {
    this.mes = m;
  }
  
  void entraAno(int a) {
    this.ano = a;
  }

  int retDia() {
    return this.dia;
  }

  int retMes() {
    return this.mes;
  }

  int retAno() {
    return this.ano;
  }

  String mostra1() {
    //devolver a data no formato: dd/mm/aaaa
    // chamar data() se não tiver sido digitada
    return "";
  }

  String mostra2() {
    //devolver a data no formato: dd/mesPorExtenso/ano
    // chamar data() se não tiver sido digitada
    return "";
  }

  boolean bissexto() {
    //devolver um boolean informando se o ano é ou não bissexto
    return true;
  }

  int diasTranscorridos() {
    //retornar a quantidade de dias transcorridos no ano até a data digitada.
    return 0;
  }

  void apresentaDataAtual () {
    //imprimir a data atual, utilizando as classes Date e DateFormat, o DateFormat empregando o seguinte método: getDateInstance(DateFormat.FULL);
    Date dataAtual = new Date();
    System.out.println("Data atual: ");
  }
}

public class TP04 {
    public static void main(String[] args) {
      int opcao=0;
      Scanner ler = new Scanner(System.in);
      Data tp = new Data();

      do {
        do {
          try{
            System.out.println("Menu: ");
            System.out.println("1 - Inserir data");
            System.out.println("2 - Mostrar data no formato dd/mm/aaa");
            System.out.println("3 - Mostrar data no formato dd/NomeMês/aaa");
            System.out.println("4 - Mostrar dias transcorridos no ano");
            System.out.println("5 - Mostrar data atual");
            System.out.print("Opção escolhida: ");
            opcao = ler.nextInt();
          } catch (Exception e) {
            System.out.println("Escolha uma opção de 1 a 5.");
            ler.nextLine();
          }
        } while (opcao<1 || opcao>5);
  
        switch(opcao) {
          case 1:
            tp.Data();
            break;
          case 2:
            System.out.println("Data inserida: "+tp.mostra1());
            break;
          case 3:
            System.out.println("Data inserida: "+tp.mostra2());
            break;
          case 4:
            System.out.println("Dias transcorridos no ano: "+tp.diasTranscorridos());
            break;
          case 5:
            tp.apresentaDataAtual();
            break;
        }
      } while(opcao!=5);
    }
}