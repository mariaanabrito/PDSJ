package paresoutput;

import java.time.chrono.Era;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class TuploSeculoMilenioEra 
{
    private final long centuries, milenios;
    private final Era era;
    
    public TuploSeculoMilenioEra(long c, long m, Era e) 
    {
        centuries = c;
        milenios = m;
        era = e;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        

        sb.append("Século: ");
        sb.append(centuries).append("\nMilénio: ");
        sb.append(milenios).append("\nEra: ");
        sb.append(era).append(".");
        
        return sb.toString();
    }
}
