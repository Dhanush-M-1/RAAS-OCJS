# Author : -pratyay-
import sys
inp=sys.stdin.buffer.readline
inar=lambda: list(map(int,inp().split()))
inin=lambda: int(inp())
inst=lambda: inp().decode().strip()

#This class is taken from : https://codeforces.com/contest/1420/submission/93686360
class Combination:
    def __init__(self, n, MOD):
        self.fact = [1]
        for i in range(1, n + 1):
            self.fact.append(self.fact[-1] * i % MOD)
        self.inv_fact = [0] * (n + 1)
        self.inv_fact[n] = pow(self.fact[n], MOD - 2, MOD)
        for i in reversed(range(n)):
            self.inv_fact[i] = self.inv_fact[i + 1] * (i + 1) % MOD
        self.MOD = MOD
 
    def inverse(self, k):
        return (self.inv_fact[k] * self.fact[k - 1]) % self.MOD
 
    def factorial(self, k):
        return self.fact[k]
 
    def inverse_factorial(self, k):
        return self.inv_fact[k]
 
    def permutation(self, k, r):
        if k < r:
            return 0
        return (self.fact[k] * self.inv_fact[k - r]) % self.MOD
 
    def combination(self, k, r):
        if k < r:
            return 0
        return (self.fact[k] * self.inv_fact[k - r] * self.inv_fact[r]) % self.MOD


_T_=1
MOD=998244353
for _t_ in range(_T_):
    n,k=inar()
    events=[]
    for i in range(n):
        l,r=inar()
        events.append(2*l+0)
        events.append(2*r+1)
    events.sort()
    lighted_candles=0
    ans=0
    C=Combination(4 * 10**5,MOD)
    for ev in events:
        if ev&1==0:
            lighted_candles+=1
            ans+=C.combination(lighted_candles-1,k-1)
            ans%=MOD
        else:
            lighted_candles-=1
    print(ans)
