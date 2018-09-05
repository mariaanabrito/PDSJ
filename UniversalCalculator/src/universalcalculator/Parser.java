package universalcalculator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.zone.ZoneRulesException;

/*
    Classe Parser é responsável por verificar se os dados são válidos.
*/

public class Parser 
{
    /*
        Verifica se a String passada como parâmetro tem a estrutura correta de uma data. Caso esteja correta, devolve a data,
        caso contrário lança uma exceção.
    */
    public static LocalDate parseStringToDate(String s) throws DateTimeParseException
    {
        return LocalDate.parse(s);
    }
    
    /*
        Verifica se a String passada como parâmetro tem a estrutura correta de um ano. Caso esteja correta, devolve o ano,
        caso contrário lança uma exceção.
    */
    public static Year parseStringToYear(String s) throws DateTimeParseException
    {
        return Year.parse(s);
    }
    
    /*
        Verifica se a String passada como parâmetro tem a estrutura correta de uma data e tempo. Caso esteja correta, devolve 
        a data e tempo, caso contrário lança uma exceção.
    */
    public static LocalDateTime parseStringtoDateTime(String dataHora) throws DateTimeParseException
    {
        return LocalDateTime.parse(dataHora);
    }
    
    /*
        Verifica se a String passada como parâmetro tem a estrutura correta de um tempo. Caso esteja correta, devolve o tempo,
        caso contrário lança uma exceção.
    */
    public static LocalTime parseStringToTime(String hora) throws DateTimeParseException
    {
        return LocalTime.parse(hora);
    }
    
    /*
        Verifica se a String passada como parâmetro tem a estrutura correta de uma data e tempo. Caso esteja correta, 
        devolve a data e tempo num fuso horário, caso contrário lança uma exceção.
    */
    public static ZonedDateTime parseStringtoZonedDateTime(String dataHora, String zona) throws DateTimeParseException, ZoneRulesException
    {
        LocalDateTime dt = LocalDateTime.parse(dataHora);
        ZoneId zoneID = ZoneId.of(zona);
        return ZonedDateTime.of(dt, zoneID);
    }
    
    /*
        Verifica se a String passada como parâmetro tem a estrutura correta de uma data e tempo. Caso esteja correta, 
        devolve a data e tempo no fuso horário local, caso contrário lança uma exceção.
    */
    public static ZonedDateTime parseStringtoZoneDateTimeLocal(String dataHora) throws DateTimeParseException, ZoneRulesException
    {
        LocalDateTime dt = LocalDateTime.parse(dataHora);
        ZoneId zoneID = ZoneId.systemDefault();
        return ZonedDateTime.of(dt, zoneID);
    }

}
