import sys

sys.setrecursionlimit(10**5)
int1 = lambda x: int(x)-1
p2D = lambda x: print(*x, sep="\n")
def II(): return int(sys.stdin.readline())
def MI(): return map(int, sys.stdin.readline().split())
def LI(): return list(map(int, sys.stdin.readline().split()))
def LLI(rows_number): return [LI() for _ in range(rows_number)]
def SI(): return sys.stdin.readline()[:-1]

from heapq import *

def nCr(com_n, com_r):
    if com_n < com_r: return 0
    return fac[com_n] * ifac[com_r] % md * ifac[com_n - com_r] % md

md=998244353
n_max = 300005
fac = [1]
for i in range(1, n_max + 1): fac.append(fac[-1] * i % md)
ifac = [1] * (n_max + 1)
ifac[n_max] = pow(fac[n_max], md - 2, md)
for i in range(n_max - 1, 1, -1): ifac[i] = ifac[i + 1] * (i + 1) % md

n,k=MI()
hp=[]
for _ in range(n):
    l,r=MI()
    heappush(hp,(l,0))
    heappush(hp,(r,1))
ans=0
now=0
while hp:
    p,t=heappop(hp)
    if t:now-=1
    else:
        ans+=nCr(now,k-1)
        ans%=md
        now+=1

print(ans)
