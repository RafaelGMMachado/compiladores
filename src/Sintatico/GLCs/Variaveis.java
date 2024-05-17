package Sintatico.GLCs;

import Sintatico.Parser;
import Sintatico.Sintatico;

public class Variaveis  extends Sintatico{
    
    public static boolean declara(){
        if (matchTipoDado() && matchTipo("ID")){
            if (lexemaEquals("=") && atribuicao2())
                return true;
            else if (matchLexema(";") && ( lexemaEquals("}") || Parser.codigo() ))
                return true;
        }

        erro("declara");
        return false;
    }

    public static boolean atribuicao(){
        if (matchTipo("ID") && atribuicao2())
            return true;

        erro("atribuicao");
        return false;
    }

    public static boolean atribuicao2(){
        if (matchLexema("=")){
            if ((string() || expressaoAritimetica()) && matchLexema(";") && ( lexemaEquals("}") || Parser.codigo() ))
                return true;
        }

        erro("atribuicao2");
        return false;
    }

    public static boolean matchTipoDado(){
        if (matchTipo("RESERVADA_INT") || matchTipo("RESERVADA_FLOAT") || matchTipo("RESERVADA_DOUBLE") || matchTipo("RESERVADA_SHORT"))
        {
            return true;
        }
    
        return false;
    }

    public static boolean equalsTipoDado(){
        if (tipoEquals("RESERVADA_INT") || tipoEquals("RESERVADA_FLOAT") || tipoEquals("RESERVADA_DOUBLE") || tipoEquals("RESERVADA_SHORT"))
        {
            return true;
        }
    
        return false;
    }

    public static boolean valor_inicial(){
        if (matchTipo("NUM") || matchTipo("FLUTUANTE") || string())
        {
            return true;
        }
    
        return false;
    }

    public static boolean string(){
        if (matchLexema("\"") && matchTipo("ID")  && matchLexema("\""))
        {
            return true;
        }
    
        return false;
    }

    public static boolean expressaoAritimetica() {
        while (!lexemaEquals(";")) {
            token = nextToken();
            continue;
        }
        return true;
    }
}
