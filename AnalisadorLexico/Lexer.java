import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import AFDS.AFD;
import Token.Token;

import AFDS.Comentario;
import AFDS.Delimitadores;
import AFDS.ID;
import AFDS.MathOperator;
import AFDS.Number;
import AFDS.Types;
import AFDS.Relacao;

public class Lexer {
    
    private List<Token> tokens;
    private List<AFD> afds;
    private CharacterIterator code;
    private int line = 1;
    private int lastColumn = 0;

    public Lexer(String code){
        tokens = new ArrayList<>();
        this.code = new StringCharacterIterator(code);
        afds = new ArrayList<>();
        afds.add(new Delimitadores());
        afds.add(new Types());
        afds.add(new MathOperator());
        afds.add(new Relacao());
        afds.add(new Number());
        afds.add(new ID());
        afds.add(new Comentario());
    }

    public void skipWhiteSpace(){
        while (code.current() == ' ' || code.current() == '\n' || code.current() == '\t' || code.current() == '\r'){
            if (code.current() == '\n'){
                line ++;
                lastColumn = code.getIndex();
            } 
            code.next();
        }
    }

    public List<Token> getTokens(){
        boolean accepted;
        while (code.current() != CharacterIterator.DONE){
            accepted = false;
            skipWhiteSpace();
            if (code.current() == CharacterIterator.DONE) break;

            for (AFD afd : afds){
                int pos = code.getIndex(); // salva o index inicial da parte que sendo analisada, para caso não encontrar em um determinado autômato, ele poder voltar.
                Token t = afd.evaluate(code);
                if (t != null){
                    accepted = true;
                    tokens.add(t);
                    break;
                }else {
                    code.setIndex(pos);
                }
            }

            if (accepted) continue;
            throw new RuntimeException("Error: Token not recognized: " + code.current() + " | Line: " + line + " Column: " + (code.getIndex()-lastColumn) );
        }
        tokens.add(new Token("EOF", "$"));
        return tokens;
    }
}
