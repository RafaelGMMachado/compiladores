package Sintatico;

import Lexico.Token;

import java.io.IOException;
import java.util.List;

import Sintatico.AST.Node;
import Sintatico.AST.Tree;
import Sintatico.GLCS.*;

public class Parser extends Sintatico{

    public Parser(List<Token> tokens){
        Sintatico.tokens = tokens;
    }
    
    public void run(){
        boolean sucesso = false;
        
        no = new Node(null); // passar inicio de um programa em C
        arvore = new Tree(no);
        
        token = nextToken();
        if (codigo())
                if (matchTipo("EOF")){
                    sucesso = success();
                    arvore.simpleWalk();
                    try {
                        arvore.createOutputFile();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        if (!sucesso)
            erro("main");
    }

    public static boolean codigo(){
        if (tipoEquals("EOF"))
            return true;
        else if (Fluxo.fluxo())
            return true;
        else if (Variaveis.equalsTipoDado() && Variaveis.declara())
            return true;
        else if (tipoEquals("ID") && Variaveis.atribuicao())
            return true;
        else if (lexemaEquals("canta") && Funcoes.print())
            return true;
        else if (lexemaEquals("bebe") && Funcoes.scan())
            return true;
        else if (Expressoes.expressaoAritimetica())
            return true;

        erro("codigo");
        return false;
    }
}
