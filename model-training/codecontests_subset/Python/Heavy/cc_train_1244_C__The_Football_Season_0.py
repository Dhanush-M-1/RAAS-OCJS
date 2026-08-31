import sys
from sys import argv

def extendedEuclideanAlgorithm(old_r, r):
    negative = False
    s, old_t = 0, 0
    old_s, t = 1, 1

    if (r < 0):
        r = abs(r)
        negative = True
        
    while r > 0:
        q = old_r // r
        #MCD:
        r, old_r = old_r - q * r, r
        #Coeficiente s:
        s, old_s = old_s - q * s, s
        #Coeficiente t:
        t, old_t = old_t - q * t, t
        
    if negative:
        old_t = old_t * -1
        
    return old_r, old_s, old_t


n, p, w, d = [int(i) for i in input().split()]


mcd, s, t = extendedEuclideanAlgorithm(w, d)
if p % mcd == 0:
    a1, b1, c1 = -w // mcd, d // mcd, p // mcd
    x1, y1 = s * c1, t * c1

    k = y1 * mcd // w
    x0 = x1 + (d * k) // mcd
    y0 = y1 - (w * k) // mcd
        
    if x0 + y0 <= n and x0 >= 0 and y0 >= 0:
        print(x0, y0, n - x0 - y0)
    else:
        print(-1)
else:
    print(-1)