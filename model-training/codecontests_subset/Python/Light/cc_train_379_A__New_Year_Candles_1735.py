#!/usr/bin/env python

def main( ):
    a, b = map( int, input( ).split( ) )
    res = a

    while True:
        newC = a // b
        if newC == 0:
            print( res )
            return
        res += newC
        a -= newC * b
        a += newC


if __name__ == '__main__':
    main( )

