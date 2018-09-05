package fusos_horarios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static universalcalculator.Constants.MINUTES_IN_HOUR;
import java.time.zone.ZoneRulesException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import paresoutput.FusoHorarioDiferente;
import paresoutput.ParHorasMinutos;

/*
    Classe Zone corresponde ao modo Fusos Horários da calculadora universal.
*/

public class Zone implements ZoneInterface{
    
    /*
        Dada uma lista de zonas, determina quais as suas ZoneIds.
    */
    private Map<String, String> getAllZoneIds(List<String> zoneList) 
    {

        Map<String, String> result = new HashMap<>();

        LocalDateTime dt = LocalDateTime.now();

        for (String zoneId : zoneList) {

            ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset zos = zdt.getOffset();

            String offset = zos.getId().replaceAll("Z", "+00:00");

            result.put(zone.toString(), offset);

        }

        return result;

    }
    
    /*
        Dada uma data e uma hora locais, determina a nova data e hora na zona passada como parâmetro.
    */
    @Override
    public FusoHorarioDiferente horaFusoHorarioDif(ZonedDateTime zdt, ZoneId z)
    {
        ZonedDateTime novaZona =  zdt.withZoneSameInstant(z);
        
        return new FusoHorarioDiferente(novaZona.getHour(), novaZona.getMinute(),novaZona.getYear(),novaZona.getMonthValue(),novaZona.getDayOfMonth() );
        
    }
    
    /*
        Indica qual o offset de uma zona passada como parâmetro.
    */
    @Override
    public ZoneOffset offsetDaZone(String zone) throws ZoneRulesException
    {
        ZoneId zoneID = ZoneId.of(zone);

        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(),zoneID);
        return zdt.getOffset();
        
        
    }
    
    /*
        Determina diferença de horas entre datas e tempos em fusos horários diferentes. Apresenta o resultado em horas e 
        minutos.
    */
    @Override
    public ParHorasMinutos duracaoFusosDiferentes(ZonedDateTime d1, ZonedDateTime d2)
    {
        String aviso = "";
        long diffHoras, minTotais, diffMins, diffSeg;
        OffsetDateTime odt = d2.toOffsetDateTime();
        
        ZonedDateTime zdt = odt.atZoneSameInstant(d1.getZone());
        
        
        if(!d1.isBefore(zdt) && !d1.equals(zdt))
        {
            ZonedDateTime aux = d1;
            d1 = zdt;
            zdt = aux;
            aviso = "ATENÇÃO: A segunda data ocorre antes da primeira!\n";
        }
        
        diffHoras = HOURS.between(LocalDateTime.from(d1), LocalDateTime.from(zdt));
        minTotais = MINUTES.between(LocalDateTime.from(d1), LocalDateTime.from(zdt));
        diffMins = minTotais - diffHoras * MINUTES_IN_HOUR;
        diffSeg = HOURS.between(LocalDateTime.from(d1), LocalDateTime.from(zdt));

        
        
        return new ParHorasMinutos(diffHoras, diffMins, aviso);
    }
    
    /*
        Determina a ZoneId de uma dada zona.
    */
    @Override
    public ZoneId getZoneId(String zone) throws ZoneRulesException
    {
        return ZoneId.of(zone);
    }
    
    /*
        Dado um offset, determina todas as zonas que partilham o mesmo offset.
    */
    @Override
    public Map<String, String> todasZonasEOffSets(String s)
    {
        Map<String, String> sortedMap = new LinkedHashMap<>();
        Map<String, String> fim = new LinkedHashMap<>();
        List<String> zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());

        Map<String, String> allZoneIds = getAllZoneIds(zoneList);
        
        allZoneIds.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue().reversed())
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
    
        for(Map.Entry<String,String> e: sortedMap.entrySet())
        {
            if(e.getValue().equals(s))
                fim.put(e.getKey(), e.getValue());
        }
      
         return fim;
    }
    
    /*
        Determina as zonas disponíveis e os respetivos offsets. Resultado é armazenado num ficheiro
        devido à sua dimensão.
    */
    @Override
    public void todasZonasEOffSets()
    {
        File file = new File("zonaseoffsets.txt");
        FileWriter write;
        try {
            file.createNewFile();
            write = new FileWriter(file);
            
            Map<String, String> sortedMap = new LinkedHashMap<>();

            List<String> zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());

            Map<String, String> allZoneIds = getAllZoneIds(zoneList);
        
            allZoneIds.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue().reversed())
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
            
            write.write("As zonas e offsets são: \n");
            write.flush();
            
            for(Map.Entry<String,String> e: sortedMap.entrySet())
            {
                write.write(e.getKey() + ": " + e.getValue()+"\n");
                write.flush();
            }
            write.close();
        } catch (IOException ex) {
            Logger.getLogger(Zone.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /*
        Indica qual a informação do sistema (data, horas, offset e fuso).
    */
    @Override
    public ZonedDateTime offsetFusoSistema()
    {
        return ZonedDateTime.now(ZoneId.systemDefault());
        
    }
}
