from math import *
from collections import *
from operator import itemgetter
import bisect
ii = lambda: int(input())
iia = lambda: list(map(int,input().split()))
isa = lambda: list(input().split())
I = lambda:list(map(int,input().split()))
chrIdx = lambda x: ord(x)-96
idxChr = lambda x: chr(96+x)

t = ii()

for _ in range(t):
    n = ii()
    a = []
    for i in range(n):
        a.append(iia())
    flag = 'YES'
    if(a[0][0]>=a[0][1]):
        flag = 'YES'
    else:
        flag = 'NO'
    for i in range(1,n):
        if(a[i][0]<a[i-1][0] or a[i][1]<a[i-1][1] or a[i][0]-a[i-1][0]<a[i][1]-a[i-1][1]):
            flag = "NO"
            break
    print(flag)
