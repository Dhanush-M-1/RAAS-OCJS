from functools import reduce
from operator import *
from math import *
from sys import *
from string import *
from collections import *
setrecursionlimit(10**7)
dX= [-1, 1, 0, 0,-1, 1,-1, 1]
dY= [ 0, 0,-1, 1, 1,-1,-1, 1]
RI=lambda: list(map(int,input().split()))
RS=lambda: input().rstrip().split()
#################################################
s=0
ans=0
for l in stdin:
    l=l.rstrip()
    if l[0]=='+':
        s+=1
    elif l[0]=='-':
        s-=1
    else:
        t,l = l.split(':')
        ans+=s*len(l)
print(ans)

