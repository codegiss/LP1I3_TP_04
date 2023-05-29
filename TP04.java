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
    int d = retDia();
    int m = retMes();
    int a = retAno();

    String dia = Integer.toString(d);
    String mes = Integer.toString(m);
    String ano = Integer.toString(a);
    if (dia.length() == 1)
      dia = "0" + dia;
    if (mes.length() == 1)
      mes = "0" + mes;
    
    switch(ano.length()) {
      case 1:
        ano = "000" + ano;
        break;
      case 2:
        ano = "00" + ano;
        break;
      case 3:
        ano = "0" + ano;
        break;
    }
    
    return "Data digitada: "+dia+"/"+mes+"/"+ano;
  }

  String mostra2() {
    int d = retDia();
    int m = retMes();
    int a = retAno();

    String dia = Integer.toString(d);
    String mes = "";
    String ano = Integer.toString(a);

    if (dia.length() == 1)
      dia = "0" + dia;

    switch(m) {
      case 1:
        mes = "janeiro";
        break;
      case 2:
        mes = "fevereiro";
        break;
      case 3:
        mes = "março";
        break;
      case 4:
        mes = "abril";
        break;
      case 5:
        mes = "maio";
        break;
      case 6:
        mes = "junho";
        break;
      case 7:
        mes = "julho";
        break;
      case 8:
        mes = "agosto";
        break;
      case 9:
        mes = "setembro";
        break;
      case 10:
        mes = "outubro";
        break;
      case 11:
        mes = "novembro";
        break;
      default:
        mes = "dezembro";
        break;
    }

    switch (ano.length()) {
      case 1:
        ano = "000" + ano;
        break;
      case 2:
        ano = "00" + ano;
        break;
      case 3:
        ano = "0" + ano;
        break;
    }
    
    return "Data digitada: "+dia+"/"+mes+"/"+ano;
  }

  boolean bissexto() {
    int ano = retAno();
    if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)
      return true;
    return false;
  }

  int diasTranscorridos() {
    int mes = retMes();
    int dia = retDia();
    int dias=0;

    switch(mes) {
      case 1:
        dias = dia;
        break;
      case 2:
        dias = dia + 31;
        break;
      case 3:
        dias = dia + 59;
        break;
      case 4:
        dias = dia + 90;
        break;
      case 5:
        dias = dia + 120;
        break;
      case 6:
        dias = dia + 151;
        break;
      case 7:
        dias = dia + 181;
        break;
      case 8:
        dias = dia + 212;
        break;
      case 9:
        dias = dia + 243;
        break;
      case 10:
        dias = dia + 273;
        break;
      case 11:
        dias = dia + 304;
        break;
      case 12:
        dias = dia + 334;
        break;
    }

    if (bissexto() && (mes>2 || (mes==2 && dia==29)))
      dias++;

    return dias;
  }

  void apresentaDataAtual () {
    DateFormat dataAtual = DateFormat.getDateInstance();
    String data = dataAtual.format(new Date());
    System.out.println("Data atual: "+ data);
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
            System.out.println("6 - Sair");
            System.out.print("Opção escolhida: ");
            opcao = ler.nextInt();
          } catch (Exception e) {
            System.out.println("Escolha uma opção de 1 a 6.");
            ler.nextLine();
          }
        } while (opcao<1 || opcao>6);
  
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
          default:
            break;
        }
      } while(opcao!=6);

      ler.close();
    }
}