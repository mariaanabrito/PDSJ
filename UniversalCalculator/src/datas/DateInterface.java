package datas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.Map;
import paresoutput.ParDataDia;
import paresoutput.ParDataDiaDaSemana;
import paresoutput.ParDataDiaMesAno;
import paresoutput.ParFimDeSemana;
import paresoutput.SalarioAno;
import paresoutput.TuploAnosMesesDias;
import paresoutput.TuploDataDia_SemanaDias_Uteis;
import paresoutput.TuploSeculoMilenioEra;

/*
    Funcionalidades do modo Data da calculadora universal.
*/

public interface DateInterface 
{
    /*
        Dada uma data, determina a sua estação do ano (Primavera, Verão, Outono ou Inverno) de acordo com o hemisfério Norte.
    */
    public String estacaoDoAno(LocalDate d);
    
    /*
        Determina o dia da semana do primeiro dia de um ano.
    */
    public DayOfWeek primeiroDiaSemanaAno(int ano);
    
    /*
        Determina o dia da semana de uma data.
    */
    public DayOfWeek diaDaSemana(LocalDate d);
    
    /*
        Determina o dia do ano de uma data (por exemplo, 10/01/2018 corresponde ao 10º dia do ano de 2018).
    */
    public int diaDoAno(LocalDate d);
    
    /*
        Determina em que trimestre do ano uma data se situa.
    */
    public int trimestre(LocalDate d);
    
    /*
        Determina o número de semanas completas entre duas datas, sendo uma delas a atual.
    */
    public long numSemanasAteData(LocalDate d);
    
    /*
        Determina se um ano é bissexto ou não.
    */
    public boolean anoBissexto(Year ano);
    
    /*
        Determina o século, o milénio e a era de uma data.
    */
    public TuploSeculoMilenioEra seculoMilenioEraData(LocalDate d);
    
    /*
        Determina quanto tempo falta até à próxima passagem do cometa Halley. Mostra o resultado em dias totais, meses totais
        e anos totais.
    */
    public ParDataDiaMesAno cometaHalley();
    
    /*
        Determina o número de dias úteis entre duas dadas datas.
    */
    public int diasUteisEntreDatas(LocalDate d1, LocalDate d2);
    
    /*
        Determina quantos fins-de-semanas completos um ano tem. Caso o ano inserido possua um sábado ou um domingo extra, 
        estes também são sinalizados.
    */
    public ParFimDeSemana numFinsDeSemanaAno(int ano);
    
    /*
        Determina quantos dias faltam até ao próximo Natal.
    */
    public long diasAteNatal();
    
    /*
        Determina o salário de um indivíduo sabendo quanto ganha por hora e o ano que pretende calcular. Apresenta o resultado
        em dias, semanas, meses e ano.
    */
    public SalarioAno salarioDiaMesSemanaAno(float salarioHora, int ano); 
    
    /*
        Determina o número de dias úteis (isto é, que não são fins-de-semana) de um ano.
    */
    public int numDiasUteisAno(int ano);
    
    /*
        Determina em que dias são os fins-de-semana de um dado mês. Por exemplo, em Janeiro de 2018 o primeiro fim-de-semana
        ocorre nos dias 6 (Sábado) e 7 (Domingo).
    */
    public Map<Integer, DayOfWeek> finsDeSemanaDoMes(int ano, int mes);
    
    /*
        A uma dada data são somados anos, meses, semanas e dias.
    */
    public LocalDate somaData(LocalDate d, int ano, int mes, int semanas, int dias);
    
    /*
        A uma dada data são subtraidos anos, meses, semanas e dias.
    */
    public LocalDate subtraiData(LocalDate d, int ano, int mes, int semanas, int dias);
    
    /*
        Dado um número de dias, calcula a data daqui a esse número de dias e apresenta ainda qual o dia da semana e quantos
        dias úteis faltam até lá.
    */
    public TuploDataDia_SemanaDias_Uteis eventoDaquiXDias(int dias);
    
    /*
        Dado um número de dias úteis, calcula a data daqui a esse número de dias e apresenta ainda qual o dia da semana.
    */
    public ParDataDiaDaSemana eventoDaquiXDiasUteis(int dias);
    
    /*
        Determina qual a data da próxima Black Friday e quantos dias faltam até essa data.
    */
    public ParDataDia proxBlackFriday();
    
    /*
        Calcula a data da Páscoa de um determinado ano.
    */
    public LocalDate proxPascoa(int ano);
    
    /*
        Para um dado ano apresenta a data dos feriados nacionais e em que dia da semana ocorrem.
    */
    public Map<String, MonthDay> dataFeriadosNacionais(int ano);
    
    /*
        Calcula a diferença entre duas datas. Apresenta o resultado em anos, meses e dias. Por exemplo, de 01/01/2018 até 
        10/02/2018 existe uma diferença de 0 anos, 1 mês e 9 dias.
    */
    public static TuploAnosMesesDias difEntreDatas(LocalDate d1, LocalDate d2)
    {      
        boolean stop = false;
        boolean stop2 = false;
        long dias;
        int meses;
        int anos;
        
        anos = 0;
        meses = 0;
        dias = 0;

        while((d1.getYear() != d2.getYear() || d1.getMonthValue() != d2.getMonthValue())&&!stop && !stop2)
        {
            
            
            while(d1.getMonthValue() != d2.getMonthValue() && !stop2)
            {
                if(d1.getYear() == (d2.getYear() - 1) && d1.getMonthValue() == 12 && d2.getMonthValue() == 1 && d2.getDayOfMonth() < d1.getDayOfMonth())
                {
                    stop2 = true;
                    dias = 31 - d1.getDayOfMonth() + d2.getDayOfMonth();
                }
                if(stop2 == false)
                {
                    YearMonth anoMes = YearMonth.of(d1.getYear(), d1.getMonth());
                    int daysInMonth = anoMes.lengthOfMonth(); 

                    if(((d2.getYear() - d1.getYear()) == 0) 
                            &&((d2.getMonthValue() - d1.getMonthValue()) == 1)
                                &&(d1.getDayOfMonth() > d2.getDayOfMonth()))
                    {

                        dias = d2.getDayOfMonth() + daysInMonth - d1.getDayOfMonth();  
                        stop = true;
                        break;
                    }

                    meses++;

                    d1 = d1.plusMonths(1);
                }
            }
            if(stop2 == false)
            {
                if(d1.getMonthValue() == d2.getMonthValue() && d1.getYear() !=d2.getYear())
                {
                    meses++;
                    d1 = d1.plusMonths(1);
                }
            }
        }
            
        if(d1.getMonthValue() == d2.getMonthValue())
        {
            dias = d2.getDayOfMonth() - d1.getDayOfMonth();
        }

        while(meses > 12)
        {
            anos++;
            meses-=12;
        }
        
        return new TuploAnosMesesDias(anos, meses, dias);
        
    }
}
