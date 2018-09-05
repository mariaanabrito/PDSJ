package cronometro;

import java.time.LocalTime;

/*
    Classe Cronometro corresponde à implementação de cronómetro da calculadora universal. Permite calcular a diferença
    entre dois tempos, a partir dos métodos start e stop.
*/
public class Cronometro implements CronometroInterface
{
    /*
        Quando o utilizador pretende parar a contagem do cronómetro, este método é invocado. Recebendo o tempo inicial 
        calculado em start, determina o tempo final da contagem e calcula a sua diferença.
    */
    @Override
    public LocalTime stop(LocalTime lt)
    {  
       LocalTime fim = LocalTime.now();
       
       fim = fim.minusHours(lt.getHour()).minusMinutes(lt.getMinute()).minusSeconds(lt.getSecond()).minusNanos(lt.getNano());

       return fim;
    }
    
    /*
        Quando o utilizador pretende inicializar o cronómetro, este método é invocado. Determina o tempo inicial da contagem.
    */
    @Override
    public LocalTime start()
    {
        return LocalTime.now();
    }
}
