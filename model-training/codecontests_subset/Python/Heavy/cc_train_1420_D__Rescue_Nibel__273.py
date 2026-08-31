import sys
import math
input = sys.stdin.readline
 
n,q = list(map(int, input().split()))
 
pre = {}
pre[0] = 1
pre[1] = 1
mod = 998244353
 
def ncr(n, r, p, pre): 
    #num = n!
    #den = k! * (n-k)!
    
    num = pre[n]
    den = pre[r] * pre[n-r]
    den = den % p
    
    return (num * pow(den,  
            p - 2, p)) % p 
 
for i in range(1+1, n+1):
    pre[i] = pre[i-1] * i
    pre[i] = pre[i] % mod
    
precalc = {}
 
ll = []
rr = []
aa = []
 
for _ in range(n):
    l,r = list(map(int, input().split()))
    ll.append(l)
    rr.append(r)
    aa.append(l)
    aa.append(r)
    
#aa = list(set(aa))
 
ll.sort()
rr.sort()
aa.sort()
 
i = 0
j = 0
open = 0
last = 0
 
total = 0
 
 
for num in aa:
    kb = 0
    while i<len(ll) and num==ll[i]:
        i += 1
        open += 1
        kb+=1

    if kb>0:
        if open>=q:
            last = open - kb
            if last<q:
                cr = 0
            else:
                if (last,q) not in precalc:
                    cr = (ncr(last, q, mod, pre))
                    precalc[(last,q)] = cr
                else:
                    cr = precalc[(last,q)]
      
            if (open,q) not in precalc:
                br = (ncr(open, q, mod, pre))
                precalc[(open,q)] = br
            else:
                br = precalc[(open,q)]
                
            total += br - cr

    while j<len(rr) and num==rr[j]:
        j += 1
        open -= 1
 
total = total % mod
print(total)