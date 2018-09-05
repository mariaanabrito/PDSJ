package datas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import static java.time.temporal.ChronoField.YEAR;
import static java.time.temporal.IsoFields.QUARTER_OF_YEAR;
import static java.time.temporal.ChronoUnit.WEEKS;
import static java.time.temporal.ChronoUnit.CENTURIES;
import static java.time.temporal.ChronoUnit.MILLENNIA;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JULY;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.Month.DECEMBER;
import static java.time.Month.NOVEMBER;
import java.time.Year;
import java.time.chrono.Era;
import paresoutput.ParDataDia;
import paresoutput.ParDataDiaMesAno;
import paresoutput.ParFimDeSemana;
import paresoutput.TuploSeculoMilenioEra;

/*
    Classe UtilsDate engloba os métodos utilitários que auxiliam as funcionalidades do modo Data da calculadora universal.
*/

public class UtilsDate
{
    /*
        Dada uma data, determina a sua estação do ano (Primavera, Verão, Outono ou Inverno) de acordo com o hemisfério Norte.
    */
    public static String estacaoDoAno(TemporalAccessor date)
    {
        String estacao = "";
        int ano = date.get(YEAR);
    
        LocalDate atual = LocalDate.from(date);
        LocalDate inicioPrimavera = LocalDate.of(ano, 3, 21);
        LocalDate inicioVerao = LocalDate.of(ano, 6, 21);
        LocalDate inicioOutono = LocalDate.of(ano, 9, 21);
        LocalDate inicioInverno = LocalDate.of(ano, 12, 21);
        
        if((atual.isAfter(inicioPrimavera)  && atual.isBefore(inicioVerao)) || atual.isEqual(inicioPrimavera))
            estacao = "Primavera";
        else if(( atual.isAfter(inicioVerao)  && atual.isBefore(inicioOutono)) || atual.isEqual(inicioVerao))
            estacao = "Verão";
        else if(( atual.isAfter(inicioOutono)  && atual.isBefore(inicioInverno)) || atual.isEqual(inicioOutono))
            estacao = "Outono";
        else 
            estacao = "Inverno";
        
        return estacao;
    }
    
    /*
        Determina o dia da semana do primeiro dia de um ano.
    */
    public static DayOfWeek primeiroDiaSemanaAno(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        return dt.getDayOfWeek();
    }
    
    /*
        Determina o dia da semana de uma data.
    */
    public static DayOfWeek diaDaSemana(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        return dt.getDayOfWeek();
    }
    
    /*
        Determina o dia do ano de uma data (por exemplo, 10/01/2018 corresponde ao 10º dia do ano de 2018).
    */
    public static int diaDoAno(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        return dt.getDayOfYear();
    }
    
    /*
        Determina em que trimestre do ano uma data se situa.
    */
    public static int trimestre(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        return dt.get(QUARTER_OF_YEAR);
    }
    
    /*
        Determina o número de semanas completas entre duas datas, sendo uma delas a atual.
    */
    public static long numSemanasAteData(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        LocalDate atual = LocalDate.now();
        
        return atual.until(dt, WEEKS);
    }
    
    /*
        Determina se um ano é bissexto ou não.
    */
    public static boolean anoBissexto(TemporalAccessor date)
    {
        Year y = Year.from(date);
        return y.isLeap();
    }
    
    /*
        Determina o século, o milénio e a era de uma data.
    */
    public static TuploSeculoMilenioEra seculoMilenioEraData(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        long centuries = CENTURIES.between(LocalDate.of(0,1,1), dt) + 1;
        long milenios = MILLENNIA.between(LocalDate.of(0,1,1), dt);
        Era era = dt.getEra();
        
        return new TuploSeculoMilenioEra(centuries, milenios, era);
    }
    
    /*
        Determina quanto tempo falta até à próxima passagem do cometa Halley. Mostra o resultado em dias totais, meses totais
        e anos totais.
    */
    public static ParDataDiaMesAno cometaHalley(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        StringBuilder sb = new StringBuilder();
        LocalDate ultimaAparicao = LocalDate.of(1986, FEBRUARY, 9);
        LocalDate proxAparicao = LocalDate.of(2061, JULY, 28);
        long diff = DAYS.between(ultimaAparicao, proxAparicao);
        
        
        long dias = diff;
        long meses = MONTHS.between(ultimaAparicao, proxAparicao);
        long anos = YEARS.between(ultimaAparicao, proxAparicao);
        
        return new ParDataDiaMesAno(proxAparicao, dias, meses, anos);
    }
    
    /*
        Determina se uma data corresponde a um dia do fim-de-semana (Sábado ou Domingo).
    */
    public static boolean fimDeSemana(TemporalAccessor date)
    {
        LocalDate d = LocalDate.from(date);
        
        DayOfWeek dia = d.getDayOfWeek();
        
        return dia.equals(SATURDAY)||dia.equals(SUNDAY);
    }
    
