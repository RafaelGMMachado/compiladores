package Sintatico;

import Lexico.Token;
import java.util.List;
import Sintatico.GLCS.*;

public class Parser extends Sintatico{

    public Parser(List<Token> tokens){
        Sintatico.tokens = tokens;
    }
    
    public void run(){
        boolean sucesso = false;

        token = nextToken();
        if (codigo())
                if (matchTipo("EOF"))
                        sucesso = success();
        if (!sucesso)
            erro("main");
    }

    public static boolean codigo(){
        if (tipoEquals("EOF"))
            return true;
        else if (Fluxo.statement())
            return true;
        else if (Variaveis.equalsTipoDado() && Variaveis.declara())
            return true;
        else if (tipoEquals("ID") && Variaveis.atribuicao())
            return true;
        else if (lexemaEquals("canta") && Funcoes.print())
            return true;
        else if (lexemaEquals("bebe") && Funcoes.scan())
            return true;
        else if (Expressoes.expressaoAritimetica())
            return true;

        erro("codigo");
        return false;
    }
}
