package Lexico.AFDS;
import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.List;

import Lexico.Token;
import Lexico.Utility.Dicionario;

public class Repetitions extends AFD{
    
    List<Dicionario> reservadas;

    public Repetitions()
    {
        reservadas = new ArrayList<>();
        reservadas.add(new Dicionario("do", "catuaba"));
        reservadas.add(new Dicionario("while", "amendoim"));
        reservadas.add(new Dicionario("for", "torresmo"));
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
            // code.current() == ';'    ||
            code.current() == CharacterIterator.DONE;
    }
    
}
