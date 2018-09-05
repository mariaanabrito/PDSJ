package universalcalculator;

import static java.lang.Math.pow;
import java.time.LocalTime;

/*
    Constantes diversas que são utilizadas ao longo do projeto.
*/

public interface Constants 
{
    /*
        Quantos minutos existem em uma (1) hora.
    */
    public static final int MINUTES_IN_HOUR = 60;
    
    /*
        Número de horas de trabalho diárias.
    */
    public static final int WORKING_HOURS = 8;
    
    /*
        Número de dias úteis em uma (1) semana.
    */
    public static final int WORKING_DAYS = 5;
    
    /*
        Número de meses em um (1) ano.
    */
    public static final int MONTHS_IN_YEAR = 12;
    
    /*
        Número máximo de semanas que um (1) mês pode ter.
    */
    public static final int MAX_WEEKS_IN_MONTH=5;
    
    /*
        Número de milissegundos em um (1) nanossegundo.
    */
    public static final double MILLISECONDS_IN_NANO = pow(10,-6);
    
    /*
        Record de 100 m de Usain Bolt obtido a 16 de Agosto de 2009 em Berlim
    */
    public static final LocalTime BOLT_RECORD = LocalTime.of(0, 0, 9, 580000000);
    
}
