package paresoutput;

import java.time.Month;
import java.util.Map;

/*
    Dados de output de métodos do modo Data da calculadora universal.
*/
public class SalarioAno 
{
    private final float dia, semana, ano;
    private final Map<Month, Float> salarioMes;
    
    public SalarioAno(float d, float s, float a, Map<Month, Float> sm)
    {
        dia = d;
        semana = s;
        ano = a;
        salarioMes = sm;
    }

    public float getDia() {
        return dia;
    }

    public float getSemana() {
        return semana;
    }

    public float getAno() {
        return ano;
    }

    public Map<Month, Float> getSalarioMes() {
        return salarioMes;
    }
    
}
