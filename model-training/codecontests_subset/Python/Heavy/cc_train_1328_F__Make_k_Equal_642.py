import math
import sys
from heapq import heappop
from heapq import heappush
from heapq import heapify
from bisect import insort
from sys import stdin,stdout
from collections import defaultdict

inp=lambda : int(stdin.readline())
sip=lambda : input()
mulip =lambda : map(int,input().split())
lst=lambda : list(map(int,stdin.readline().split()))
slst=lambda: list(sip())
arr2d= lambda x: [[int(j) for j in input().split()] for i in range(x)]
odds = lambda l: len(list(filter(lambda x: x%2!=0, l)))
evens = lambda l: len(list(filter(lambda x: x%2==0, l)))
mod = pow(10,9)+7
#-------------------------------------------------------
n, k = map(int, input().split())
A = [int(x) for x in input().split()]
vals = defaultdict(list)
for i in range(n):
    x = A[i]
    cnt = 0 
    while(x>0):
        vals[x].append(cnt)
        #print(x,":",vals[x])
        x = x//2
        cnt+=1

res = pow(10,10)
for i in range(2*pow(10,5)+1):
    l = vals[i] 
    l = sorted(l)
    if len(l)>=k:
        res = min(res, sum(l[:k]))

print(res)

