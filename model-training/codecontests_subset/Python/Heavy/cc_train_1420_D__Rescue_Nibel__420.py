import sys
import io, os
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

n,k=map(int,input().split())
mod=998244353

Combi=[1]*(n+1) # Combi[i]=iCnを表す.kは必要な分だけ.
Combi[k-1]=1
for i in range(k,n+1):
    Combi[i]=Combi[i-1]*i*pow(i-(k-1),mod-2,mod) %mod

LAMPS=[]

for i in range(n):
    l,r=map(int,input().split())
    LAMPS.append((l,0))
    LAMPS.append((r,1))

from operator import itemgetter

LAMPS.sort(key=itemgetter(1))
LAMPS.sort(key=itemgetter(0))

NOW=0
ANS=0

for l,t in LAMPS:
    if t==0:
        if NOW>=k-1:
            ANS=ANS+Combi[NOW]
            ANS%=mod
        NOW+=1
    else:
        NOW-=1

print(ANS)
        
