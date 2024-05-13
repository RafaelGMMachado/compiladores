package AFDS;
import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.List;

import Token.Token;
import Utility.Dicionario;

public class Conditionals extends AFD{
    
    List<Dicionario> reservadas;

    public Conditionals()
    {
        reservadas = new ArrayList<>();
        reservadas.add(new Dicionario("if", "velho"));
        reservadas.add(new Dicionario("else", "barreiro"));
        reservadas.add(new Dicionario("else if", "sangue de boi"));
        reservadas.add(new Dicionario("switch", "whiskey"));
        reservadas.add(new Dicionario("case", "corote"));
        reservadas.add(new Dicionario("default", "defeito"));
        reservadas.add(new Dicionario("break", "bebado"));
        reservadas.add(new Dicionario("goto", "gotoso"));
    }

    @Override
    public Token evaluate(CharacterIterator code)
    {
        for (Dicionario reservada : reservadas){
            for (char c : reservada.valor.toCharArray()){
                if (code.current() == c){
                    code.next(); 

                    if (endPalavra(code)){
                        return new Token("RESERVADA_" + reservada.chave.toUpperCase(), reservada.valor);
                    }
                }
            }
        }   
        return null;
    }

    private boolean endPalavra(CharacterIterator code){
        return code.current() == ' ' ||
            code.current() == '\n'   ||
            code.current() == '('    ||
            code.current() == ';'    ||
            code.current() == CharacterIterator.DONE;
    }
    
}
