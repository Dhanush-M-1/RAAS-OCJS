from math import ceil
import sys
n, p, w, d = map(int, input().split())

def gcd(a : int, b : int):
    if a == 0: return (0, 1)
    (x, y) = gcd(b % a, a)
    return (y - (b // a) * x, x)

def cd(a : int, b : int):
    while b > 0:
        (a, b) = (b, a % b)
    return a

(x0, y0) = gcd(w, d)
g = cd(w, d)
if p % g > 0 :
    print(-1)
    sys.exit()
x0 *= p // g
y0 *= p // g

k = max(-x0 * g // d + (-x0 * g % d != 0), g * (n - x0 - y0) // (d - w) + (g * (n - x0 - y0) % (d - w) != 0))
if k > y0 * g // w :
    print(-1)
    sys.exit()

x = x0 + k * (d // g)
y = y0 - k * (w // g)
print(x, y, n - x - y)