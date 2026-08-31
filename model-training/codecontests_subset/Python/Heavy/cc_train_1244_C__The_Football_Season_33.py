import math
import sys
from fractions import Fraction

n, p, w, d = list(map(int, input().split()))

def egcd(a, b):
    if a == 0:
        return b, 0, 1
    else:
        g, y, x = egcd(b % a, a)
        return g, x - (b // a) * y, y

g = math.gcd(w, d)

if(p % g != 0):
    print(-1)
    sys.exit(0)

_, X, Y = egcd(w, d)

m = p // g
X *= m
Y *= m

w2 = w // g
d2 = d // g

a = d2
b = X
c = -w2
e = Y

#lt = int(math.ceil(-(b / a)))
#gt = int(math.floor(-(e / c)))

lt = math.ceil(Fraction(-b, a))
gt = math.floor(Fraction(-e, c))

if(gt < lt):
    print(-1)
    sys.exit(0)

tans = gt
x = int(a * tans + b)
y = int(c * tans + e)
z = n - x - y

if(z < 0):
    print(-1)
else:
    print(x, y, z)

