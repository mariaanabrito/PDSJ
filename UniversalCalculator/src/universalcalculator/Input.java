package universalcalculator;

import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.zone.ZoneRulesException;
import java.util.Scanner;
import java.util.InputMismatchException;

/*
    Classe Input é responsável pela interação com o utilizador da calculadora universal.
*/

public class Input 
{
    /*
        Pede ao utilizador que insira um data, discriminando os campos (ano, mês, dia). Verifica se os dados inseridos
        são válidos.
    */
    public static LocalDate getDataInput()
    {
        int ano, mes, dia;
        LocalDate d = null;
        StringBuilder sb = new StringBuilder();
        
        out.print("Insira o ano da data:");
        ano = Input.lerInt();
        out.print("Insira o mês da data:");
        mes = Input.lerInt();
        out.print("Insira o dia da data:");
        dia = Input.lerInt();
        
        
        if(ano < 100)
            sb.append("00").append(ano).append("-");
        else if(ano < 1000)
            sb.append("0").append(ano).append("-");
        else
            sb.append(ano).append("-");
        
        if(mes < 10)
            sb.append("0").append(mes).append("-");
        else
            sb.append(mes).append("-");
        
        
        if(dia < 10)
            sb.append("0").append(dia);
        else
            sb.append(dia);
        
        try 
        {
            d = Parser.parseStringToDate(sb.toString());
        } catch (DateTimeParseException e) 
        {
            out.println("Data inválida!");
        }
        
        return d;
    }
    
    /*
        Pede ao utilizador que insira uma data, um tempo e o ID de uma zona, discriminando todos os campos (ano, mês, dia,
        horas, minutos, segundos e ID da zona). Verifica ainda se os dados inseridos estão corretos.
    */
    public static ZonedDateTime getDataTempoFusoInput(boolean zonaLocal)
    {
        int ano, mes, dia, horas, minutos, segundos;
        String zona = "";
        ZonedDateTime zdt = null;
        LocalDateTime d = null;
        StringBuilder sb = new StringBuilder();
        
        out.print("Insira o ano da data:");
        ano = Input.lerInt();
        out.print("Insira o mês da data:");
        mes = Input.lerInt();
        out.print("Insira o dia da data:");
        dia = Input.lerInt();
        out.print("Insira as horas da data:");
        horas = Input.lerInt();
        out.print("Insira os minutos da data:");
        minutos = Input.lerInt();
        out.print("Insira os segundos da data:");
        segundos = Input.lerInt();
        if(!zonaLocal)
        {
            out.print("Insira o id da zona:");
            zona = Input.lerString();
        }
 
        if(ano < 100)
            sb.append("00").append(ano);
        else if(ano < 1000)
            sb.append("0").append(ano);
        else
            sb.append(ano);
        sb.append("-");
        
        if(mes < 10)
            sb.append("0").append(mes);
        else
            sb.append(mes);
        sb.append("-");
        
        if(dia < 10)
            sb.append("0").append(dia);
        else
            sb.append(dia);
        sb.append("T");
        
        if(horas < 10)
            sb.append("0").append(horas);
        else
            sb.append(horas);
        sb.append(":");
        
        if(minutos < 10)
            sb.append("0").append(minutos);
        else
            sb.append(minutos);
        sb.append(":");
        
        if(segundos < 10)
            sb.append("0").append(segundos);
        else
            sb.append(segundos);
        
        try 
        {
            if(!zonaLocal)
                zdt = Parser.parseStringtoZonedDateTime(sb.toString(), zona);
            else
                zdt = Parser.parseStringtoZoneDateTimeLocal(sb.toString());
        } catch (DateTimeParseException e ) 
        {
            out.println("Valores inválidos para a data!");
        }catch(ZoneRulesException e)
        {
            out.println("ID da zona inexistente!");
        }catch( DateTimeException e)
        {
            out.println("Id da zona inválido");
        }
        
        return zdt;
    }
    
