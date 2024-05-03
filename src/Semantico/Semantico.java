/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semantico;

import Token.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unifrmachado
 */
public class Semantico {
    public List<Token> tokens;
    public Token token;
    
    public Semantico(List<Token> tokens){
        this.tokens = tokens;
    }
    
    public Token nextToken(){
        return tokens.remove(0);
    }
    
    public boolean erro(){
        return false;
    }
    
    public boolean success(){
        return true;
    }
    
    public boolean run(){
        token = nextToken();
        if (ifs())
                if ("EOF".equals(token.getTipo()))
                        return success();
        return erro();
    }
    
    public boolean ifs(){
        if ("CONDICIONAL_IF".equals(token.getTipo())){
            token = nextToken();
            if (condicao()){
                if ("CONDICIONAL_THEN".equals(token.getTipo())){
                    if (expressao())
                        return true;
                }
            }
        }
        return erro();
    }
}
