#include <stdio.h>

int main() {
    int n ;
    printf ( "Digite um número maior que 0\n" ) ;
    scanf ( "%d", &n ) ;
    if ( n <= 0 ) {
        printf ( "O valor deve ser maior que 0\n" ) ;
    }
    else {
        int fib1 = 0 ;
        int fib2 = 1 ;
        int proximo = 1 ;
        int i = 1 ;
        printf ( "%d", fib1 ) ;
        printf ( "\n" ) ;
        for ( i ; i < n ; i ++) {
            if ( i == 1 ) {
                proximo = fib2 ;
            }
            else {
                proximo = fib1 +fib2 ;
                fib1 = fib2 ;
                fib2 = proximo ;
            }
            printf ( "%d", proximo ) ;
            printf ( "\n" ) ;
        }
    }
    return 0;
}