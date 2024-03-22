package AFDS;
import java.text.CharacterIterator;

import Token.Token;

public class Relacao extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        switch (code.current()){
            case '<':
                code.next();

                if (code.current() == '=') {
                    code.next();
                    return new Token("RELACAO_MENOR_IGUAL", "<=");
                }

                return new Token("RELACAO_MENOR", "<");
            case '>':
                code.next();
                
                if (code.current() == '=') {
                    code.next();
                    return new Token("RELACAO_MAIOR_IGUAL", ">=");
                }

                else return new Token("RELACAO_MAIOR", ">");

            default:
                return null;
        }
    }
}
