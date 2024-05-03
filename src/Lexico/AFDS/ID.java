package AFDS;
import java.text.CharacterIterator;

import Token.Token;

public class ID extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        if (Character.isLetter(code.current())){
            String letter = readLetter(code);

            if (endLetter(code)){
                return new Token("ID", letter);
            }
        }
        return null;
    }

    private String readLetter(CharacterIterator code){
        String letter = "";
        while (Character.isLetter(code.current())){
            letter += code.current();
            code.next();
        }
        return letter;
    }

    private boolean endLetter(CharacterIterator code){
        return code.current() == ' ' ||
            code.current() == '+' ||
            code.current() == '-' ||
            code.current() == '*' ||
            code.current() == '/' ||
            code.current() == '(' ||
            code.current() == ')' ||
            code.current() == '{' ||
            code.current() == '}' ||
            code.current() == ';' ||
            code.current() == '\n' ||
            code.current() == CharacterIterator.DONE;
    }

}