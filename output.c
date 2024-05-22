#include <stdio.h>

int main(){
int a ; int b ; int c ; double d ; printf ( "Programa Teste\n" ) ; printf ( "Digite A\n" ) ; scanf ( "%d" , &a ) ; printf ( "Digite B\n" ) ; scanf ( "%d" , &b ) ; if ( a < b ) { c = a +b ; } else { c = a -b ; } printf ( "C e igual a\n" ) ; printf ( "%d" , c ) ; d = c /( a +b ) ; printf ( "\n" ) ; printf ( "D e igual a\n" ) ; printf ( "%f" , d ) ; 
return 0;
} 