package Sintatico;

import java.util.List;

import Sintatico.AST.Node;
import Lexico.Token;

public abstract class Sintatico {
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

    /**
     * Refatoração do método matchLexema para construção da árvore
     *
     * @param lexema palavra
     * @param newCode token.lexema
     * @param node Nó atual da árvore
     * @return
     */
    public static boolean matchLexema(String lexema, String newCode, Node node){
        if (token.getLexema().equals(lexema)){
            node.addChild(newCode);
            token = nextToken();
            return true;
        }
        return false;
    }

    public static boolean matchLexema(String lexema){
        if (token.getLexema().equals(lexema)){
            token = nextToken();
            return true;
        }
        return false;
    }

    /**
     * Refatoração do método matchTipo para construção da árvore final
     *
     * @param tipo palavra
     * @param newCode token.lexema
     * @param node Nó atual
     * @return
     */
    public static boolean matchTipo(String tipo, String newCode, Node node){
        if (token.getTipo().equals(tipo)){
            node.addChild(newCode);
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

    public static boolean endCode(){
        return matchLexema(";") && Parser.codigo();
    }
}
