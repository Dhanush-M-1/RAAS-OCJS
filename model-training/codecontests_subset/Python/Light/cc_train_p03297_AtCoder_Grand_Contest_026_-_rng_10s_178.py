T=int(input())
ABCD=[list(map(int,input().split())) for i in range(T)]
from fractions import gcd
def f(a):
    print(['No','Yes'][a])
for a,b,c,d in ABCD:
    if a<b:f(0)
    elif d<b:f(0)
    elif b<=c:f(1)
    else:
        g=gcd(b,d)
        h=a%b
        f(max(((b-h)//g*g+h)%b,b-g)<=c)