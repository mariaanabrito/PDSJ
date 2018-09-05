package tempos;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import static universalcalculator.Constants.BOLT_RECORD;

/*
    Classe UtilsTime engloba o método utilitário auxiliar do modo Tempo da calculadora universal.
*/
public class UtilsTime 
{
    /*
        Determina a diferença entre o record de 100 m de Usain Bolt obtido a 16 de Agosto de 2009 em Berlim e o tempo passado
        como parâmetro.
    */
    public static Duration quantoTempoSouMaisLentoQueBolt(TemporalAccessor time)
    {
        LocalTime t = LocalTime.from(time);
        
        return Duration.between(BOLT_RECORD, t);
    }
}