    /*
        Determina quantos fins-de-semanas completos um ano tem. Caso o ano inserido possua um sábado ou um domingo extra, 
        estes também são sinalizados.
    */
    public static ParFimDeSemana numFinsDeSemanaAno(TemporalAccessor date)
    {
        boolean sabado, domingo;
        LocalDate inicio = LocalDate.from(date);
        int ano = inicio.getYear();
        LocalDate fim = LocalDate.of(ano, DECEMBER, 31);
        
        long numWeeks = WEEKS.between(inicio, fim);
        sabado = domingo = false;
        if(!inicio.isLeapYear())
        {
            if(inicio.getDayOfWeek().equals(SATURDAY))
                sabado = true;
            else if(inicio.getDayOfWeek().equals(SUNDAY))
               domingo = true;
        }
        return new ParFimDeSemana(numWeeks, sabado, domingo);
    }
    
    /*
        Determina quantos dias faltam até ao próximo Natal.
    */
    public static long numDiasAteNatal(TemporalAccessor date)
    {
        
        int ano = date.get(YEAR);
        LocalDate ld = LocalDate.from(date);
        LocalDate natal = LocalDate.of(ano, 12, 25);
        
        if(ld.isAfter(natal))
            natal = LocalDate.of(ano+1, 12, 25);
        
        return DAYS.between(ld, natal);
        
    }
    
    /*
        Calcula a data inserida daqui a um (1) mês.
    */
    public static LocalDate daquiUmMes(TemporalAccessor date)
    {
       LocalDate d = LocalDate.from(date);
       d = d.plusMonths(1);
    
       return d;
    }
    
    /*
        Determina qual a data da próxima Black Friday e quantos dias faltam até essa data.
    */
    public static ParDataDia proxBlackFriday(TemporalAccessor date)
    {
        LocalDate d = LocalDate.from(date);
        LocalDate blackfriday = LocalDate.of(d.getYear(), NOVEMBER, 1);
        int nQuintas = 0;
        long dias;
        StringBuilder sb = new StringBuilder();
        
        while(nQuintas < 4)
        {  
            if(blackfriday.getDayOfWeek() == THURSDAY)
                nQuintas++;
            blackfriday = blackfriday.plusDays(1);
        }
        
        if(d.isAfter(blackfriday) || d.isEqual(blackfriday))
        {
            nQuintas = 0;
            blackfriday = LocalDate.of(d.getYear()+1, NOVEMBER, 1);
            while(nQuintas < 4)
            {
                if(blackfriday.getDayOfWeek() == THURSDAY)
                        nQuintas++;
                blackfriday = blackfriday.plusDays(1);
            }
        }
         
        dias = DAYS.between(d, blackfriday);
        
        return new ParDataDia(blackfriday, dias);
        
    }
    
    /*
        Determina a data da Páscoa de um dado ano. Tem em atenção os casos especiais dos anos de 2049 e 2076.
    */
    private static LocalDate calculoPascoa(int ano)
    {
        LocalDate pascoa;
        int dia, mes;
        int a, b, c, d, e, x, y;
        
        if(ano >= 1582 && ano <= 1699)
        {
            x = 22;
            y = 2;
        }
        else if(ano >= 1700 && ano <= 1799)
        {
            x = 23;
            y = 3;
        }
        else if(ano >= 1800 && ano <= 1899)
        {
            x = 23;
            y = 4;
        }
        else if(ano >= 1900 && ano <= 2099)
        {
            x = 24;
            y = 5;
        }
        else if(ano >= 2100 && ano <= 2199)
        {
            x = 24;
            y = 6;
        }
        else 
        {
            x = 25;
            y = 7;
        }
        
        a = ano%19;
        b = ano%4;
        c = ano%7;
        d = ((19*a)+x)%30;
        e = ((2*b)+(4*c)+(6*d)+y)%7;
        
        if(d+e < 10)
        {
            dia = d + e + 22;
            mes = 3;
        }
        else
        {
            dia = d + e - 9;
            mes = 4;
        }
        
        
        if(dia == 26 && mes == 4)
            pascoa = LocalDate.of(ano, mes, 19);
        else if(dia == 25 && mes == 4 && d == 28 && a>10)
                pascoa = LocalDate.of(ano, mes, 18);
        else pascoa = LocalDate.of(ano, mes, dia);
        
        return pascoa;
    }
    
    /*
        Calcula a data da Páscoa.
    */
    public static LocalDate proxPascoa(TemporalAccessor date)
    {
        LocalDate dt = LocalDate.from(date);
        int ano = dt.getYear();
        LocalDate pascoa;
        
        pascoa = calculoPascoa(ano);
        
        if (dt.isAfter(pascoa))
            pascoa = calculoPascoa(ano+1);
        
        return pascoa;
    }
}
