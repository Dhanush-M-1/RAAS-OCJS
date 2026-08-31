memo = {}

def equivalent( a , b ):
    length = len( a )
    
    if( (a,b) in memo ):
        return memo[ (a,b) ]

    if( a == b ):
        memo[ (a,b) ] = True
        return True
    else:
        if( length % 2 != 0 ):
            memo[ (a,b) ] = False
            return False
        else:

            if( (  equivalent( a[ : length//2 ] , b[ : length//2 ]  ) and equivalent( a[ length//2 :   ] , b[ length//2 : ] ) ) or 
                (  equivalent( a[ : length//2 ] , b[ length//2 :  ]  ) and equivalent( a[ length//2 :  ] , b[  : length//2  ] ) ) ):
                memo[ (a,b) ] = True
                return True

A = input( )
B = input( )

if( equivalent( A, B ) ):
    print("YES")
else:
    print("NO")

