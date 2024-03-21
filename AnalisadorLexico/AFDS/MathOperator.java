package AFDS;
import java.text.CharacterIterator;

import Token.Token;

public class MathOperator extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        switch (code.current()){
            case '+':
                code.next();
                return new Token("PLUS", "+");
            case '-':
                code.next();
                return new Token("LESS", "-");
            case '*':
                code.next();
                return new Token("TIMES", "*");
            case '/':
                code.next();
                return new Token("DIVIDE", "/");

            default:
                return null;
        }
    }
}
