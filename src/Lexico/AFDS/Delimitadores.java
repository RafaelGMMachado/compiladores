package AFDS;
import java.text.CharacterIterator;

import Token.Token;

public class Delimitadores extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        switch (code.current()){
            case '(':
                code.next();
                return new Token("LPAREN", "(");
            case ')':
                code.next();
                return new Token("RPAREN", ")");
            case '{':
                code.next();
                return new Token("LCHAVE", "{");
            case '}':
                code.next();
                return new Token("RCHAVE", "}");
            case '=':
                code.next();

                if (code.current() == '=') {
                    code.next();
                    return new Token("RELACAO_IGUAL", "==");
                }

                return new Token("ATRIBUICAO", "=");
            case ';':
                code.next();
                return new Token("FIM", ";");

            case ':':
                code.next();
                return new Token("DOIS_PONTOS", ":");

            default:
                return null;
        }
    }
}
