package Lexico.AFDS;

import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.List;

import Lexico.Token;
import Lexico.Utility.Dicionario;

public class Reservadas extends AFD{
    List<Dicionario> reservadas;

    public Reservadas()
    {
        reservadas = new ArrayList<>();
        reservadas.add(new Dicionario("while", "amendoim"));
        reservadas.add(new Dicionario("for", "torresmo"));
        reservadas.add(new Dicionario("if", "velho"));
        reservadas.add(new Dicionario("else", "barreiro"));
        reservadas.add(new Dicionario("else if", "velhoBarreiro"));
        reservadas.add(new Dicionario("scanf", "bebe"));
        reservadas.add(new Dicionario("printf", "canta"));
        reservadas.add(new Dicionario("END", "PT"));
    }

    @Override
    public Token evaluate(CharacterIterator code)
    {
        int pos = code.getIndex();
        for (Dicionario reservada : reservadas){
            for (char c : reservada.valor.toCharArray()){
                if (code.current() == c){
                    code.next(); 
                }
                else{
                    code.setIndex(pos);
                    break;
                }
            }

            if (endPalavra(code)){
                return new Token("RESERVADA_" + reservada.chave.toUpperCase(), reservada.valor);
            }
        }   
        return null;
    }

    private boolean endPalavra(CharacterIterator code){
        return code.current() == ' ' ||
            code.current() == '\n'   ||
            code.current() == '('    ||
            code.current() == CharacterIterator.DONE;
    }
}
