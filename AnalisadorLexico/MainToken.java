import Token.Token;

public class MainToken{
    public static void main (String[] args){
        Token id = new Token("ID", "3");
        Token num = new Token("NUM", "2");

        System.out.println(id);
        System.out.println(num);
    }
}