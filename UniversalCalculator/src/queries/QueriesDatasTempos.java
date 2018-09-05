package queries;

import datas_tempos.DateTime;
import datas_tempos.DateTimeInterface;
import static java.lang.System.out;
import java.time.LocalDateTime;
import paresoutput.Par_TuploAnosMesesDias_LocalTime;
import universalcalculator.Input;

/*
    Queries relativas à funcionalidade Datas e Tempos da calculadora universal.
*/

public class QueriesDatasTempos 
{
    /*
        calcula a sua diferença entre duas datas e tempos. 
    */
    public static void difDatasTempos()
    {
        DateTimeInterface dti = new DateTime();
        out.println("Aviso: é necessário que a primeira data e tempo sejam inferiores ao segundos!");
        LocalDateTime ldt1, ldt2;
        ldt1= Input.getDataTempoInput();
        
        if(ldt1 != null)
        {
            out.println("Segunda data:");
            ldt2 = Input.getDataTempoInput();
            if(ldt2 != null)
            {
                
                if(ldt1.isBefore(ldt2))
                {
                    StringBuilder sb = new StringBuilder();
                    Par_TuploAnosMesesDias_LocalTime tri = dti.difEntreDateTime(ldt1, ldt2);
                    sb.append("A diferença é de ")
                            .append(tri.getlDatas().getAnos()).append(" anos, ")
                            .append(tri.getlDatas().getMeses()).append(" meses, ")
                            .append(tri.getlDatas().getDias()).append(" dias, ")
                            .append(tri.getlTempos().getHour()).append(" horas, ")
                            .append(tri.getlTempos().getMinute()).append(" minutos, ")
                            .append(tri.getlTempos().getSecond()).append(" segundos.");
                    out.println(sb.toString());
                    Input.pressionaEnter();
                }
                else
                {
                    out.println("A primeira data ocorre depois da segunda!");
                }
            }
        }
    }
}
