package queries;

import cronometro.Cronometro;
import cronometro.CronometroInterface;
import static java.lang.System.out;
import java.time.LocalTime;
import static universalcalculator.Constants.MILLISECONDS_IN_NANO;

/*
    Queries relativas à funcionalidade Cronómetro da calculadora universal.
*/

public class QueriesCronometro 
{
    private static LocalTime inicio;
    
    /*
        Quando o utilizador pretende inicializar o cronómetro, este método é invocado. Determina o tempo inicial da contagem.
    */
    public static void start()
    {
        CronometroInterface ci = new Cronometro();
        inicio = ci.start();
        out.println("Cronómetro inicializado");
    }
    
    /*
        Quando o utilizador pretende parar a contagem do cronómetro, este método é invocado. A contagem do cronómetro é
        apresentada em horas, minutos, segundos e milissegundos.
    */
    public static void stop()
    {
        CronometroInterface ci = new Cronometro();
        if(inicio != null)
        {
            LocalTime fim = ci.stop(inicio);

            StringBuilder sb = new StringBuilder();
            sb.append("Valor do tempo cronometrado: ")
             .append(fim.getHour())
             .append(" horas, ")
             .append(fim.getMinute())
             .append(" minutos, ")
             .append(fim.getSecond())
             .append(" segundos e ")
             .append(fim.getNano()* MILLISECONDS_IN_NANO)
             .append(" milissegundos.");

            out.println(sb.toString());
            
            inicio = null;
        }
        else
            out.println("Tem de iniciar o cronómetro antes de o poder terminar!");
    }
}
