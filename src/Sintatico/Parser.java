/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintatico;

import Token.Token;
import java.util.List;
import Sintatico.GLCs.*;

/**
 *
 * @author unifrmachado
 */
public class Parser extends Sintatico{

    public Parser(List<Token> tokens){
        Sintatico.tokens = tokens;
    }
    
    public void run(){
        boolean sucesso = false;

        token = nextToken();
        if (codigo())
                if (matchTipo("EOF"))
                        sucesso = success();
        if (!sucesso)
            erro("main");
    }

    public static boolean codigo(){
        if ("EOF".equals(token.getTipo()))
            return true;
        else if (Fluxo.statement())
            return true;
        else if (Variaveis.equalsTipoDado() && Variaveis.declara())
            return true;
        else if (tipoEquals("ID") && Variaveis.atribuicao())
            return true;
        else if (lexemaEquals("canta") && Funcoes.print())
            return true;
        else if (lexemaEquals("bebe") && Funcoes.scan())
            return true;

        erro("codigo");
        return false;
    }
}
