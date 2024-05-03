package AFDS;
import java.text.CharacterIterator;

import Token.Token;

public class Comentario extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        if (code.current() != '/')
            return null;
        code.next();
        if (code.current() != '/')
            return null;
        code.next();
        

        String comment = readComment(code);
        return new Token("COMENTARIO", comment);
    }

    private String readComment(CharacterIterator code){
        String comment = "//";
        while (code.current() != '\n' || code.current() != CharacterIterator.DONE){
            comment += code.current();
            code.next();
        }
        return comment;
    }
}