n,a=int(input()),list(map(int,input().split()))
g=0
from math import gcd
for i in a:g=gcd(i,g)
if g!=1:print("not coprime")
else:
    from collections import defaultdict
    memo=defaultdict(int)
    for i in a:
        for p in range(2,int(i**.5)+1):
            if i%p==0:
                while i%p==0:i//=p
                if memo[p]:
                    print("setwise coprime");exit()
                memo[p]+=1
        if i!=1:
            if memo[i]:print("setwise coprime");exit()
            memo[i]+=1
    print("pairwise coprime")