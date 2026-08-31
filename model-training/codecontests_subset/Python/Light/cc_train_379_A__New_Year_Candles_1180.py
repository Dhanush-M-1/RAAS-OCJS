a,b = list( map( int, input().split() ) )
k = 0
s = a
q = 0
while s > 0:
    k += s
    q += s
    s = q // b
    q = q - s * b 
print( k )