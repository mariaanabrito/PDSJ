package paresoutput;

import java.time.LocalTime;

/*
    Dados de output de métodos do modo Datas e Tempos da calculadora universal.
*/
public class Par_TuploAnosMesesDias_LocalTime 
{
    private final LocalTime lTempos;
    private final TuploAnosMesesDias lDatas;
    
    public Par_TuploAnosMesesDias_LocalTime(TuploAnosMesesDias ldt1, LocalTime ldt2)
    {
        lDatas = ldt1;
        lTempos = ldt2;
    }

    public LocalTime getlTempos() {
        return lTempos;
    }

    public TuploAnosMesesDias getlDatas() {
        return lDatas;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append(lDatas)
          .append(" ")
          .append(lTempos);
        
        return sb.toString();
    }
}
