
package queries;

import fusos_horarios.Zone;
import fusos_horarios.ZoneInterface;
import static java.lang.System.out;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;
import java.util.Map;
import paresoutput.FusoHorarioDiferente;
import paresoutput.ParHorasMinutos;
import universalcalculator.Input;

/*
    Queries relativas à funcionalidade Fusos Horários da calculadora universal.
*/

public class QueriesFusos 
{
    /*
        Determina diferença de horas entre datas e tempos em fusos horários diferentes. Apresenta o resultado em horas e
        minutos.
    */
    public static void difHorasFusos()
    {
        ZoneInterface z = new Zone();
        ZonedDateTime zdt1, zdt2;
        zdt1 = Input.getDataTempoFusoInput(false);
        
        if(zdt1!= null)
        {
            out.println("Segunda data:");
            zdt2 = Input.getDataTempoFusoInput(false);
            
            if(zdt2 != null)
            {
                ParHorasMinutos par = z.duracaoFusosDiferentes(zdt1, zdt2);
                out.println(par.getAviso());
                StringBuilder sb = new StringBuilder();
                sb.append("A diferença de tempo entre as duas datas é de ");
                sb.append(par.getHoras()).append(" horas e ");
                sb.append(par.getMins()).append(" minutos.");
                
                out.println(sb.toString());
            }
            
            Input.pressionaEnter();
        }
        
    }
    
    /*
        Dada uma data e uma hora locais, determina a nova data e hora numa zona com fuso horário diferente.
    */
    public static void horaFusoNoutroFuso(boolean horaLocal)
    {
        String zona;
        ZoneInterface z = new Zone();
        ZonedDateTime zdt1;
        zdt1 = Input.getDataTempoFusoInput(horaLocal);
        if(zdt1 != null)
        {
            out.print("Insira o ID da nova zona:");
            zona = Input.lerString();
            
            try 
            {
                String minutos;
                ZoneId zid = z.getZoneId(zona);
                StringBuilder sb = new StringBuilder();
                FusoHorarioDiferente fhd = z.horaFusoHorarioDif(zdt1, zid);
                if(fhd.getMinutos() < 10)
                    minutos = "0" + fhd.getMinutos();
                else 
                    minutos = fhd.getMinutos() + "";
                sb.append("Na zona ")
                .append(zid)
                .append(" são ")
                .append(fhd.getHoras())
                .append(":")
                .append(minutos)
                .append(" de ")
                .append(fhd.getAnos())
                .append("-")
                .append(fhd.getMes())
                .append("-")
                .append(fhd.getDia());
                out.println(sb.toString());
            } 
            catch (ZoneRulesException e) 
            {
                out.println("O id inserido não corresponde a nenhuma zona");
            }
            
            Input.pressionaEnter();
        }
    }
    
    /*
        Dado um offset, determina todas as zonas que partilham o mesmo offset.
    */
    public static void todosIdsOffsets()
    {
        StringBuilder sb = new StringBuilder();
        ZoneInterface z = new Zone();
        String offset;
        out.print("Insira o offset:");
        offset = Input.lerString();
        
        sb.append("As zonas são: ")
          .append("\n");
        
        Map<String, String> zeoff = z.todasZonasEOffSets(offset);
        
        zeoff.forEach((k,v)->out.println(k + ": " + v));
        
        Input.pressionaEnter();
    }
    
    /*
        Indica qual o offset de uma zona.
    */
    public static void offsetZona()
    {
        ZoneInterface z = new Zone();
        String id;
        out.print("Indique o id da zona:");
        id = Input.lerString();
        
        try
        {
            StringBuilder sb = new StringBuilder();
            sb.append("O offset do id ")
                .append(id)
                .append(" é ")
                .append(z.offsetDaZone(id))
                .append(".");
            
            out.println(sb.toString());
        }
        catch(ZoneRulesException e)
        {
            out.println("O id escolhido não existe");
        }
        
        Input.pressionaEnter();
    }
    
    /*
        Determina as zonas disponíveis e os respetivos offsets. Resultado é armazenado no ficheiro zonaseoffsets.txt
        devido à sua dimensão.
    */
    public static void todasZonasEOffSets()
    {
        ZoneInterface z = new Zone();
        
        z.todasZonasEOffSets();
        
        out.println("As zonas e os seus offsets encontram-se no ficheiro zonaseoffsets.txt");
    }
    
    /*
        Indica qual a informação do sistema (data, horas, offset e fuso) constantemente ao utilizador da calculadora universal.
    */
    public static void infoSistemaLocal()
    {
        StringBuilder sb = new StringBuilder();
        ZoneInterface zi = new Zone();
        String offset; 
        
        ZonedDateTime zdt = zi.offsetFusoSistema();
        offset = zdt.getOffset().toString();
        if (offset.equals("Z"))
            offset = "+00:00";
        
        sb.append("\nHoras: ")
          .append(zdt.getHour())
          .append(":")
          .append(zdt.getMinute())
          .append(" | Data: ")
          .append(zdt.getDayOfMonth())
          .append("-")
          .append(zdt.getMonthValue())
          .append("-")
          .append(zdt.getYear())
          .append("(")
          .append(zdt.getDayOfWeek())
          .append(")")
          .append(" | Offset: ")
          .append(offset)
          .append(" | Fuso Horário: ")
          .append(zdt.getZone());
        
        out.println(sb);
    }
}
