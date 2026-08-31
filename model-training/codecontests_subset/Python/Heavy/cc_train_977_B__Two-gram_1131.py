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
def prime(x):
        p=ceil(x**.5)+1
        for i in range(2,p):
            if x%i==0:
                return 0
        return 1

################################################################################

"""
l=sorted(list(map(int,z().split())))[::-1]

a,b=map(int,z().split())

l=set(map(int,z().split()))

led=(6,2,5,5,4,5,6,3,7,6)

vowel={'a':0,'e':0,'i':0,'o':0,'u':0}

color4=["G", "GB", "YGB", "YGBI", "OYGBI" ,"OYGBIV",'ROYGBIV' ]

"""

###########################---START-CODING---###############################################

n=int(z())
l=z()
ans={}

for i in range(n-1):
    x=l[i:i+2]
    try:
        ans[x]+=1
    except:
        ans[x]=1


va=list(ans.values())
x=max(va)

t=va.index(x)
print(list(ans)[t])


    
