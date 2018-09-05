package paresoutput;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class ParDataDiaDaSemana 
{
    private final LocalDate blackFriday;
    private final DayOfWeek dia;
    
    public ParDataDiaDaSemana(LocalDate bf, DayOfWeek d)
    {
        blackFriday = bf;
        dia = d;
    }
    
    public LocalDate getData()
    {
        return blackFriday;
    }
    
    public DayOfWeek getDias()
    {
        return dia;
    }
}
