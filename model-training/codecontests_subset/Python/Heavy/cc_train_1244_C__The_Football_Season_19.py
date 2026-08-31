def gcdExtended(a, b):  
    if a == 0 :   
        return b,0,1
    gcd,x1,y1 = gcdExtended(b%a, a)  
    x = y1 - (b//a) * x1  
    y = x1  
    return gcd,x,y 
      
n,p,w,d=map(int,input().split())

gc,x0,y0=gcdExtended(w,d)
if p%gc!=0:
    print(-1)
    exit(0)

u=p//gc
x1=x0*u
y1=y0*u
from math import ceil


r1=-x1*gc//d
r2=y1*gc//w

u=gc*(n-x1-y1)//(d-w)

xn=x1+(d*u//gc)
yn=y1-(w*u//gc)

if xn+yn<=n and xn>=0 and yn>=0:
    print(xn,yn,n-xn-yn)
    exit(0)

u=y1*gc//w
xn=x1+(d*u//gc)
yn=y1-(w*u//gc)

if xn+yn<=n and xn>=0 and yn>=0:
    print(xn,yn,n-xn-yn)
    exit(0)

u=ceil(-x1*gc//d)
xn=x1+(d*u//gc)
yn=y1-(w*u//gc)

if xn+yn<=n and xn>=0 and yn>=0:
    print(xn,yn,n-xn-yn)
    exit(0)

print(-1)