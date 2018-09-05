package tempos;

import java.time.Duration;
import java.time.LocalTime;

/*
    Funcionalidades do modo Tempo da calculadora universal.
*/
public interface TimeInterface
{
    /*
        Determina a diferença entre o record de 100 m de Usain Bolt obtido a 16 de Agosto de 2009 em Berlim e o tempo passado
        como parâmetro.
    */
    public Duration quantoTempoSouMaisLentoQueBolt(LocalTime time);
    
    /*
        A um determinado tempo soma horas, minutos segundos e milissegundos.
    */
    public LocalTime somaTempo(LocalTime time, int horas, int minutos, int segundos, int mili);
    
    /*
        A um determinado tempo subtrai horas, minutos segundos e milissegundos.
    */
    public LocalTime subtraiTempo(LocalTime time, int horas, int minutos, int segundos, int mili);
    
    /*
        Calcula a diferença entre dois tempos. Resultado é apresentado horas, minutos, segundos e nanossegundos.
    */
    static LocalTime difTime(LocalTime lt1, LocalTime lt2) 
    {
        lt2 = lt2.minusHours(lt1.getHour()).minusMinutes(lt1.getMinute()).minusSeconds(lt1.getSecond()).minusNanos(lt1.getNano());
        
        return lt2;
    }
   
}
