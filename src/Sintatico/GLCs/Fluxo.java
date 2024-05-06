package Sintatico.GLCs;

import Sintatico.Sintatico;

public class Fluxo extends Sintatico {

    public static boolean statement(){
        if (lexemaEquals("if") && if_statement())
            return true;
        else if (lexemaEquals("while") && while_statement())
            return true;

        erro("If");
        return false;
    }

    public static boolean if_statement(){
        if (matchLexema("if") && matchLexema("(") && condicao() && matchLexema(")") && 
            matchLexema("{") && code() && matchLexema("}") &&
            elif_statement() && else_statement())
        {
            return true;
        }
    
        erro("If");
        return false;
    }

    public static boolean elif_statement(){ // colocar para poder ser nulo
        if (matchLexema("elif")  )
        {
            if (matchLexema("(") && condicao() && matchLexema(")") && 
                matchLexema("{") && code() && matchLexema("}") && elif_statement())
            {
                return true;
            }
            erro("Elif");
            return false;
        }
    
        return true;
    }

    public static boolean else_statement(){ // colocar para poder ser nulo
        if (matchLexema("else"))
        {
            if (matchLexema("{") && code() && matchLexema("}"))
            {
                return true;
            }
            erro("Else");
            return false;
        }

        return true;
    }

    public static boolean while_statement(){
        code();
        return true;
    }

    

    public static boolean code(){
        while (!lexemaEquals("}"))
            token = nextToken();
        return true;
    }
    
    public static boolean condicao(){
        if (matchTipo("ID") && operador() && matchTipo("NUM") && op_logico())
        {
            return true;
        }
    
        erro("condicao");
        return false;
    }
    
    public static boolean expressao(){
        if (matchTipo("ID") && matchLexema("=") && matchTipo("NUM"))
        {
            return true;
        }
    
        erro("expressao");
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
        if (matchLexema("and") || matchLexema("or"))
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
