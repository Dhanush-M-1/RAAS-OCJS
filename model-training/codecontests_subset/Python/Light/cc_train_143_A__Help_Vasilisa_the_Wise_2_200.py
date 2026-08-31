from functools import reduce
from operator import *
from math import *
from sys import *
from string import *
setrecursionlimit(10**7)
dX= [ 0, 0, 1,-1, 1,-1, 1,-1]
dY= [ 1,-1, 0, 0, 1,-1,-1, 1]
RI=lambda: list(map(int,input().split()))
RS=lambda: input().rstrip().split()
#################################################
r1,r2=RI()
c1,c2=RI()
d1,d2=RI()
for a in range(1,10):
    x=(a,r1-a,c1-a,d1-a)
    if any(i<1 or i>9 for i in x) or any(x[i] in x[i+1:] for i in range(4)):
        continue
    if x[1]+x[3]==c2 and x[1]+x[2]==d2 and x[2]+x[3]==r2:
        print(*(x[:2]))
        print(*(x[2:]))
        exit(0)
print(-1)


