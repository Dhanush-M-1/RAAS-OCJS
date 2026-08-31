f = lambda: map ( int , input ( ) . split ( ) )

n , k = f ( )
ll = max(a for a in f() if not k % a)
print ( k // ll )

