import sys
input = sys.stdin.readline
from fractions import gcd
def f(a,b,c,d):
    if a<b:
        return 0
    if b>d:
        return 0
    if b-1<=c:
        return 1
    x=a%b
    #print(3)
    if b==d:
        if c<x:
            return 0
        elif c>=x:
            return 1
    #print(4)
    if c<x:
        return 0
    e=(d-b)%b
    d1=gcd(e,b)
    q=(c+1-x)//d1
    q1=(b-1-x)//d1
    #print(d1,q,q1,x,(c+1-x)%d1)
    if q<q1:
        return 0
    if (c+1-x)%d1==0:
        return 0
    return 1
T=int(input())
X=[[int(i) for i in input().split()] for i in range(T)]
for a,b,c,d in X:
    s=f(a,b,c,d)
    if s:
        print('Yes')
    else:
        print('No')


