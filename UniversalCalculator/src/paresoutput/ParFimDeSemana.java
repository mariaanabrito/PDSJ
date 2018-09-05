package paresoutput;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class ParFimDeSemana 
{
    private final long numWeeks;
    private final boolean sabado, domingo;
    
    public ParFimDeSemana(long n, boolean s, boolean d) 
    {
        numWeeks = n;
        sabado = s;
        domingo = d;
    }

    public long getNumWeeks() {
        return numWeeks;
    }

    public boolean isSabado() {
        return sabado;
    }

    public boolean isDomingo() {
        return domingo;
    }
    
    
}
