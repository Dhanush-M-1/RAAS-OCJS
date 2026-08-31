from math import *
def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = egcd(b % a, a)
        return (g, x - (b // a) * y, y)
def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m
n,p,w,d = map(int,input().split())
g = gcd(w,d)
if p % g != 0:
    print(-1)
    exit(0)
k = p//g
a = w//g
b = d//g
b_inv = modinv(b,a)
y = (k*b_inv) % a
x = (k-b*y)//a
if x+y > n or x < 0 or y < 0:
    print(-1)
else:
    print(x,y,n-(x+y))
