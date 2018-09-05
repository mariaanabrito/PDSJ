package queries;

import datas.DateInterface;
import datas.Local_Date;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.Map;
import paresoutput.ParDataDia;
import paresoutput.ParDataDiaDaSemana;
import paresoutput.ParFimDeSemana;
import paresoutput.SalarioAno;
import paresoutput.TuploAnosMesesDias;
import paresoutput.TuploDataDia_SemanaDias_Uteis;
import universalcalculator.Input;
import universalcalculator.Parser;

/*
    Queries relativas à funcionalidade Data da calculadora universal.
*/

public class QueriesDatas 
{
    /*
        Calcula a diferença entre duas datas. Apresenta o resultado em anos, meses e dias. Por exemplo, de 01/01/2018 até 
        10/02/2018 existe uma diferença de 0 anos, 1 mês e 9 dias.
    */
    public static void diferencaEntreDuasDatas()
    {
        LocalDate d1, d2, aux;
        d1 = Input.getDataInput();
        if(d1 != null)
        {
            out.println("Segunda data:");
            d2 = Input.getDataInput();

            if(d2 != null)
            {
                StringBuilder sb = new StringBuilder();
                
                if(d1.isAfter(d2))
                {
                    aux = d2;
                    d2 = d1;
                    d1 = aux;
                }
                
                TuploAnosMesesDias tri = DateInterface.difEntreDatas(d1, d2);
                sb.append("A diferença é de ")
                  .append(tri.getAnos())
                  .append(" anos, ")
                  .append(tri.getMeses())
                  .append(" meses e ")
                  .append(tri.getDias())
                  .append(" dias.");
                out.println(sb.toString());
            
                Input.pressionaEnter();
            }
        }
    }
    
    /*
        O utilizador pode escolher entre somar ou subtrair datas. Assim, a uma dada data são somados ou subtraidos anos, 
        meses, semanas e dias.
    */
    public static void operacoesDatas()
    {
        int soma;
        String op = "somar:";
        int anos, meses, semanas, dias;
        DateInterface d = new Local_Date();
        
        LocalDate dl;
        out.print("Insira 0 se quiser somar e 1 se quiser subtrair:");
        soma = Input.lerInt();
        
        if(soma == 0 || soma == 1)
        {
            if(soma == 1)
                op = "subtrair:";
            dl = Input.getDataInput();

            out.print("Insira o número de anos a " + op);
            anos = Input.lerInt();
            out.print("Insira o número de meses a " + op);
            meses = Input.lerInt();
            out.print("Insira o número de semanas a " + op);
            semanas = Input.lerInt();
            out.print("Insira o número de dias a " + op);
            dias = Input.lerInt();

            if(anos <0 || meses < 0 || semanas < 0 || dias < 0)
                out.println("Insira valores positivos!");
            else if(dl != null)
            {
                out.print("A data resultante é: ");
                if(soma == 0)
                    out.println(d.somaData(dl, anos, meses, semanas, dias).toString());
                else
                    out.println(d.subtraiData(dl, anos, meses, semanas, dias).toString());
            }

            Input.pressionaEnter();
        }
        else
            out.println("Opção inválida!");
    }
    
    /*
        Determina se um ano é bissexto ou não.
    */
    public static void anoBissexto()
    {
        DateInterface d = new Local_Date();
        boolean bissexto;
        Year ano;
        out.print("Insira o ano:");
        try 
        {
            ano = Parser.parseStringToYear(Input.lerString());
            bissexto = d.anoBissexto(ano);
            
            StringBuilder sb = new StringBuilder();
            sb.append("O ano ").append(ano.getValue());
            if(!bissexto)
             sb.append( " não");
            sb.append(" é bissexto");
            
            out.println(sb);
            
        } catch (DateTimeParseException e) 
        {
            out.println("Ano inválido!");
        }
        Input.pressionaEnter();
                
    }
    
