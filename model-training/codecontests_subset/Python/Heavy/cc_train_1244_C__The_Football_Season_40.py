import math
def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, x, y = egcd(b % a, a)
        return (g, y - (b // a) * x, x)

from math import gcd 
def isPossible(a, b, c): 
    return (c % gcd(a, b) == 0)
    
n, c, a, b = [int(x) for x in input().split()]
if isPossible(a, b, c):
    X = egcd(a, b)
    # print(X)
    g = X[0]
    x = X[1] * c // g
    y = X[2] * c // g
    # k = -1
    # print(x, y)
    l = int(math.ceil(-1 * y * g / a - 1e-8))
    h = int(min(math.floor(x * g / b + 1e-8), math.floor((n - x - y) * g / (a - b) + 1e-8)))
    # h = math.floor(h)
    # print("l, h: ", l, h)
    if l > h: print(-1)
    else:
        if l + 1 >= l and l + 1 <= h: l = l + 1
        x = x - ((l * b) // g)
        y = y + ((l * a) // g)
        z = n - x - y
        print(x, y, z)
else: print(-1)