package paresoutput;

/*
    Dados de output de métodos do modo Tempo da calculadora universal.
*/
public class ParHorasMinutos 
{
    public final long horas, mins;
    public final String aviso;

    public ParHorasMinutos(long h, long m, String a) {
        horas = h;
        mins = m;
        aviso = a;
    }

    public String getAviso() {
        return aviso;
    }
    
    public long getHoras() {
        return horas;
    }

    public long getMins() {
        return mins;
    }
}
