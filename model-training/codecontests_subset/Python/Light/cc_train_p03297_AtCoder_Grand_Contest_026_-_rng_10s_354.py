import sys
input = sys.stdin.readline
from fractions import gcd
def f(a,b,c,d):
    if a<b:
        return 0
    if b>d:
        return 0
    if b<=c:
        return 1
    x=a%b
    g=gcd(b,d)
    if c>=b-g+(x%g):
        return 1
    else:
        return 0
T=int(input())
X=[[int(i) for i in input().split()] for i in range(T)]
for a,b,c,d in X:
    s=f(a,b,c,d)
    if s:
        print('Yes')
    else:
        print('No')


