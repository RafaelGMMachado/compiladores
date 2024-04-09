package AFDS;
import java.text.CharacterIterator;

import Utility.Functions;
import Token.Token;

public class Number extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        if (Character.isDigit(code.current())){
            String number = readNumber(code);

            if (code.current() != '.' && Functions.validateEnd(code)){
                return new Token("NUM", number);
            }

            code.next();
            number += '.' + readNumber(code);
            if (Functions.validateEnd(code)){
                return new Token("FLUTUANTE", number);
            }
        }
        return null;
    }

    private String readNumber(CharacterIterator code){
        String number = "";
        while (Character.isDigit(code.current())){
            number += code.current();
            code.next();
        }
        return number;
    }

}