'''
@sksshivam007 - Template 1.0
'''
import sys, re, math
from collections import deque, defaultdict, Counter, OrderedDict
from math import ceil, sqrt, hypot, factorial, pi, sin, cos, radians
from queue import Queue
from heapq import heappush, heappop, heapify, nlargest, nsmallest
def STR(): return list(input())
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(): return list(map(int, input().split()))
def list2d(a, b, c): return [[c] * b for i in range(a)]
def sortListWithIndex(listOfTuples, idx):   return (sorted(listOfTuples, key=lambda x: x[idx]))
def sortDictWithVal(passedDic):
    temp = sorted(passedDic.items(), key=lambda kv: (kv[1], kv[0]))[::-1]
    toret = {}
    for tup in temp:
        toret[tup[0]] = tup[1]
    return toret
def sortDictWithKey(passedDic):
    return dict(OrderedDict(sorted(passedDic.items())))

INF = float('inf')
mod = 10 ** 9 + 7

'''
2 3 5 7 9


0 3 3 5 7

Ans:9

2 3 4 7 9

0 3 2 5 7

Ans:9


'''


n = INT()
a = LIST()
temp = sum(a)

ans = ceil(temp/(n-1))

print(max(max(a), ans))