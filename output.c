#include <stdio.h>

int main() {
    int numero ;
    int fatorial = 1 ;
    printf ( "Digite um numero " ) ;
    scanf ( "%d", &numero ) ;
    int i = 1 ;
    for ( i ; i <= numero ; i ++) {
        fatorial = fatorial *i ;
    }
    printf ( "O fatorial do numero é " ) ;
    printf ( "%d", fatorial ) ;
    return 0;
}