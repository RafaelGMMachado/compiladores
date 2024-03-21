package AFDS;
import java.text.CharacterIterator;
import java.util.List;
import java.util.ArrayList;

import Token.Token;

public class Types extends AFD{

    @Override
    public Token evaluate(CharacterIterator code){
        List<String> reservadas = new ArrayList<>();
        reservadas.add("int");
        reservadas.add("return");
        reservadas.add("float");

        for (String res : reservadas){
            for (char c : res.toCharArray()){
                if (code.current() == c)
                    code.next();   
            }
            if (endPalavra(code)){
                return new Token("RESERVADA_" + res.toUpperCase(), res);
            }
        }
        return null;
    }

    private boolean endPalavra(CharacterIterator code){
        return code.current() == ' ' ||
            code.current() == '\n' ||
            code.current() == CharacterIterator.DONE;
    }

}