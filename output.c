#include <stdio.h>

int main() {
    int a ;
    int b ;
    int c ;
    float d ;
    printf ( " Programa Teste " ) ;
    printf ( " Digite A " ) ;
    scanf ( " %d ", &a ) ;
    printf ( " Digite B " ) ;
    scanf ( " %d ", &b ) ;
    if ( a < b ) {
        c = a + b ;
    }
    else {
        c = a - b ;
    }
    printf ( " C e igual a " ) ;
    printf ( " %d ", c ) ;
    d = c / ( a + b ) ;
    printf ( " D e igual a " ) ;
    printf ( " %f ", d ) ;
    return 0;
}