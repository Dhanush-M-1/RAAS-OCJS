import math
from decimal import Decimal
def gcd(a, b):
    if (a == 0):
        x = Decimal(0)
        y = Decimal(1)
        return b,x,y
    d,x1,y1 = gcd(b%a, a)
    x = y1 - (b // a) * x1
    y = x1
    return d,x,y

def find_any_solution(a, b, c):
    g,x0,y0 = gcd(a, b)
    if (c % g):
        return False

    x0 *= c // g
    y0 *= c // g
    if (a < 0):
         x0 = -x0
    if (b < 0):
        y0 = -y0
    return g,x0,y0


n,p,w,d = list(map(int, input().split()))
n=Decimal(n)
p=Decimal(p)
w=Decimal(w)
d=Decimal(d)

if not find_any_solution(w,d,p):
    print(-1)
else:
    g,x0,y0 = find_any_solution(w,d,p)
    if y0<0:
        k = math.ceil((-y0*g)/w)
        y0+=(w//g)*k
        x0-=(d//g)*k
        if x0<0:
            print(-1)
            exit(0)
    elif x0<0:
        k = math.ceil((-x0*g)/d)
        x0 += k*(d//g)
        y0 -= k*(w//g)
        if y0<0:
            print(-1)
            exit(0)
    
    k = -y0*g/w
    if k != int(k):
        k = math.ceil(k)
    else:
        k = int(k)
    y0+=(w//g*k)
    x0-=(d//g*k)

    if x0+y0 > n:
        print(-1)
    else:
        print(x0,y0,n-x0-y0)

