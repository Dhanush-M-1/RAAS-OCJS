import os
import sys
import math
import heapq
from decimal import *
from io import BytesIO, IOBase
from collections import defaultdict, deque

def r():
    return int(input())
def rm():
    return map(int,input().split())
def rl():
    return list(map(int,input().split()))

for _ in range(r()):
    na,nb=rm()
    a=rl()
    b=rl()
    haveA=defaultdict(int)
    for i in a:
        haveA[i]=1
    res=False
    for i in b:
        if haveA[i]==1:
            ans=i
            res=True
            break
    if res:
        print("YES")
        print(1,ans)
    else:
        print("NO")
