import sys
import math

n, p, w, d = map( int, input().split() )

#print(n, p, w, d)



if p > d*n and p > w*n:
	print(-1)
	sys.exit(0)

if p % math.gcd( w, d ) != 0:
	print(-1)
	sys.exit(0)

def diaf (A, B):
	x1, y1, x2, y2 = 1, 0, 0, 1
	N, M = A, B
	while M != 0:
		Q = N // M
		R = N % M
		N, M = M, R
		x, y = x2, y2
		x2, y2 = x1 - Q*x2, y1 - Q*y2;
		x1, y1 = x, y
	
	return x1, y1

g = math.gcd( w, d )
x, y = diaf( w, d )
x *= p // g
y *= p // g

k = y * g // w
x += k * d // g
y -= k * w // g
z = n - x - y
if z >= 0 and x >= 0 and y >= 0 :
	print(x, y, z)
else:
	print(-1)
'''
    int g = gcd(w, d);
    qq[x, y] = diaf(w, d);
    x *= p / g;
    y *= p / g;
    
    int k = floor( 1.0 * y * g / w );
    x += k * (d / g);
    y -= k * (w / g);
    int z = n - x - y;
    if( z >= 0 ) {
        cout << x << sp << y << sp << z;
    }
    else {
        cout << -1;
    }
'''