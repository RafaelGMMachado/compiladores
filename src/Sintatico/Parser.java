/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintatico;

import Token.Token;
import java.util.List;

/**
 *
 * @author unifrmachado
 */
public class Parser {
    public List<Token> tokens;
    public Token token;
    
    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }
    
    public Token nextToken(){
        if (tokens.size() > 0)
            return tokens.remove(0);
        return null;
    }
    
    public void erro(String regra){
        System.out.println("Regra: " + regra);
        System.exit(0); // encerra o programa
    }
    
    public boolean success(){
        System.out.println("RODOU!!");
        return true;
    }

    public boolean matchLexema(String lexema){
        if (token.getLexema().equals(lexema)){
            token = nextToken();
            return true;
        }
        return false;
    }
    
    public boolean matchTipo(String tipo){
        if (token.getTipo().equals(tipo)){
            token = nextToken();
            return true;
        }
        return false;
    }

    public boolean lexemaEquals(String lexema){
        if (token.getLexema().equals(lexema)){
            return true;
        }
        return false;
    }

    public boolean tipoEquals(String tipo){
        if (token.getTipo().equals(tipo)){
            return true;
        }
        return false;
    }
    
    public void run(){
        token = nextToken();
        if (statement())
                if ("EOF".equals(token.getTipo()))
                        success();
        erro("main");
    }

    public boolean statement(){
        if (lexemaEquals("if") && if_statement())
            return true;
        else if (lexemaEquals("while") && while_statement())
            return true;

        erro("If");
        return false;
    }

    public boolean code(){
        while (!lexemaEquals("}"))
            token = nextToken();
        return true;
    }
    
    public boolean if_statement(){
        if (matchLexema("if") && matchLexema("(") && condicao() && matchLexema(")") && 
            matchLexema("{") && code() && matchLexema("}") &&
            elif_statement() && else_statement())
        {
            return true;
        }
    
        erro("If");
        return false;
    }

    public boolean elif_statement(){ // colocar para poder ser nulo
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

    public boolean else_statement(){ // colocar para poder ser nulo
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

    public boolean while_statement(){
        code();
        return true;
    }
    
    public boolean condicao(){
        if (matchTipo("ID") && operador() && matchTipo("NUM") && op_logico())
        {
            return true;
        }
    
        erro("condicao");
        return false;
    }
    
    public boolean expressao(){
        if (matchTipo("ID") && matchLexema("=") && matchTipo("NUM"))
        {
            return true;
        }
    
        erro("expressao");
        return false;
    }
    
    public boolean operador(){
        if (matchLexema(">") || matchLexema("<") || matchLexema("==") || matchLexema(">=") || matchLexema("<="))
        {
            return true;
        }
    
        erro("operador");
        return false;
    }
    
    public boolean op_logico(){
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
