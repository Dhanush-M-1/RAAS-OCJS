def equivalent( a , b ):
    length = len( a )
    if( a == b ):
        return True
    else:

        if( ( length % 2 ) == 0 and (   (  equivalent( a[ : length//2 ] , b[ length//2 :  ] ) and equivalent( b[  : length//2  ] , a[ length//2 :  ] ) ) or 
                                        (  equivalent( a[ : length//2 ] , b[ : length//2 ]  ) and equivalent(  b[ length//2 : ] , a[ length//2 :   ] ) ) ) ):
            return True
        else:
            return False

A = input( )
B = input( )

if( equivalent( A, B ) ):
    print("YES")
else:
    print("NO")

