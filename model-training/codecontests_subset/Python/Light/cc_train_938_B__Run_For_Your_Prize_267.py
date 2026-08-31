
import sys
import os
import math
import re


n = int(input())

p = list(map(int,input().split()))

c1 = 1
c2 = 10**6
larg = max(p)
if larg < ((10**6)//2):
    soln = larg-1
    print(soln)
    exit(0)
sm = min(p)
if sm > ((10**6)//2):
    soln = 10**6-sm
    print(soln)
    exit(0)

l = 0
r = 10**6
for val in p:
    if val > l and val <= (10**6//2):
        l = val
    if val < r and val > (10**6//2):
        r = val

if l - 1 > 10**6 - r:
    soln = l-1
    print(soln)
else:
    soln = 10**6 - r
    print(soln)
