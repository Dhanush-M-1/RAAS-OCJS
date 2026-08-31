import math
a,b=[int(i) for i in input( ).split( )]
s=a
c=0
while c>=0:
    if math.floor(s/b)==0:
        print(a+c)
        exit( )
    else:
        c+=math.floor(s/b)
        s-=(b-1)*math.floor(s/b)

    
    
