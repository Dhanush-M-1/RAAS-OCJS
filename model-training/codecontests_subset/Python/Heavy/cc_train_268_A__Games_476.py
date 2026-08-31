import sys
from math import ceil,log


RI = lambda : [int(x) for x in sys.stdin.readline().split()]
ri = lambda : sys.stdin.readline().strip()

def input(): return sys.stdin.readline().strip()
def list2d(a, b, c): return [[c] * b for i in range(a)]
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
def list4d(a, b, c, d, e): return [[[[e] * d for j in range(c)] for j in range(b)] for i in range(a)]
def ceil(x, y=1): return int(-(-x // y))
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(N=None): return list(MAP()) if N is None else [INT() for i in range(N)]
def Yes(): print('Yes')
def No(): print('No')
def YES(): print('Yes')
def NO(): print('No')
INF = 10 ** 18
MOD = 10 ** 9 + 7


n = int(ri())
dic1 = {}
dic2 = {}
h = []
g = []
for i in range(n):
    h1,g1  = RI()
    h.append(h1)
    g.append(g1)
    if h1 in dic1 : 
        dic1[h1]+=1
    else:
        dic1[h1]=1
    if g1 in dic2 : 
        dic2[g1]+=1
    else:
        dic2[g1]=1
cnt = 0
for i in range(n):
    cnt+=(dic2.get(h[i],0) -( 1 if g[i] == h[i] else 0))

print(cnt)