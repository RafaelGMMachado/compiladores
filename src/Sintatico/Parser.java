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
    
    public void run(){
        token = nextToken();
        if (ifelse())
                if ("EOF".equals(token.getTipo()))
                        success();
        erro("main");
    }
    
    public boolean ifelse(){
        if (matchLexema("if") && condicao() && 
            matchLexema("then") && expressao() && 
            matchLexema("else") && expressao())
        {
            return true;
        }
    
        erro("IfElse");
        return false;
    }
    
    public boolean condicao(){
        if (matchTipo("ID") && operador() && matchTipo("NUM"))
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
        if (matchLexema(">") || matchLexema("<") || matchLexema("=="))
        {
            return true;
        }
    
        erro("operador");
        return false;
    }
    
}
