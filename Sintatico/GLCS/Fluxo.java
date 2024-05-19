package Sintatico.GLCS;

import Sintatico.Parser;
import Sintatico.Sintatico;

public class Fluxo extends Sintatico {

    public static boolean fluxo(){
        if (tipoEquals("RESERVADA_IF") && codigo_if())
            return true;
        else if (tipoEquals("RESERVADA_WHILE") && codigo_while())
            return true;
        else if (tipoEquals("RESERVADA_FOR") && codigo_for())
            return true;

        return false;
    }

    public static boolean codigo_if(){
        if (matchTipo("RESERVADA_IF", "if") && matchLexema("(") && condicao() && matchLexema(")") && 
            matchLexema("{") && Parser.codigo() && matchLexema("}") &&
            codigo_elif() && codigo_else() && ( lexemaEquals("}") || Parser.codigo() ))
        {
            return true;
        }
    
        erro("If");
        return false;
    }

    public static boolean codigo_elif(){ // colocar para poder ser nulo
        if (matchTipo("RESERVADA_ELIF", "else if")  )
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
        if (matchTipo("RESERVADA_ELSE", "else"))
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
        if (matchTipo("RESERVADA_WHILE", "while") && matchLexema("(") && condicao() && matchLexema(")") &&
            matchLexema("{") && Parser.codigo() && matchLexema("}") && ( lexemaEquals("}") || Parser.codigo() ))
        {
            return true;
        }

        erro("While");
        return false;
    }

    public static boolean codigo_for(){
        if (matchTipo("RESERVADA_FOR", "for") && matchLexema("(") && inicializa() && expressaoLogica() && matchLexema(";") && incremento() && matchLexema(")") &&
            matchLexema("{") && Parser.codigo() && matchLexema("}") && ( lexemaEquals("}") || Parser.codigo() ))
        {
            return true;
        }

        erro("For");
        return false;
    }

    public static boolean inicializa(){
        if (matchTipo("ID") && matchLexema(";")){
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
        if (matchTipo("ID"))
        {
            if (lexemaEquals("=") && matchLexema("=") && Expressoes.expressaoAritimetica()){
                return true;
            }
            else if (somaSubtracao() && somaSubtracao()){
                return true;
            }
        }
    
        erro("incremento");
        return false;
    }

    public static boolean somaSubtracao(){
        return matchLexema("+") || matchLexema("-");
    }
    
    public static boolean condicao(){
        if ((Expressoes.fator() || Expressoes.expressaoAritimetica()) && Expressoes.operadorLogico() && Expressoes.expressaoAritimetica())
        {
            return true;
        }
    
        erro("condicao");
        return false;
    }
    
}
