package paresoutput;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class TuploAnosMesesDias
{
    private final long anos, meses, dias;
    
    public TuploAnosMesesDias(long a, long m, long d)
    {
        anos = a;
        meses = m;
        dias = d;
    }

    public long getAnos() {
        return anos;
    }

    public long getMeses() {
        return meses;
    }

    public long getDias() {
        return dias;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(anos).append("-").append(meses).append("-").append(dias);
        return sb.toString();
    }
}
