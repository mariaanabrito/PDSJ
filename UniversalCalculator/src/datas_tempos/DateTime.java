package datas_tempos;

import datas.DateInterface;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import paresoutput.Par_TuploAnosMesesDias_LocalTime;
import tempos.TimeInterface;

/*
    Classe DateTime corresponde ao modo Datas e Tempos da calculadora universal. Permite calcular a diferença entre duas datas e 
    tempos simultaneamente.
*/

public class DateTime implements DateTimeInterface
{
    /*
        Dadas duas datas e tempos, calcula a sua diferença. 
    */
    @Override
    public Par_TuploAnosMesesDias_LocalTime difEntreDateTime(LocalDateTime ldt1, LocalDateTime ldt2)
    {
        
        
        LocalDate date1 = LocalDate.from(ldt1);
        LocalDate date2 = LocalDate.from(ldt2);
        
        LocalTime time1 = LocalTime.from(ldt1);
        LocalTime time2 = LocalTime.from(ldt2);
        
        return new Par_TuploAnosMesesDias_LocalTime(DateInterface.difEntreDatas(date1, date2), TimeInterface.difTime(time1, time2));
 
    }
    
}
