package Sintatico.GLCs;

import Sintatico.Parser;
import Sintatico.Sintatico;

public class Funcoes extends Sintatico {

    public static boolean print(){
        if (matchLexema("canta") && matchLexema("(") && ( matchTipo("ID") || Variaveis.string() ) && matchLexema(")") && matchLexema(";") && 
        ( lexemaEquals("}") || Parser.codigo() )){
            return true;
        }

        erro("print");
        return false;
    }

    public static boolean scan(){
        if (matchLexema("bebe") && matchLexema("(") && argumentoScan() && matchLexema(")") && matchLexema(";") && ( lexemaEquals("}") || Parser.codigo() )){
            return true;
        }

        erro("scan");
        return false;
    }

    public static boolean argumentoScan(){
        if (matchLexema("\"") && matchLexema("%") && tipoScan() && matchLexema("\"") && matchLexema(",") && ( matchLexema("&") || true ) && matchTipo("ID")){
            return true;
        }

        erro("argumentoScan");
        return false;
    }

    public static boolean tipoScan(){
        if (matchLexema("s") || matchLexema("d")){
            return true;
        }

        erro("tipoScan");
        return false;
    }
}
