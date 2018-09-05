package paresoutput;

import java.time.LocalDate;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class ParDataDia 
{
    private final LocalDate blackFriday;
    private final long dias;
    
    public ParDataDia(LocalDate bf, long d)
    {
        blackFriday = bf;
        dias = d;
    }
    
    public LocalDate getData()
    {
        return blackFriday;
    }
    
    public long getDias()
    {
        return dias;
    }
}
