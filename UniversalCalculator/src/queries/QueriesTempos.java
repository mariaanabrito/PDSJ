package queries;

import static java.lang.System.out;
import java.time.Duration;
import java.time.LocalTime;
import tempos.Time;
import tempos.TimeInterface;
import static universalcalculator.Constants.MILLISECONDS_IN_NANO;
import universalcalculator.Input;

/*
    Queries relativas à funcionalidade Tempo da calculadora universal.
*/

public class QueriesTempos 
{
    /*
        Calcula a diferença entre dois tempos. Resultado é apresentado horas, minutos, segundos e nanossegundos.
    */
    public static void difTempos()
    {
        StringBuilder sb = new StringBuilder();
        LocalTime lt1, lt2;
        lt1 = Input.getTempoInput();
        if(lt1 != null)
        {
            out.println("Segunda hora:");
            lt2 = Input.getTempoInput();
            if(lt2 != null)
            {
                LocalTime lt = TimeInterface.difTime(lt1, lt2);
                
                sb.append("Faltam ")
                .append(lt.getHour())
                .append(" horas, ")
                .append(lt.getMinute())
                .append(" minutos, ")
                .append(lt.getSecond())
                .append(" segundos e ")
                .append(lt.getNano())
                .append(" nanossegundos.");
                
                out.println(sb);
                
                Input.pressionaEnter();
            }
        }
    }
    
    /*
        Determina a diferença entre o record de 100 m de Usain Bolt obtido a 16 de Agosto de 2009 em Berlim e o tempo passado
        como parâmetro. 
    */
    public static void maisLentoQueOBolt()
    {
        StringBuilder sb = new StringBuilder();
        TimeInterface i = new Time();
        LocalTime lt;
        lt = Input.getTempoInput();
        if(lt != null)
        {
            
            Duration tempo = i.quantoTempoSouMaisLentoQueBolt(lt);
            
            if(tempo.getSeconds() < 0 || tempo.getNano() < 0)
                sb.append("Ninguém é mais rápido que o Usain Bolt!");
            else
              sb.append("É ")
              .append(tempo.getSeconds())
              .append(" segundos e ")
              .append(tempo.getNano()*MILLISECONDS_IN_NANO)
              .append(" milissegundos mais lento que o Bolt.");
        
            out.println(sb);
            
            Input.pressionaEnter();
        }
    }
    
    /*
        O utilizador pode escolher se pretende somar ou subtrair tempos.
        Assim, a um determinado tempo soma/subtrai horas, minutos segundos e milissegundos.
    */
    public static void operacaoTempos()
    {
        int soma;
        String op = "somar";
        int horas, minutos, segundos, nano;
        LocalTime lt;
        TimeInterface dti = new Time();
        
        out.print("Insira 0 se quiser somar e 1 se quiser subtrair:");
        soma = Input.lerInt();
        
        if(soma == 0 || soma == 1)
        {
            lt= Input.getTempoInput();

            if(soma == 1)
                op = "subtrair";
            
            if(lt != null)
            {
                out.print("Insira as horas a " + op +": ");
                horas = Input.lerInt();
                out.print("Insira os minutos a " + op +": ");
                minutos = Input.lerInt();
                out.print("Insira os segundos a " + op +": ");
                segundos = Input.lerInt();
                out.print("Insira os nanossegundos a " + op +": ");
                nano = Input.lerInt();

                if(horas < 0 || minutos < 0 || segundos < 0 || nano < 0)
                    out.println("Insira valores positivos!");
                else
                {
                    if(soma == 0)
                    {
                        LocalTime lt1 = dti.somaTempo(lt, horas, minutos, segundos, nano); 
                        out.println(lt1.toString());
                    }
                    else
                    {
                        LocalTime lt1 = dti.subtraiTempo(lt, horas, minutos, segundos, nano); 
                        out.println(lt1.toString());
                    }

                    Input.pressionaEnter();
                }

            }
        }
        else
            out.println("Opção inválida");
    }
}
