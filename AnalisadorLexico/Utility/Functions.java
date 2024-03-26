package Utility;

import java.text.CharacterIterator;

public class Functions {
    private static char[] validacoes = {' ', '+', '-', '*', '/', '(', ')', '{', '}', ';', '\n' , CharacterIterator.DONE};
    
    public static boolean validateEnd(CharacterIterator code){

        for (char validacao : validacoes){
            if (code.current() == validacao)
                return true;
        }
        return false;
    }
}