    /*
        Determina a estação do ano (Primavera, Verão, Outono ou Inverno) de uma data de acordo com o hemisfério Norte.
    */
    public static void estacaoDoAno()
    {
        DateInterface d = new Local_Date();
        
        LocalDate dl;
        dl = Input.getDataInput();
        
        if(dl != null)
            out.println(d.estacaoDoAno(dl));
        
        Input.pressionaEnter();
    }
    
    /*
        Determina o número de dias úteis entre duas datas.
    */
    public static void diasUteisEntreDatas()
    {
        DateInterface d = new Local_Date();
        LocalDate d1, d2, aux;
        d1 = Input.getDataInput();
        if(d1 != null)
        {
            out.println("Segunda data:");
            d2 = Input.getDataInput();

            if(d2 != null)
            {
                if(d1.isAfter(d2))
                {
                    aux = d2;
                    d2 = d1;
                    d1 = aux;
                }
                out.print("Existem ");
                out.println(d.diasUteisEntreDatas(d1, d2) + " dias úteis entre as duas datas.");
            }
            Input.pressionaEnter();
        }
    }
    
    /*
        Determina quantos fins-de-semanas completos um ano tem. Caso o ano possua um sábado ou um domingo extra (ou seja, 
        fins-de-semana não completos), estes também são sinalizados.
    */
    public static void numFinsDeSemanaAno()
    {
        int ano;
        DateInterface d = new Local_Date();
        
        out.print("Insira o ano:");
        ano = Input.lerInt();
        
        if(ano < 0)
            out.println("Insira um valor positivo!");
        else
        {
            ParFimDeSemana par = d.numFinsDeSemanaAno(ano);
            StringBuilder sb = new StringBuilder();
            sb.append("O ano ").append(ano).append(" tem ").append(par.getNumWeeks());
            if(par.isSabado())
                sb.append(" fins-de-semana e um sábado extra.");
            else if (par.isDomingo())
                    sb.append(" fins-de-semana e um domingo extra.");
            else
                sb.append(" fins-de-semana completos.");
            
            out.println(sb.toString());
        }
        Input.pressionaEnter();
    }
    
    /*
        Determina o número de semanas completas entre duas datas.
    */
    public static void numSemanasAteData()
    {
        DateInterface d = new Local_Date();
        LocalDate d1;
        d1 = Input.getDataInput();

        if(d1 != null )
        {
            out.print("Faltam ");
            out.print(d.numSemanasAteData(d1));
            out.println(" semanas completas.");
        }
        Input.pressionaEnter();
    }
    
    /*
        Determina o dia da semana de uma data.
    */
    public static void diaSemanaData()
    {
        DateInterface d = new Local_Date();
        LocalDate d1;
        d1 = Input.getDataInput();

        if(d1 != null )
        {
            out.print("O dia da semana é ");
            out.println(d.diaDaSemana(d1));
        }

        Input.pressionaEnter();
    }
    
    /*
        Determina o dia do ano de uma data (por exemplo, 10/01/2018 corresponde ao 10º dia do ano de 2018).
    */
    public static void diaAnoDaData()
    {
        DateInterface d = new Local_Date();
        LocalDate d1;
        d1 = Input.getDataInput();


        if(d1 != null )
        {
            out.print("A data " + d1.toString() + " corresponde ao ");
            out.println(d.diaDoAno(d1) + "º dia.");
        }
        
        Input.pressionaEnter();
    }
    
    /*
        Determina o dia da semana do primeiro dia de um ano.
    */
    public static void primeiroDiaAno()
    {
        int ano;
        DateInterface d = new Local_Date();
        
        out.print("Insira o ano:");
        ano = Input.lerInt();
        
        if(ano < 0)
            out.println("Insira um valor positivo!");
        else
        {
            out.print("O primeiro dia do ano corresponde a ");
            out.println(d.primeiroDiaSemanaAno(ano));
        }
        
        Input.pressionaEnter();
    }
    
    /*
        Determina em que trimestre do ano uma data se situa.
    */
    public static void trimestreDaData()
    {
        DateInterface d = new Local_Date();
        LocalDate d1;
        d1 = Input.getDataInput();

        if(d1 != null )
        {
            StringBuilder sb = new StringBuilder();
            sb.append("A data ")
            .append(d1.toString())
            .append(" situa-se no ")
            .append(d.trimestre(d1))
            .append("º trimestre.");
            
            out.println(sb);
            Input.pressionaEnter();
        }
    }
    
