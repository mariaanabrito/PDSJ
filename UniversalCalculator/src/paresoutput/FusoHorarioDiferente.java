package paresoutput;

/*
    Dados de output de métodos do modo Fusos Horários da calculadora universal.
*/
public class FusoHorarioDiferente 
{
    private final int horas, minutos, anos, mes, dia;

    public FusoHorarioDiferente(int h, int m, int a, int me, int d) {
        horas = h;
        minutos = m;
        anos = a;
        mes = me;
        dia = d;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getAnos() {
        return anos;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }
}
