import math
import sys
from collections import defaultdict,Counter,deque,OrderedDict
import bisect
#sys.setrecursionlimit(1000000)
input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
ilele = lambda: map(int,input().split())
alele = lambda: list(map(int, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
#def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
#INF = 10 ** 18
#MOD = 1000000000 + 7
from itertools import accumulate,groupby

for _ in range(int(input())):
    n,l,r = ilele()
    z = n*(n-1)+ 1
    if (l==r and l == z) or (r==1) :
        print(1)
        continue
    k = n-1;tot = 0;f=0
    while tot < l and k>0:
        f+=1
        tot += 2*k
        k-=1
        
    #print(f,tot)
    tot -= 2*(k+1)
    tot += 1
    Ans = []
    g=0;C=[];m=0;h = f+1;i=tot
    while i<r+1 and i<z :
        if g==0:
            if i==l:
                g=1
            if m%2==0:
                C.append(f)
            else:
                if h<n:
                    C.append(h)
                    h+=1
                else:
                    C.append(h)
                    f+=1
                    h = f+1
            if g==1:
                Ans.append(C[-1])
        elif g==1:
            if m%2==0:
                Ans.append(f)
            else:
                if h<n:
                    Ans.append(h)
                    h+=1
                else:
                    Ans.append(h)
                    f+=1
                    h = f+1
        m+=1
        i+=1
    if r==z:
        Ans.append(1)
    #print(C,Ans)
    print(*Ans)
            
        