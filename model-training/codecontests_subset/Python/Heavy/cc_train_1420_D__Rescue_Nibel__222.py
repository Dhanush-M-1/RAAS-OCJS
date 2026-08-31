import sys, math
import io, os
#data = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from bisect import bisect_left as bl, bisect_right as br, insort
from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque, Counter
# from itertools import permutations,combinations
def data(): return sys.stdin.readline().strip()
def mdata(): return list(map(int, data().split()))
def outl(var): sys.stdout.write('\n'.join(map(str, var)) + '\n')
def out(var): sys.stdout.write(str(var) + '\n')
from decimal import Decimal
# from fractions import Fraction
# sys.setrecursionlimit(100000)
mod = 998244353
INF=float('inf')

def make_nCr_mod(max_n, mod):
    max_n = min(max_n, mod - 1)

    fact, inv_fact = [0] * (max_n + 1), [0] * (max_n + 1)
    fact[0] = 1
    for i in range(max_n):
        fact[i + 1] = fact[i] * (i + 1) % mod

    inv_fact[-1] = pow(fact[-1], mod - 2, mod)
    for i in reversed(range(max_n)):
        inv_fact[i] = inv_fact[i + 1] * (i + 1) % mod

    def nCr_mod(n, r):
        res = 1
        while n or r:
            a, b = n % mod, r % mod
            if a < b:
                return 0
            res = res * fact[a] % mod * inv_fact[b] % mod * inv_fact[a - b] % mod
            n //= mod
            r //= mod
        return res

    return nCr_mod


n,k=mdata()
q=sorted([mdata() for i in range(n)],key=lambda x:x[0])
lis=[]
if k==1:
    out(n)
    exit()
f=[1]
for i in range(1,n+1):
    f.append((i*f[-1])%mod)
p=pow(f[k-1],mod-2,mod)
heappush(lis,q[0][1])
ans=0
C=make_nCr_mod(n,mod)
for i in range(1,n):
    while lis and lis[0]<q[i][0]:
        heappop(lis)
    if len(lis)>=k-1:
        ans=(ans+C(len(lis),k-1))%mod
    heappush(lis,q[i][1])
out(ans)
