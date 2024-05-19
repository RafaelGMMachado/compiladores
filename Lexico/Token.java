package Lexico;

public class Token {
    String tipo;
    String lexema;

    public Token(String tipo, String lexema){
        this.lexema = lexema;
        this.tipo = tipo;
    }

    public String getLexema(){
        return lexema;
    }

    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "<" + tipo + ", " + lexema + ">";
    }
}