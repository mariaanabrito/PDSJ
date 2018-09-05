package tempos;

import java.time.Duration;
import java.time.LocalTime;
import static universalcalculator.Constants.MILLISECONDS_IN_NANO;

/*
    Classe Time corresponde ao modo Tempo da calculadora universal. Permite fazer operações com tempos.
*/
public class Time implements TimeInterface
{
    /*
        Determina a diferença entre o record de 100 m de Usain Bolt obtido a 16 de Agosto de 2009 em Berlim e o tempo passado
        como parâmetro.
    */
    @Override
    public Duration quantoTempoSouMaisLentoQueBolt(LocalTime time)
    {
        Duration tempo =  time.query(UtilsTime::quantoTempoSouMaisLentoQueBolt);
        
        return tempo;
    }
    
    /*
        A um determinado tempo soma horas, minutos segundos e milissegundos.
    */
    @Override
    public LocalTime somaTempo(LocalTime time, int horas, int minutos, int segundos, int mili)
    {
        int nano = (int) (mili * MILLISECONDS_IN_NANO);
        time = time.plusHours(horas).plusMinutes(minutos).plusSeconds(segundos).plusNanos(nano);
        return time;
    }
    
    /*
        A um determinado tempo subtrai horas, minutos segundos e milissegundos.
    */
    @Override
    public LocalTime subtraiTempo(LocalTime time, int horas, int minutos, int segundos, int mili)
    {
        int nano = (int) (mili * MILLISECONDS_IN_NANO);
        time = time.minusHours(horas).minusMinutes(minutos).minusSeconds(segundos).minusNanos(nano);
        return time;
    }
  
}
