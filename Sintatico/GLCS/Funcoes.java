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
        if (matchLexema("\"")){
            if (lexemaEquals("%") && matchLexema("%") && tipoScan() && matchLexema("\"") && matchLexema(",") && ( matchLexema("&") || true ) && matchTipo("ID")){
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