    /*
        Determina o século, o milénio e a era de uma data.
    */
    public static void seculoMilenioEraData()
    {
        DateInterface d = new Local_Date();
        LocalDate d1;
        d1 = Input.getDataInput();

        if(d1 != null )
            out.println("Para a data " + d1.toString() + " temos que:\n" + d.seculoMilenioEraData(d1).toString());
        
        Input.pressionaEnter();
    }
    
    /*
        Dado um número de dias, calcula a data daqui a esse número de dias e apresenta ainda qual o dia da semana e quantos
        dias úteis faltam até lá.
    */
    public static void dataEmXDias()
    {
        int dias;
        DateInterface d = new Local_Date();
        
        out.print("Insira os dias:");
        dias = Input.lerInt();
        
        if(dias < 0)
            out.println("Insira um valor positivo!");
        else
        {
            TuploDataDia_SemanaDias_Uteis tri = d.eventoDaquiXDias(dias);
            
            StringBuilder sb = new StringBuilder();
        
            sb.append("A data é ")
           .append(tri.getData())
           .append(", ")
           .append(tri.getDia())
           .append(", e faltam ")
           .append(tri.getUteis())
           .append(" dias úteis.");
            
            out.println(sb.toString());
        }
        
        Input.pressionaEnter();
    }
    
    /*
        Dado um número de dias úteis, calcula a data daqui a esse número de dias e apresenta ainda qual o dia da semana.
    */
    public static void dataEmXDiasUteis()
    {
        int dias;
        DateInterface d = new Local_Date();
        
        out.print("Insira os dias:");
        dias = Input.lerInt();
        
        if(dias < 0)
            out.println("Insira um valor positivo!");
        else
        {
            ParDataDiaDaSemana par = d.eventoDaquiXDiasUteis(dias);
            StringBuilder sb = new StringBuilder();
        
            sb.append("A data é no dia ")
              .append(par.getData())
              .append(", ")
              .append(par.getDias())
              .append(".");
            
            out.println(sb.toString());
        }
        
        Input.pressionaEnter();
    }
    
    /*
        Determina o salário de um indivíduo sabendo quanto ganha por hora e o ano que pretende calcular. Apresenta o resultado
        em dias, semanas, meses e ano.
    */
    public static void salario()
    {
        float salario;
        int ano;
        DateInterface d = new Local_Date();
        
        out.print("Insira quanto recebe por hora:");
        salario = Input.lerFloat();
        
        out.print("Insira o ano que deseja considerar:");
        ano = Input.lerInt();

        
        if(salario < 0.0f || ano < 0)
            out.println("Insira valores positivos!");
        else
        {
            SalarioAno s = d.salarioDiaMesSemanaAno(salario, ano);
            
            StringBuilder sb = new StringBuilder();
            sb.append("Dinheiro recebido por:\n");
            sb.append("Dia: ").append(s.getDia()).append(" euros.\n");
            sb.append("Semana: ").append(s.getSemana()).append(" euros.\n");
            sb.append("Mês: \n");
            s.getSalarioMes().forEach((k, v)->sb.append("   ->").append(k).append(": ").append(v).append("\n"));
            sb.append("Ano: ").append(s.getAno()).append(" euros.");
            
            out.println(sb.toString());
        }
        Input.pressionaEnter();
    }
    
    /*
        Determina em que dias são os fins-de-semana de um dado mês de um ano. Por exemplo, em Janeiro de 2018 o primeiro 
        fim-de-semana ocorre nos dias 6 (Sábado) e 7 (Domingo).
    */
    public static void diasDoFimDeSemanaDeUmMes()
    {
        int ano, mes;
        DateInterface d = new Local_Date();
        
        out.print("Insira o ano:");
        ano = Input.lerInt();
        out.print("Insira o mes:");
        mes = Input.lerInt();
        
        if(ano < 0 || mes < 0)
            out.println("Insira um valor positivo!");
        else if(mes > 12)
            out.println("Só existem 12 meses!");
        else
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Para o ano ").append(ano).append(" e o ").append(mes).append("º mês ").append(", existem os seguintes fins de semana:");
            out.println(sb.toString());
            d.finsDeSemanaDoMes(ano, mes).forEach((k,v)-> out.println(k + ": " + v));
        }
        
