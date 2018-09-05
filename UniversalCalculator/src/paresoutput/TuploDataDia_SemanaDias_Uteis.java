package paresoutput;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class TuploDataDia_SemanaDias_Uteis
{
    private final LocalDate data;
    private final DayOfWeek dia;
    private final int uteis;
    
    public TuploDataDia_SemanaDias_Uteis(LocalDate da, DayOfWeek di, int u)
    {
        data = da;
        dia = di;
        uteis = u;
    }

    public LocalDate getData() {
        return data;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public int getUteis() {
        return uteis;
    }
    
}
