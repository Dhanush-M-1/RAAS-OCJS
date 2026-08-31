import sys

def gcd(a, b) :
    if (b == 0) :
        return a
    return gcd(b, a % b)

def exgcd(a, b) :
    if (b == 0) :
        return 1, 0
    y, x = exgcd(b, a % b)
    y -= a // b * x
    return x, y

n, p, w, d = map(int, input().split())

g = gcd(w, d)

if p % g != 0:
    print("-1")
    exit(0)

p = p // g
w = w // g
d = d // g

x, y = exgcd(w, d)
y = y * p

y = (y % w + w) % w
x = (p - y * d) // w
z = n - x - y

if x >= 0 and y >= 0 and z >= 0 :
    print("{} {} {}".format(x, y, z))
else :
    print("-1")
