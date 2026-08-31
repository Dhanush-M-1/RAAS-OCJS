import sys
from math import gcd
from heapq import heappop
from heapq import heappush
from heapq import heapify
from bisect import insort
from bisect import bisect_right
from bisect import bisect_left
from sys import stdin,stdout
from collections import defaultdict, deque
from math import log2, ceil, floor

inp=lambda : int(input())
sip=lambda : input()
mulip =lambda : map(int,input().split())
lst=lambda : list(map(int,input().split()))
slst=lambda: list(sip())
arr2d= lambda x: [[int(j) for j in input().split()] for i in range(x)]
odds = lambda l: len(list(filter(lambda x: x%2!=0, l)))
evens = lambda l: len(list(filter(lambda x: x%2==0, l)))
mod = pow(10,9)+7
#-------------------------------------------------------
Judge = 0
if Judge:
    sys.stdin = open("input.in",'r')
    #sys.stdout = open("output.in",'w')

for _ in range(inp()):
    s1, s2 = map(list, input().split())
    d = defaultdict(int)
    for i in range(len(s1)):
        d[s1[i]]=i 
    x = sorted(s1) 
    for i in range(len(s1)):
        if s1[i]!=x[i]:
            tmp = s1[i]
            s1[i] = s1[d[x[i]]]
            s1[d[x[i]]] = tmp 
            break 
    #print(x)
    #print(s2)
    if "".join(s1)<"".join(s2):
        print("".join(s1))
    else:
        print("---")