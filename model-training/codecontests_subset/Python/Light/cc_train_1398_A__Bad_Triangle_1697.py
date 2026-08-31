import math,sys
from sys import stdin,stdout
from collections import Counter, defaultdict, deque
input = stdin.readline
I = lambda:int(input())
li = lambda:list(map(int,input().split()))

def solve():
    n=I()
    a=li()
    p,q,r=a[0],a[1],a[-1]
    if(p+q<=r):
        print(1,2,n)
    else:
        print(-1)
for _ in range(I()):
    solve()