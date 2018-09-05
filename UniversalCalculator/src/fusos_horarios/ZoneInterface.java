package fusos_horarios;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;
import java.util.Map;
import paresoutput.FusoHorarioDiferente;
import paresoutput.ParHorasMinutos;

/*
    Funcionalidades do modo Fusos Horários da calculadora universal.
*/
public interface ZoneInterface {
    /*
        Dada uma data e uma hora locais, determina a nova data e hora na zona passada como parâmetro.
    */
    public FusoHorarioDiferente horaFusoHorarioDif(ZonedDateTime zdt, ZoneId z);
    
    /*
        Indica qual o offset de uma zona passada como parâmetro.
    */
    public ZoneOffset offsetDaZone(String zone);
    
    /*
        Determina diferença de horas entre datas e tempos em fusos horários diferentes. Apresenta o resultado em horas e
        minutos.
    */
    public ParHorasMinutos duracaoFusosDiferentes(ZonedDateTime d1, ZonedDateTime d2);
    
    /*
        Determina a ZoneId de uma dada zona.
    */
    public ZoneId getZoneId(String zone) throws ZoneRulesException;
    
    /*
        Dado um offset, determina todas as zonas que partilham o mesmo offset.
    */
    public Map<String, String> todasZonasEOffSets(String s);
    
    /*
        Determina as zonas disponíveis e os respetivos offsets. Resultado é armazenado num ficheiro
        devido à sua dimensão.
    */
    public void todasZonasEOffSets();
    
    /*
        Indica qual a informação do sistema (data, horas, offset e fuso).
    */
    public ZonedDateTime offsetFusoSistema();
}
