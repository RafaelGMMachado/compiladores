package Sintatico.GLCS;

import Sintatico.Parser;
import Sintatico.Sintatico;

public class Fluxo extends Sintatico {

    public static boolean fluxo(){
        if (lexemaEquals("velho") && codigo_if())
            return true;
        else if (lexemaEquals("amendoim") && codigo_while())
            return true;
        else if (lexemaEquals("torresmo") && codigo_for())
            return true;

        return false;
    }

    public static boolean codigo_if(){
        if (matchLexema("velho", "if") && matchLexema("(") && condicao() && matchLexema(")") && 
            matchLexema("{") && Parser.codigo() && matchLexema("}") &&
            codigo_elif() && codigo_else() && ( lexemaEquals("}") || Parser.codigo() ))
        {
            return true;
        }
    
        erro("If");
        return false;
    }

    public static boolean codigo_elif(){ // colocar para poder ser nulo
        if (matchLexema("velhoBarreiro", "elif")  )
        {
            if (matchLexema("(") && condicao() && matchLexema(")") && 
                matchLexema("{") && Parser.codigo() && matchLexema("}") && codigo_elif() && ( lexemaEquals("}") || Parser.codigo() ))
            {
                return true;
            }
            erro("Elif");
            return false;
        }
    
        return true;
    }

    public static boolean codigo_else(){ // colocar para poder ser nulo
        if (matchLexema("barreiro", "else"))
        {
            if (matchLexema("{") && Parser.codigo() && matchLexema("}") && ( lexemaEquals("}") || Parser.codigo() ))
            {
                return true;
            }
            erro("Else");
            return false;
        }

        return true;
    }

    public static boolean codigo_while(){
        if (matchLexema("amendoim", "while") && matchLexema("(") && condicao() && matchLexema(")") &&
            matchLexema("{") && Parser.codigo() && matchLexema("}") && ( lexemaEquals("}") || Parser.codigo() ))
        {
            return true;
        }

        erro("While");
        return false;
    }

    public static boolean codigo_for(){
        if (matchLexema("torresmo", "for") && matchLexema("(") && inicializa() && expressaoLogica() && matchLexema(";") && incremento() && matchLexema(")") &&
            matchLexema("{") && Parser.codigo() && matchLexema("}") && ( lexemaEquals("}") || Parser.codigo() ))
        {
            return true;
        }

        erro("For");
        return false;
    }

    public static boolean inicializa(){
        if (matchTipo("ID")){
            return true;
        }
        else if (Variaveis.matchTipoDado() && matchTipo("ID") && matchLexema("=") && Expressoes.expressaoAritimetica() && matchLexema(";")){
            return true;
        }

        erro("inicializa");
        return false;
    }

    public static boolean expressaoLogica(){
        while (!lexemaEquals(";"))
            token = nextToken();
        return true;
    }

    public static boolean incremento(){
        if (matchTipo("ID") && matchLexema("+") && matchLexema("+") && op_logico())
        {
            return true;
        }
    
        erro("condicao");
        return false;
    }
    
    public static boolean condicao(){
        if (matchTipo("ID") && operador() && matchTipo("NUM") && op_logico())
        {
            return true;
        }
    
        erro("condicao");
        return false;
    }
    
    public static boolean operador(){
        if (matchLexema(">") || matchLexema("<") || matchLexema("==") || matchLexema(">=") || matchLexema("<="))
        {
            return true;
        }
    
        erro("operador");
        return false;
    }
    
    public static boolean op_logico(){
        if (matchLexema("&&") || matchLexema("||"))
        {
            if (condicao())
            {
                return true;
            }
            erro("op_logico");
            return false;
        }

        return true;
    }
}
