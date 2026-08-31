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

n = r()
a = input()
num = defaultdict(int)
for i in range(n):
    num[int(a[i])]+=1
if num[8]==0:
    print(0)
else:
    tot=n-num[8]
    strips=tot//10
    rem=tot%10
    if num[8]<=strips:
        print(num[8])
    else:
        ans=strips
        num[8]-=strips
        ans+=num[8]//11
        num[8]%=11
        ans+=(1 if (rem+num[8]-1)>=10 else 0)
        print(ans)