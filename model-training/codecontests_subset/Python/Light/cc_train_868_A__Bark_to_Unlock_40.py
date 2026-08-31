s = input ()
n = int ( input ())
l = []
c , p = 0 , 0
for i in range ( n ):
    l . append ( input ())
if s in l :
    print ( "Yes" )
else :    
    for i in l :
        if ( i [ 0 ] == s [ 1 ]):
            c+=1
            break
    for i in l :    
        if ( i [ 1 ] == s [ 0 ]):
            p+=1
            break
    if ( c == 1 and p == 1 ): 
        print ( "Yes" )
    else :
        print ( "No" )