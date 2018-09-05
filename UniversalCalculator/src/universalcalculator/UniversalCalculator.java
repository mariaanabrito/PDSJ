package universalcalculator;

import menus.Menu;
import menus.Menus;
import queries.QueriesCronometro;
import queries.QueriesDatas;
import queries.QueriesDatasTempos;
import queries.QueriesFusos;
import queries.QueriesTempos;

/*
    Classe principal da calculadora universal. Divide a calculadora em diferentes modos (Data, Tempo, Datas e Tempos, Fusos
    Horários e Cronometro), apresentado as funcionalidades de cada uma.
*/
public class UniversalCalculator {
    
    /*
        Apresenta ao utilizador os diferentes modos da calculadora universal.
    */
    public static void main(String[] args) 
    {
        Menu menuPrincipal = Menus.carregaMenuPrincipal();
        
        do
        {   
            infoSistema();
            menuPrincipal.executarMenu();
            switch(menuPrincipal.getOpcao())
            {
                case 1: datas();
                        break;
                case 2: tempos();
                        break;
                case 3: datasETempo();
                        break;
                case 4: fusos();
                        break;
                case 5: cronometro();
                        break;
            }
        }while(menuPrincipal.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo Data.
    */
    public static void datas()
    {
        Menu menuDatas = Menus.carregaMenuDatas();
        do
        {
            infoSistema();
            menuDatas.executarMenu();
            switch(menuDatas.getOpcao())
            {
                case 1: operacoesDatas();
                        break;
                case 2: contagensDatas();
                        break;
                case 3: curiosidadesDatas();
                        break;
            }
        }while(menuDatas.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo operações com datas.
    */
    public static void operacoesDatas()
    {
        Menu menuOperacoes = Menus.carregaMenuOperacoesDatas();
        do
        {
            infoSistema();
            menuOperacoes.executarMenu();
            switch(menuOperacoes.getOpcao())
            {
                case 1: QueriesDatas.diferencaEntreDuasDatas();
                        break;
                case 2: QueriesDatas.operacoesDatas();
                        break;
                case 3: QueriesDatas.dataEmXDias();
                        break;
                case 4: QueriesDatas.dataEmXDiasUteis();
                        break;
            }
        }while(menuOperacoes.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo contagens com datas.
    */
    public static void contagensDatas()
    {
        Menu menuContagens = Menus.carregaMenuContagens();
        do
        {
            infoSistema();
            menuContagens.executarMenu();
            switch(menuContagens.getOpcao())
            {
                case 1: QueriesDatas.diasUteisEntreDatas();
                        break;
                case 2: QueriesDatas.numFinsDeSemanaAno();
                        break;
                case 3: QueriesDatas.numSemanasAteData();
                        break;
                case 4: QueriesDatas.diaSemanaData();
                        break;
                case 5: QueriesDatas.diaAnoDaData();
                        break;
                case 6: QueriesDatas.primeiroDiaAno();
                        break;
                case 7: QueriesDatas.trimestreDaData();
                        break;
                case 8: QueriesDatas.diasUteisAno();
                        break;
            }
        }while(menuContagens.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo curiosidades relacionadas com datas.
    */
    public static void curiosidadesDatas()
    {
        Menu menuCuriosidades = Menus.carregaMenuCuriosidades();
        do
        {
            infoSistema();
            menuCuriosidades.executarMenu();
            switch(menuCuriosidades.getOpcao())
            {
                case 1: QueriesDatas.anoBissexto();
                        break;
                case 2: QueriesDatas.estacaoDoAno();
                        break;
                case 3: QueriesDatas.seculoMilenioEraData();
                        break;
                case 4: QueriesDatas.salario();
                        break;
                case 5: QueriesDatas.diasDoFimDeSemanaDeUmMes();
                        break;
                case 6: QueriesDatas.feriadosNacionais();
                        break;
                case 7: QueriesDatas.diasAteNatal();
                        break;
                case 8: QueriesDatas.cometaHalley();
                        break;
                case 9: QueriesDatas.blackFriday();
                        break;
                case 10: QueriesDatas.pascoa();
                        break;
            }
        }while(menuCuriosidades.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo Fusos Horários.
    */
    public static void fusos()
    {
        infoSistema();
        Menu menuFusos = Menus.carregaMenuFusos();
        do
        {
            menuFusos.executarMenu();
            switch(menuFusos.getOpcao())
            {
                case 1: QueriesFusos.difHorasFusos();
                       break;
                case 2: QueriesFusos.horaFusoNoutroFuso(true);
                       break;
                case 3: QueriesFusos.offsetZona();
                       break;
                case 4: QueriesFusos.horaFusoNoutroFuso(false);
                       break;
                case 5: QueriesFusos.todosIdsOffsets();
                       break;
                case 6: QueriesFusos.todasZonasEOffSets();
                       break;
            }
            
        }while(menuFusos.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo Tempo.
    */
    public static void tempos()
    {
        Menu menuTempos = Menus.carregaMenuTempos();
        do
        {
            infoSistema();
            menuTempos.executarMenu();
            switch(menuTempos.getOpcao())
            {
                case 1: QueriesTempos.difTempos();
                       break;
                case 2: QueriesTempos.operacaoTempos();
                       break;
                case 3: QueriesTempos.maisLentoQueOBolt();
                       break;
            }
            
        }while(menuTempos.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo Datas e Tempos.
    */
    public static void datasETempo()
    {
        Menu menuDataTempos = Menus.carregaMenuDatasTempos();
        do
        {   infoSistema();
            menuDataTempos.executarMenu();
            switch(menuDataTempos.getOpcao())
            {
                case 1: QueriesDatasTempos.difDatasTempos();
                       break;
            }
            
        }while(menuDataTempos.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador as funcionalidades do modo Cronometro.
    */
    public static void cronometro()
    {
        Menu menuCrono = Menus.carregaMenuCrono();
        do
        {
            infoSistema();
            menuCrono.executarMenu();
            switch(menuCrono.getOpcao())
            {
                case 1: QueriesCronometro.start();
                       break;
                case 2: QueriesCronometro.stop();
                       break;
            }
            
        }while(menuCrono.getOpcao() != 0);
    }
    
    /*
        Apresenta ao utilizador a informação do sistema, nomeadamente a data, as horas, o offset e o fuso horário, do sistema.
    */
    public static void infoSistema()
    {
        QueriesFusos.infoSistemaLocal();
    }
}
