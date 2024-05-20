package Sintatico.GLCS;

import Sintatico.Parser;
import Sintatico.Sintatico;

public class Funcoes extends Sintatico {

    public static boolean print(){
        if (matchTipo("RESERVADA_PRINTF", "printf") && matchLexema("(") && ( matchTipo("ID") || argumentoPrint() ) && matchLexema(")") && endCode()){
            return true;
        }

        erro("printf");
        return false;
    }

    public static boolean argumentoPrint(){
        if (matchLexema("\"", false)){
            if (lexemaEquals("%") && matchLexema("%", false) && tipoScan() && matchLexema("\"") && matchLexema(",") && ( matchLexema("&", false) || true ) && matchTipo("ID")){
                return true;
            }
            else{
                while (matchTipo("ID")){
                    continue;
                }
                return matchLexema("\"");
            }
        }

        erro("argumentoPrint");
        return false;
    }

    public static boolean scan(){
        if (matchTipo("RESERVADA_SCANF", "scanf") && matchLexema("(") && argumentoScan() && matchLexema(")") && matchLexema(";") && ( lexemaEquals("}") || Parser.codigo() )){
            return true;
        }

        erro("scanf");
        return false;
    }

    public static boolean argumentoScan(){
        if (matchLexema("\"", false) && matchLexema("%", false) && tipoScan() && matchLexema("\"") && matchLexema(",") && ( matchLexema("&", false) || true ) && matchTipo("ID")){
            return true;
        }

        erro("argumentoScan");
        return false;
    }

    public static boolean tipoScan(){
        if (matchLexema("s", false) || matchLexema("d", false) || matchLexema("f", false) || matchLexema("lf", false)){
            return true;
        }

        erro("tipoScan");
        return false;
    }
}
