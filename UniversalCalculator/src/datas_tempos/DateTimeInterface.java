package datas_tempos;

import java.time.LocalDateTime;
import paresoutput.Par_TuploAnosMesesDias_LocalTime;

/*
    Funcionalidade do modo Datas e Tempos da calculadora universal.
*/

public interface DateTimeInterface 
{
    /*
        Dadas duas datas e tempos, calcula a sua diferença. 
    */
    public Par_TuploAnosMesesDias_LocalTime difEntreDateTime(LocalDateTime ldt1, LocalDateTime ldt2);
    
}
