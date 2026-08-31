import heapq
import sys
input=sys.stdin.readline
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
mod=998244353
n,k=map(int,input().split())
heap,store=[],[]
comb=Combination(5*10**5,mod)
for ii in range(n):
    l,r=map(int,input().split())
    store.append((l,r))
store.sort()
ans=0
for i in range(n):
    heapq.heappush(heap,store[i][1])
    while store[i][0]>heap[0]:
        heapq.heappop(heap)
    #clever way to find the combination of a series without having
    #to worry about counting some combinations twice
    if k!=2:
        ans+=comb.combination(len(heap)-1,k-1)
        #print(len(heap),ans)
    else:
        ans+=len(heap)-1
    ans%=mod
        
sys.stdout.write(str(ans)+'\n')
            
