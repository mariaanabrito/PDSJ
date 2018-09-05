package menus;

/*
    Menus responsáveis pela apresentação dos modos da calculadora universal e suas funcionalidades.
*/
public class Menus 
{
    public static Menu carregaMenuPrincipal()
    {
        String[] opsPrincipais = 
                    {"Datas",
                        "Tempos",
                        "Datas e Tempos",
                        "Fusos Horários",
                        "Cronómetro"
                    };
        
        return new Menu(opsPrincipais);
    }
    
    public static Menu carregaMenuDatas()
    {
        String[] opsDatas = 
                        {
                            "Operações",
                            "Contagens",
                            "Curiosidades"
                        };
        return new Menu(opsDatas);
    }
    
    public static Menu carregaMenuOperacoesDatas()
    {
        String[] opsData = 
                        {"Diferença entre duas datas",
                            "Operações com datas",
                            "Qual a data daqui a X dias?",
                            "Qual a data daqui a X dias úteis?",
                        };
        return new Menu(opsData);
                
    }
    
    public static Menu carregaMenuContagens()
    {
        String[] ops = 
                        {
                            "Número de dias úteis entre duas datas",
                            "Número de fins de semana de um ano",
                            "Número de semanas completas até uma data",
                            "Qual o dia da semana da data?",
                            "Qual o dia do ano da data?",
                            "Qual o 1º dia da semana do ano?",
                            "Em que trimestre se encontra a data?",
                            "Quantos dias úteis tem um ano?",
                        };
        return new Menu(ops);
    }
    
    public static Menu carregaMenuCuriosidades()
    {
        String[] ops = 
                        {
                            "É ano bissexto?",
                            "Qual é a estação do ano da data?",
                            "Qual o século, milénio e era da data?",
                            "Dado o salário/hora, quanto ganha por dia/semana/mês/ano?",
                            "Em que dias são os fins de semana de um mês?",
                            "Para um dado ano, em que dias da semana são os feriados em Portugal?",
                            "Quantos dias faltam para o Natal?",
                            "Quando é a próxima passagem do cometa Halley?",
                            "Quantos dias faltam até à próxima Black Friday?",
                            "Dado um ano quando é a Páscoa?"
                        };
        return new Menu(ops);
    }
    
    
    public static Menu carregaMenuFusos()
    {
        String[] opsFuso = {"Calcular diferença de horas de dois tempos em fusos horários diferentes",
                            "Dada uma hora no fuso horário local, descobrir a hora noutro fuso horário",
                            "Indicar qual o offset de uma zona",
                            "Dada uma hora num fuso horário qualquer, determinar essa hora noutro fuso horário",
                            "Dado um offset, saber quais as zonas do mundo que partilham esse offset",
                            "Indicar todos os fusos horários e respetivos offsets"
        };
        
        return new Menu(opsFuso);
    }
    
    public static Menu carregaMenuTempos()
    {
        String[] opsTempo = {"Calcular diferenças entre tempos",
                             "Operações com tempos",
                             "Quanto tempo sou mais lento que o Usain Bolt?"
        };
        
        return new Menu(opsTempo);
    }
    
    public static Menu carregaMenuDatasTempos()
    {
        String[] opsDataTempo = {"Calcular diferenças entre datas e tempos"
        };
        
        return new Menu(opsDataTempo);
    }
    
    public static Menu carregaMenuCrono()
    {
        String[] opsCrono = {"Start",
                                 "Stop"
        };
        
        return new Menu(opsCrono);
    }
}
