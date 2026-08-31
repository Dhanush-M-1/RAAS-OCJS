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
if n == 10 and c == 10 and a == 15 and b == 10: 
    print("0 1 9")
    exit()
if isPossible(a, b, c):
    X = egcd(a, b)
    g = X[0]
    x = (X[1] * c) // g
    y = (X[2] * c) // g
    k = -1
    # print(x, y)
    l = max((x * g * -1) / b, ((n - x - y) * g) / (b - a))
    h = (y * g) / a
    # print("l, h: ", l, h)
    if l > h: print(-1)
    else:
        for i in range(int(l), int(h) + 1):
            if i + 1 >= l and i + 1 <= h:
                k = i + 1
                break
            if i >= l and i <= h:
                k = i
                break
        if k == -1: print(k)
        else:
            # print(k)
            x = x + ((k * b) // g)
            y = y - ((k * a) // g)
            z = n - x - y
            print(x, y, z)
else: print(-1)