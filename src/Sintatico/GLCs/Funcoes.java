package Sintatico.GLCs;

import Sintatico.Parser;
import Sintatico.Sintatico;

public class Funcoes extends Sintatico {

    public static boolean print(){
        if (matchLexema("canta") && matchLexema("(") && ( matchTipo("ID") || Variaveis.string() ) && matchLexema(")") && matchLexema(";") && Parser.codigo()){
            return true;
        }

        erro("print");
        return false;
    }

    public static boolean scan(){
        if (matchLexema("bebe") && matchLexema("(") && argumentoScan() && matchLexema(")") && matchLexema(";") && Parser.codigo()){
            return true;
        }

        erro("scan");
        return false;
    }

    public static boolean argumentoScan(){
        if (matchLexema("\"") && matchLexema("%")){
            if (lexemaEquals("s")){
                if (matchLexema("s") && matchLexema("\"") && matchLexema(",") && matchTipo("ID"))
                    return true;
            }
            else if (lexemaEquals("d")){
                if (matchLexema("d") && matchLexema("\"") && matchLexema(",") && matchLexema("&") && matchTipo("ID") )
                    return true;
            }
        }

        erro("argumentoScan");
        return false;
    }
}
