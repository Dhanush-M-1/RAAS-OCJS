#This code is contributed by Siddharth
from bisect import *
import math
from collections import *
from heapq import *
from itertools import *
inf=10**18
mod=10**9+7

# ---------------------------------------------------------Code---------------------------------------------------------



def prime(n):
    if n==1:
        return False
    i=2
    while i*i<=n:
        if n%i==0:
            return False
        i+=1
    return True




a1,b1=map(int,input().split())
a=a1
b=b1
rem=defaultdict(int)
rem[3]=rem[5]=rem[2]=1
dica=defaultdict(int)
dicb=defaultdict(int)

if not prime(a):
    i=2
    while a>1:
        if a%i==0:
            while (a%i==0):
                a//=i
                dica[i]+=1
        else:
            i+=1
else:
    dica[a1]=1


if not prime(b):
    i=2
    while b>1:
        if b%i==0:
            while (b%i==0):
                b//=i
                if dica[i]:
                    dica[i]-=1
                else:
                    dicb[i]+=1
        else:
            i+=1
else:
    if dica[b1]:
        dica[b1]-=1
    else:
        dicb[b1]=1
ans=0
bol=True
for i in dica:
    if dica[i]:
        if rem[i]:
            ans+=dica[i]
        else:
            bol=False
            break

bolo=True
for i in dicb:
    if dicb[i]:
        if rem[i]:
            ans+=dicb[i]
        else:
            bolo=False
            break


if bol and bolo:
    print(ans)
else:
    print(-1)



















