package datas;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import java.time.MonthDay;
import java.time.Year;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import paresoutput.ParDataDia;
import paresoutput.ParDataDiaDaSemana;
import paresoutput.ParDataDiaMesAno;
import paresoutput.ParFimDeSemana;
import paresoutput.SalarioAno;
import paresoutput.TuploDataDia_SemanaDias_Uteis;
import paresoutput.TuploSeculoMilenioEra;
import static universalcalculator.Constants.WORKING_DAYS;
import static universalcalculator.Constants.WORKING_HOURS;

/*
    Classe Local_Date corresponde ao modo Data da calculadora universal. Permite fazer operações entre datas, contagens de
    diversos tipos e, também, saber algumas curiosidades relacionadas com datas.
*/

public class Local_Date implements DateInterface
{
    /*
        Calcula o número de dias úteis (isto é, que não sejam fins-de-semana) entre duas datas.
    */
    private int numDiasUteis(LocalDate d1, LocalDate d2)
    {
        int numDiasUteis = 0;
        
        while(d1.isBefore(d2) || d1.isEqual(d2))
        {
            if(!d1.query(UtilsDate::fimDeSemana))
                numDiasUteis++;
            d1 = d1.plusDays(1);
        }
        
        return numDiasUteis;
    }
    
    /*
        Lê as linhas de um ficheiro que correspondem aos nomes e respetivas datas dos feriados nacionais.
        Só se consideram os feriados cuja data não varia de ano para ano.
    */
    private Map<String, MonthDay> readFromFile(String nomeFich) 
    {
      List<String> lines = new ArrayList<>();
      try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
      catch(IOException exc) { System.out.println(exc.getMessage()); }
      
      SortedMap<String, MonthDay> feriados = new TreeMap<>();
    
      for(String s: lines)
      {
          String[] f = s.split("-");
          MonthDay md = MonthDay.of(Integer.parseInt(f[2]), Integer.parseInt(f[1]));
          
          feriados.put(f[0], md);
          
      }
      
      return feriados;
    }
    
    /*
        Dada uma data, determina a sua estação do ano (Primavera, Verão, Outono ou Inverno) de acordo com o hemisfério Norte.
    */
    @Override
    public String estacaoDoAno(LocalDate d) 
    {
        return d.query(UtilsDate::estacaoDoAno);
    }
    
    /*
        Determina o dia da semana do primeiro dia de um ano.
    */
    @Override
    public DayOfWeek primeiroDiaSemanaAno(int ano) 
    {
        LocalDate dt = LocalDate.of(ano, 1, 1);
        return dt.query(UtilsDate::primeiroDiaSemanaAno);
    }
    
    /*
        Determina o dia da semana de uma data.
    */
    @Override
    public DayOfWeek diaDaSemana(LocalDate d) 
    {
        return d.query(UtilsDate::diaDaSemana);
    }
    
    /*
        Determina o dia do ano de uma data (por exemplo, 10/01/2018 corresponde ao 10º dia do ano de 2018).
    */
    @Override
    public int diaDoAno(LocalDate d) 
    {
        return d.query(UtilsDate::diaDoAno);
    }
    
    /*
        Determina em que trimestre do ano uma data se situa.
    */
    @Override
    public int trimestre(LocalDate d)
    {   
        return d.query(UtilsDate::trimestre);
        
    }
    
    /*
        Determina o número de semanas completas entre duas datas, sendo uma delas a atual.
    */
    @Override
    public long numSemanasAteData(LocalDate d) 
    {
        return d.query(UtilsDate::numSemanasAteData);
    }
    
    /*
        Determina se um ano é bissexto ou não.
    */
    @Override
    public boolean anoBissexto(Year ano)
    {
        return ano.query(UtilsDate::anoBissexto);        
    }
    
    /*
        Determina o século, o milénio e a era de uma data.
    */
    @Override
    public TuploSeculoMilenioEra seculoMilenioEraData(LocalDate d)
    {
        return d.query(UtilsDate::seculoMilenioEraData);
    }
    
    /*
        Determina quanto tempo falta até à próxima passagem do cometa Halley. Mostra o resultado em dias totais, meses totais
        e anos totais.
    */
    @Override
    public ParDataDiaMesAno cometaHalley()
    {
        LocalDate atual = LocalDate.now();
        return atual.query(UtilsDate::cometaHalley);
    }
    
    /*
        Determina o número de dias úteis entre duas dadas datas.
    */
    @Override
    public int diasUteisEntreDatas(LocalDate d1, LocalDate d2)
    {
        int numUteis = 0;
        
        while(d1.isBefore(d2) || d1.equals(d2))
        {
            if(!d1.query(UtilsDate::fimDeSemana))
                numUteis++;
            d1 = d1.plus(1, DAYS);
        }
        
        return numUteis;
    }
    
    /*
        Determina quantos fins-de-semanas completos um ano tem. Caso o ano inserido possua um sábado ou um domingo extra, 
        estes também são sinalizados.
    */
    @Override
    public ParFimDeSemana numFinsDeSemanaAno(int ano)
    {
        LocalDate d = LocalDate.of(ano, JANUARY, 1);
        
        return d.query(UtilsDate::numFinsDeSemanaAno);
    }
    
    /*
        Determina quantos dias faltam até ao próximo Natal.
    */
    @Override
    public long diasAteNatal()
    {
        LocalDate d = LocalDate.now();
        return d.query(UtilsDate::numDiasAteNatal);
    }

