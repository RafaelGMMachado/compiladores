package AFDS;
import java.text.CharacterIterator;

import Token.Token;

public class MathOperator extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        switch (code.current()){
            case '+':
                code.next();
                return new Token("OPERADOR_MAIS", "+");
            case '-':
                code.next();
                return new Token("OPERADOR_MENOS", "-");
            case '*':
                code.next();
                    
                if (code.current() == '*') {
                    code.next();
                    return new Token("OPERADOR_VEZES", "**");
                }
                
                else return new Token("OPERADOR_EXPONENCIACAO", "*");
            case '/':
                code.next();
                return new Token("OPERADOR_DIVIDIR", "/");

            case '%':
                code.next();
                return new Token("OPERADOR_RESTO", "%");

            default:
                return null;
        }
    }
}
