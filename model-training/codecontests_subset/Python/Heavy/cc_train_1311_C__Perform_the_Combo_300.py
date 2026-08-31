def R(): return map(int, input().split())
def I(): return int(input())
def S(): return str(input())

def L(): return list(R())

from collections import Counter 

import math
import sys

from itertools import permutations

import bisect

for _ in range(I()):
    n,m=R()
    s=S()
    p=L()
    p.append(n)

    p.sort()
    sump=[0]*(m+2)
    more=[0]*(n+2)

    for i in range(m+1):
        more[p[i]-1]+=1

    for i in range(n,-1,-1):
        more[i]=more[i+1]+more[i]
   

    cnt=[0]*26
    j=-1
    for a in s:
        j+=1
        cnt[ord(a)-ord('a')]+=more[j]

    print(*cnt)
