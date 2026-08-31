
import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log2, ceil,pi,sin,cos,acos,atan
from collections import defaultdict as dd
from bisect import bisect_left as bl, bisect_right as br
from bisect import insort
from collections import Counter
from collections import deque
from heapq import heappush,heappop,heapify
from itertools import permutations,combinations
mod = int(1e9)+7
mod2 = 998244353

 
ip = lambda : int(stdin.readline())
inp = lambda: map(int,stdin.readline().split())
ips = lambda: stdin.readline().rstrip()
out = lambda x : stdout.write(str(x)+"\n")


def ncr(n, r, p):  
   # num = den = 1
    num = fac[n]
    den = (fac[r]*fac[n-r])%p
    #for i in range(r): 
        #num = (num * (n - i)) % p 
        #den = (den * (i + 1)) % p 
    return (num * pow(den,p - 2, p)) % p

const = 300001
fac = [0]*const
fac[0] = 1
cal = 1
for i in range(1,const):
    cal = (cal*i)%mod2
    fac[i] = cal

t = 1
for _ in range(t):
    n,k = inp()
    request = []
    for i in range(n):
        l,r = inp()
        request.append(2*l)
        request.append(2*r+1)
    request.sort()
    cur = 0
    ans = 0
    for i in request:
        if i&1 == 0:
            if cur>= k-1:
                ans += ncr(cur,k-1,mod2)
                ans %= mod2
            cur += 1
        else:
            cur -= 1
    out(ans)
    
    
   
        
            
                        
                
    

            
    
    



