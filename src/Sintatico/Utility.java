package Sintatico;

import java.util.List;

import Token.Token;

public abstract class Utility {
    public static List<Token> tokens;
    public static Token token;

    public static Token nextToken(){
        if (tokens.size() > 0)
            return tokens.remove(0);
        return null;
    }
    
    public static void erro(String regra){
        System.out.println("Regra: " + regra);
        System.exit(0); // encerra o programa
    }
    
    public static boolean success(){
        System.out.println("RODOU!!");
        return true;
    }

    public static boolean matchLexema(String lexema){
        if (token.getLexema().equals(lexema)){
            token = nextToken();
            return true;
        }
        return false;
    }
    
    public static boolean matchTipo(String tipo){
        if (token.getTipo().equals(tipo)){
            token = nextToken();
            return true;
        }
        return false;
    }

    public static boolean lexemaEquals(String lexema){
        if (token.getLexema().equals(lexema)){
            return true;
        }
        return false;
    }

    public static boolean tipoEquals(String tipo){
        if (token.getTipo().equals(tipo)){
            return true;
        }
        return false;
    }
}
