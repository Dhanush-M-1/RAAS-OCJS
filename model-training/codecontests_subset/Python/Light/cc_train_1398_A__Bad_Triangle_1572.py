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
    n = r()
    a = rl()
    ans = False
    sumi = a[0]+a[1]
    for i in range(2,n):
        if a[i]>=sumi:
            print(1,2,i+1)
            ans=True
            break
    if ans==False:
        print(-1)
