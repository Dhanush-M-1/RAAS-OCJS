from sys import stdin
from collections import deque
from math import sqrt, floor, ceil, log, log2, log10, pi, gcd, sin, cos, asin
def ii(): return int(stdin.readline())
def fi(): return float(stdin.readline())
def mi(): return map(int, stdin.readline().split())
def fmi(): return map(float, stdin.readline().split())
def li(): return list(mi())
def lsi():
    x=list(stdin.readline())
    x.pop()
    return x
def si(): return stdin.readline()
res=['YES', 'NO']
############# CODE STARTS HERE #############
for _ in range(ii()):
    n, l, r=mi()
    if l==n*(n-1)+1:
        print(1)
        continue
    x, p=1, n*2
    while x<=l:
        p-=2
        x+=p
    #print(x, p)
    x-=p
    p=n*2-p
    p//=2
    #print(x, p)
    a=[]
    dl=l-x+1
    z=p+((dl+1)//2)
    if not dl%2:
        a.append(z)
        l+=1
        z+=1
        if z>n:
            p+=1
            z=p+1
    #print(a)
    #print(p, z)
    while l<=r:
        a.append(p)
        l+=1
        if l<=r:
            a.append(z)
            l+=1
            z+=1
            if z>n:
                p+=1
                z=p+1
    if r==n*(n-1)+1:
        a[-1]=1
    print(*a)