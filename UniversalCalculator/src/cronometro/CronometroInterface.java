package cronometro;

import java.time.LocalTime;

/*
    Funcionalidades do modo Cronometro.
*/

public interface CronometroInterface 
{
    /*
        Quando o utilizador pretende parar a contagem do cronómetro, este método é invocado. Recebendo o tempo inicial 
        calculado em start, determina o tempo final da contagem e calcula a sua diferença.
    */
    public LocalTime stop(LocalTime lt);
    
    /*
        Quando o utilizador pretende inicializar o cronómetro, este método é invocado. Determina o tempo inicial da contagem.
    */
    public LocalTime start();
}