    /*
        Determina o salário de um indivíduo sabendo quanto ganha por hora e o ano que pretende calcular. Apresenta o resultado
        em dias, semanas, mês e ano.
    */
    @Override
    public SalarioAno salarioDiaMesSemanaAno(float salarioHora, int ano) 
    {
        Map<Month, Float> salariosMes = new TreeMap<>();
        LocalDate inicio, fim ;
        float totalAno = 0.0f;
        float dia, semana;
        dia = salarioHora * WORKING_HOURS;
        semana = dia * WORKING_DAYS;
        
        for(int i = 1; i <= 12; i++)
        {
            inicio = LocalDate.of(ano, i,1);
            if(i+1 == 13)
                fim = LocalDate.of(ano+1, 1, 1);
            else
                fim = LocalDate.of(ano, i+1, 1);
            
            salariosMes.put(inicio.getMonth(), numDiasUteis(inicio, fim) * dia);
            
            totalAno += numDiasUteis(inicio, fim) * dia;
        }
        
        return new SalarioAno(dia, semana, totalAno, salariosMes);
    }
    
    /*
        Determina o número de dias úteis (isto é, que não são fins-de-semana) de um ano.
    */
    @Override
    public int numDiasUteisAno(int ano)
    {
        return numDiasUteis(LocalDate.of(ano, JANUARY, 1), LocalDate.of(ano, DECEMBER, 31));
    }
    
    /*
        Determina em que dias são os fins-de-semana de um dado mês. Por exemplo, em Janeiro de 2018 o primeiro fim-de-semana
        ocorre nos dias 6 (Sábado) e 7 (Domingo).
    */
    @Override
    public Map<Integer, DayOfWeek> finsDeSemanaDoMes(int ano, int mes)
    {
        Map<Integer, DayOfWeek> diasDaSemana = new TreeMap<>();
        LocalDate inicioMes = LocalDate.of(ano, mes, 1);
        LocalDate fimMes;
        if(mes == 12)
            fimMes = LocalDate.of(ano+1, 1, 1);
        else
            fimMes = LocalDate.of(ano, mes+1, 1);
        
        
        
        for(int i = 0, f = 0; inicioMes.isBefore(fimMes); i++)
        {
            if(inicioMes.query(UtilsDate::fimDeSemana))
                diasDaSemana.put(inicioMes.getDayOfMonth(), inicioMes.getDayOfWeek());
                
            inicioMes = inicioMes.plusDays(1);
        }
        
        return diasDaSemana;
    }
    
    /*
        A uma dada data são somados anos, meses, semanas e dias.
    */
    @Override
    public LocalDate somaData(LocalDate d, int ano, int mes, int semanas, int dias)
    {
        return d.plusYears(ano).plusMonths(mes).plusWeeks(semanas).plusDays(dias);
    }
    
    /*
        A uma dada data são subtraidos anos, meses, semanas e dias.
    */
    @Override
    public LocalDate subtraiData(LocalDate d, int ano, int mes, int semanas, int dias)
    {
        return d.minusYears(ano).minusMonths(mes).minusWeeks(semanas).minusDays(dias);
    }
    
    /*
        Calcula a data inserida daqui a um certo número de dias úteis.
    */
    private LocalDate daquiXDiasUteis(LocalDate d, int diasUteis)
    {
        while(diasUteis > 0)
        {
            if(!d.query(UtilsDate::fimDeSemana))
                diasUteis--;
            
            d = d.plusDays(1);
        }
        
        return d;
    }

    /*
        Dado um número de dias, calcula a data daqui a esse número de dias e apresenta ainda qual o dia da semana e quantos
        dias úteis faltam até lá.
    */
    @Override
    public TuploDataDia_SemanaDias_Uteis eventoDaquiXDias(int dias)
    {
        LocalDate agora = LocalDate.now();
    
        LocalDate nova = agora.plusDays(dias);
        DayOfWeek diaDaSemana = nova.query(UtilsDate::diaDaSemana);
        int numDiasUteis = numDiasUteis(agora, nova);
        
       
        
        return new TuploDataDia_SemanaDias_Uteis(nova, diaDaSemana, numDiasUteis);
    }
    
    /*
        Dado um número de dias úteis, calcula a data daqui a esse número de dias e apresenta ainda qual o dia da semana.
    */
    @Override 
    public ParDataDiaDaSemana eventoDaquiXDiasUteis(int dias)
    {
        LocalDate agora = LocalDate.now();
        LocalDate nova = daquiXDiasUteis(agora, dias);
        DayOfWeek diaDaSemana = nova.query(UtilsDate::diaDaSemana);
        
        
        
        return new ParDataDiaDaSemana(nova, diaDaSemana);
    }
    
    /*
        Determina qual a data da próxima Black Friday e quantos dias faltam até essa data.
    */
    @Override
    public ParDataDia proxBlackFriday()
    {
        LocalDate d = LocalDate.now();
        return d.query(UtilsDate::proxBlackFriday);
    }

    /*
        Para um dado ano apresenta a data dos feriados nacionais e em que dia da semana ocorrem.
    */
    @Override
    public Map<String, MonthDay> dataFeriadosNacionais(int ano)
    {
        
        String file = "feriadosnacionais.txt";
        Map<String, MonthDay> feriados = readFromFile(file);
        return feriados;
        
    }
    
    /*
        Calcula a data da Páscoa de um determinado ano.
    */
    @Override
    public LocalDate proxPascoa(int ano)
    {
        LocalDate d = LocalDate.of(ano, 1, 1);
        return d.query(UtilsDate::proxPascoa);
    }
}