        Input.pressionaEnter();
    }
    
    /*
        Determina quantos dias faltam até ao próximo Natal.
    */
    public static void diasAteNatal()
    {
        DateInterface d = new Local_Date();
        StringBuilder sb = new StringBuilder();
        sb.append("Faltam ").append(d.diasAteNatal()).append(" dias até ao Natal.");
        out.println(sb.toString());
        Input.pressionaEnter();
    }
    
    /*
        Determina quanto tempo falta até à próxima passagem do cometa Halley. Mostra o resultado em dias totais, meses totais
        e anos totais.
    */
    public static void cometaHalley()
    {
        DateInterface d = new Local_Date();
        out.println("O cometa Halley será visível na Terra em :");
        out.println(d.cometaHalley().toString());
        Input.pressionaEnter();
    }
    
    /*
        Determina qual a data da próxima Black Friday e quantos dias faltam até essa data.
    */
    public static void blackFriday()
    {
        DateInterface d = new Local_Date();
        StringBuilder sb = new StringBuilder();
        ParDataDia par = d.proxBlackFriday();
        sb.append("A próxima Black Friday é em ")
          .append(par.getData())
          .append(" e faltam ")
          .append(par.getDias())
          .append(" dias.");
        out.println(sb.toString());
        Input.pressionaEnter();
    }
    
    /*
        Para um dado ano apresenta a data dos feriados nacionais e em que dia da semana ocorrem.
    */
    public static void feriadosNacionais()
    {
        int ano;
        DateInterface d = new Local_Date();
        
        out.print("Insira o ano:");
        ano = Input.lerInt();
        
        if(ano < 0)
            out.println("Insira um valor positivo!");
        else
        {
            Map<String, MonthDay> feriados = d.dataFeriadosNacionais(ano);
            StringBuilder sb = new StringBuilder();
            
            sb.append("Feriados nacionais:").append("\n");
            for(Map.Entry<String, MonthDay> entry: feriados.entrySet())
            {
                MonthDay md = entry.getValue();
                int dia = md.getDayOfMonth();
                int mes = md.getMonth().getValue();
                sb.append(entry.getKey())
                  .append(": ")
                  .append(dia)
                  .append("-")
                  .append(mes)
                  .append("-")
                  .append(ano)
                  .append(", ")
                  .append(LocalDate.of(ano, mes, dia).getDayOfWeek())
                  .append("\n");
            }
            
            out.println(sb.toString());
            Input.pressionaEnter();
        }
        
    }
    
    /*
        Calcula a data da Páscoa de um determinado ano.
    */
    public static void pascoa()
    {
        int ano;
        DateInterface d = new Local_Date();
        
        out.print("Insira o ano:");
        ano = Input.lerInt();
        
        if(ano < 0)
            out.println("Insira um valor positivo!");
        else
            out.println("A próxima Páscoa é em " + d.proxPascoa(ano));
        
        
        Input.pressionaEnter();
    }
    
    /*
        Determina o número de dias úteis (isto é, que não são fins-de-semana) de um ano.
    */
    public static void diasUteisAno()
    {
        int ano;
        DateInterface d = new Local_Date();
        
        out.print("Insira o ano:");
        ano = Input.lerInt();
        
        if(ano < 0)
            out.println("Insira um valor positivo!");
        else
        {
            StringBuilder sb = new StringBuilder();
            sb.append("No ano ").append(ano).append(" existem ");
            sb.append(d.numDiasUteisAno(ano));
            sb.append(" dias úteis.");
            
            out.println(sb.toString());
        }
        
        Input.pressionaEnter();
    }
}
