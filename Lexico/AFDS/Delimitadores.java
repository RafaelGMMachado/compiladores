package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Token;

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
            case '[':
                code.next();
                return new Token("LCOLCHETE", "[");
            case ']':
                code.next();
                return new Token("RCOLCHETE", "]");
            case '=':
                code.next();

                if (code.current() == '=') {
                    code.next();
                    return new Token("RELACAO_IGUAL", "==");
                }

                return new Token("ATRIBUICAO", "=");

            case ',':
                code.next();
                return new Token("VIRGULA", ",");

            case ';':
                code.next();
                return new Token("FIM", ";");

            case ':':
                code.next();
                return new Token("DOIS_PONTOS", ":");

            case '\"':
                code.next();
                return new Token("ASPAS_DUPLAS", "\"");
            
            case '\'':
                code.next();
                return new Token("ASPAS_SIMPLES", "\'");

            default:
                return null;
        }
    }
}