    /*
        Pede ao utilizador que insira um tempo, discriminando os campos (horas, minutos, segundos e nanossegundos). Verifica
        se os dados inseridos são válidos.
    */
    public static LocalTime getTempoInput()
    {
        int horas, minutos, segundos, nano;
        LocalTime lt = null;
        StringBuilder sb = new StringBuilder();
        
        out.print("Insira as horas:");
        horas = Input.lerInt();
        out.print("Insira os minutos:");
        minutos = Input.lerInt();
        out.print("Insira os segundos:");
        segundos = Input.lerInt();
        out.print("Insira os nanossegundos:");
        nano = Input.lerInt();
                
        if(horas < 10)
            sb.append("0").append(horas);
        else
            sb.append(horas);
        sb.append(":");
        
        if(minutos < 10)
            sb.append("0").append(minutos);
        else
            sb.append(minutos);
        sb.append(":");
        
        if(segundos < 10)
            sb.append("0").append(segundos);
        else
            sb.append(segundos);
        sb.append(".");
        sb.append(nano);
        
        try 
        {
            lt = Parser.parseStringToTime(sb.toString());
            
        } catch (DateTimeParseException e) 
        {
            out.println("Valores inválidos para as horas!");
        }
        return lt;
    }
    
    /*
        Pede ao utilizador que insira uma data e um tempo, discriminando todos os campos (ano, mês, dia,
        horas, minutos e segundos). Verifica ainda se os dados inseridos estão corretos.
    */
    public static LocalDateTime getDataTempoInput()
    {
        int ano, mes, dia, horas, minutos, segundos;
        LocalDateTime ldt = null;
        StringBuilder sb = new StringBuilder();
        
        out.print("Insira o ano da data:");
        ano = Input.lerInt();
        out.print("Insira o mês da data:");
        mes = Input.lerInt();
        out.print("Insira o dia da data:");
        dia = Input.lerInt();
        out.print("Insira as horas da data:");
        horas = Input.lerInt();
        out.print("Insira os minutos da data:");
        minutos = Input.lerInt();
        out.print("Insira os segundos da data:");
        segundos = Input.lerInt();
 
        if(ano < 100)
            sb.append("00").append(ano);
        else if(ano < 1000)
            sb.append("0").append(ano);
        else
            sb.append(ano);
        sb.append("-");
        
        if(mes < 10)
            sb.append("0").append(mes);
        else
            sb.append(mes);
        sb.append("-");
        
        if(dia < 10)
            sb.append("0").append(dia);
        else
            sb.append(dia);
        sb.append("T");
        
        if(horas < 10)
            sb.append("0").append(horas);
        else
            sb.append(horas);
        sb.append(":");
        
        if(minutos < 10)
            sb.append("0").append(minutos);
        else
            sb.append(minutos);
        sb.append(":");
        
        if(segundos < 10)
            sb.append("0").append(segundos);
        else
            sb.append(segundos);
        
        try 
        {
            ldt = Parser.parseStringtoDateTime(sb.toString());
        } 
        catch (DateTimeParseException e) 
        {
            out.println("Valores inválidos para a data!");
        }

        return ldt;
    }
    
    /*
        Verifica se o utilizador premiu Enter.
    */
    public static void pressionaCrono()
    {        
        try {
            in.read();
        } catch (IOException ex) {
            out.println("Ocorreu um erro quando o utilizador deveria ter premido o enter");
        }
    }
    
    /*
        Verifica se o utilizador premiu Enter.
    */
    public static void pressionaEnter()
    {
        out.println("Prima \"Enter\" para continuar");
        
        try {
            in.read();
        } catch (IOException ex) {
            out.println("Ocorreu um erro quando o utilizador deveria ter premido o enter");
        }
    }
    
    /*
        Lê uma String introduzida pelo utilizador.
    */
    public static String lerString() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        String txt = "";
        while(!ok) {
            try {
                if(input.hasNextLine())
                {txt = input.nextLine();
                ok = true;}
            }
            catch(InputMismatchException e) 
                { out.println("Texto Inválido"); 
                  out.print("Novo valor: ");
                  input.nextLine(); 
                }
        }
        
        return txt;
     } 

    /*
        Lê um número inteiro introduzido pelo utilizador.
    */
    public static int lerInt() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        int i = 0; 
        while(!ok) {
            try {
                 if(input.hasNextLine())
                 {
                   i = input.nextInt();
                   ok = true;
                 }
            }
            catch(InputMismatchException e) 
                { out.println("Inteiro Invalido"); 
                  out.print("Novo valor: ");
                  input.nextLine(); 
                }
        }
        return i;
     } 

    /*
        Lê um número decimal introduzido pelo utilizador.
    */
    public static float lerFloat() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        float i = 0; 
        while(!ok) {
            try {
                 if(input.hasNextLine())
                 {
                   i = input.nextFloat();
                   ok = true;
                 }
            }
            catch(InputMismatchException e) 
                { out.println("Float Invalido"); 
                  out.print("Novo valor: ");
                  input.nextLine(); 
                }
        }
        return i;
     } 
   }
