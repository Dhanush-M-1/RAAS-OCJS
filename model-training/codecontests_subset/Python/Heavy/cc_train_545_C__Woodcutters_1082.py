import sys
import bisect
from collections import deque
# from math import ceil,log,gcd,sqrt
# sys.setrecursionlimit(10**9)

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
def YES(): print('YES')
def NO(): print('NO')
INF = 10 ** 18
MOD = 10 ** 9 + 7

n = int(ri())
pos = [-1]*n
a = [-1]*n

for i in range(n):
    l,b = RI()
    pos[i] = l
    a[i] = b
if n == 1:
    print(1)
    exit()
cnt =2
cur = pos[0]
for i in range(1,n-1):
    if pos[i]-a[i] > cur:
        cnt+=1
        cur = pos[i]
    elif pos[i] + a[i] < pos[i+1]:
        cnt+=1
        cur = pos[i]+a[i]
    else:
        cur = pos[i]
print(cnt)