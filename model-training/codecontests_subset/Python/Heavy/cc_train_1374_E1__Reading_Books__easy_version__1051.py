z=input
mod = 10**9 + 7
from collections import *
from queue import *
from sys import *
from collections import *
from math import *
from heapq import *
from itertools import *
from bisect import *
from collections import Counter as cc
from math import factorial as f
def lcd(xnum1,xnum2):
    return (xnum1*xnum2//gcd(xnum1,xnum2))

################################################################################

"""

n=int(z())

for _ in range(int(z())):

x=int(z())

l=list(map(int,z().split()))

n=int(z())

l=sorted(list(map(int,z().split())))[::-1]

a,b=map(int,z().split())

l=set(map(int,z().split()))

led=(6,2,5,5,4,5,6,3,7,6)

vowel={'a':0,'e':0,'i':0,'o':0,'u':0}

color-4=["G", "GB", "YGB", "YGBI", "OYGBI" ,"OYGBIV",'ROYGBIV' ]

"""

###########################---START-CODING---###############################################
for _ in range(1):
    n,k=map(int,z().split())
    a=[]
    b=[]
    them=[]
    ta,tb,th=0,0,0
    for _ in range(n):
        c,d,e=map(int,z().split())
        if d==1 and e==1:
            them.append(c)
            th+=1
            continue
        if d==1:
            a.append(c)
            ta+=1
            continue
        if e==1:
            b.append(c)
            tb+=1
    a=sorted(a)
    b=sorted(b)
    for i in range(min(ta,tb)):
        them.append(a[i]+b[i])
    if len(them)<k:
        print(-1)
    else:
        
        print(sum(sorted(them)[:k]))
        
        

 
        



        
        
