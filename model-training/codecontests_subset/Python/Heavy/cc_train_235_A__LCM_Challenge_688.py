n = int( input() )

if n == 1:
    print( 1 )
    exit(0)
elif n == 2:
    print( 2 )
    exit(0)
    
def gcd( a, b ):
    if b == 0:
        return ( a )
    return ( gcd( b, a%b ) )
    
def lcm( a, b ):
    return ( a * b // gcd(a,b) )
    
if n % 2 == 1:
    ans = lcm( n, lcm( n-2, n-1 ) )
else:
    ans = 0
    lo = max(1,n-50)
    for i in range( lo, n+1 ):
        for j in range( lo, n+1 ):
            for k in range( lo, n+1 ):
                ans = max( ans, lcm( i, lcm(j,k) ) )
    
print( ans )