package paresoutput;

import java.time.LocalDate;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class ParDataDiaMesAno 
{
    private final LocalDate ld;
    private final long dias, meses, anos;
    public ParDataDiaMesAno(LocalDate p, long d, long m, long a) 
    {
        ld = p;
        dias = d;
        meses = m;
        anos = a;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: ").append(ld).append("\n");
        sb.append("Dias restantes: ").append(dias).append("\n");
        sb.append("Meses restantes: ").append(meses).append("\n");
        sb.append("Anos restantes: ").append(anos);
        return sb.toString();
    }
}
