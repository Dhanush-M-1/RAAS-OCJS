# Template 1.0
import sys, re, math
from collections import deque, defaultdict, Counter, OrderedDict
from math import ceil, sqrt, hypot, factorial, pi, sin, cos, radians, gcd
from heapq import heappush, heappop, heapify, nlargest, nsmallest
def STR(): return list(input())
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(): return list(map(int, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
def sortListWithIndex(listOfTuples, idx):   return (sorted(listOfTuples, key=lambda x: x[idx]))
def sortDictWithVal(passedDic):
    temp = sorted(passedDic.items(), key=lambda kv: (kv[1], kv[0]))
    toret = {}
    for tup in temp:
        toret[tup[0]] = tup[1]
    return toret
def sortDictWithKey(passedDic):
    return dict(OrderedDict(sorted(passedDic.items())))
sys.setrecursionlimit(10 ** 9)
INF = float('inf')
mod = 10 ** 9 + 7


t = INT()

while(t!=0):
    n =INT()

    a = LIST()
    foo = set()
    mx = 0
    mn = INF
    for i in range(n):
        if(a[i]==-1):
            if(i==0):
                if(a[i+1]==-1):
                    continue
                else:
                    foo.add(a[i+1])
            elif(i==n-1):
                if(a[i-1]==-1):
                    continue
                else:
                    foo.add(a[i-1])
            else:
                if(a[i+1]!=-1):
                    foo.add(a[i+1])
                if(a[i-1]!=-1):
                    foo.add(a[i-1])

    if(len(foo)!=0):
        mx = max(foo)
        mn = min(foo)
        k = (mx+mn)//2
    else:
        k = 0

    overall = 0
    for j in range(n):
        if(a[j]==-1):
            a[j]=k
    # print(a)
    for j in range(1, n):
        overall = max(overall, abs(a[j]-a[j-1]))
    print(overall, k)

    t-=1