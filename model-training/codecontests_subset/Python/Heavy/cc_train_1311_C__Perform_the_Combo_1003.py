from functools import reduce
import os
import sys
from math import *
from collections import *
from fractions import *
from bisect import *
from heapq import *
from io import BytesIO, IOBase
input = lambda: sys.stdin.readline().rstrip("\r\n")
def value(): return tuple(map(int, input().split()))
def arr(): return [int(i) for i in input().split()]
def sarr(): return [int(i) for i in input()]
def starr(): return [str(x) for x in input().split()]
def inn(): return int(input())
def svalue(): return tuple(map(str, input().split()))
mo = 1000000007
# ----------------------------CODE------------------------------#
for _ in range(inn()):
    n,m=value()
    s=input()
    a=arr()
    d=defaultdict(list)
    ans = {chr(i): 0 for i in range(97, 123)}
    for i in range(97,123):
        d[chr(i)]=[0]*(n)
    d[s[0]][0]+=1
    ans[s[0]]+=1
    for i in range(1,n):
        ans[s[i]]+=1
        for j in range(97,123):
            if(chr(j) == s[i]):
                d[chr(j)][i]=d[chr(j)][i-1]+1
            else:
                d[chr(j)][i]=d[chr(j)][i-1]
    #print(d)
    for i in range(m):
        k=a[i]-1
        for j in range(97,123):
            ans[chr(j)]+=d[chr(j)][k]
    for i in ans:
        print(ans[i],end=" ")
    print()




