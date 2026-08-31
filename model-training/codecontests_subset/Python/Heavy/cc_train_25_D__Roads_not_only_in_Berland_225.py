#import math
#from functools import lru_cache
#import heapq
#from collections import defaultdict
#from collections import Counter
#from sys import stdout
#from sys import setrecursionlimit
from sys import stdin
input = stdin.readline
n = int(input())
parents = list(range(n))
ranks = [0]*n
def find(x):
    if(parents[x] != x):
        parents[x] = find(parents[x])
    return parents[x]
def union(x, y):
    xp = find(x)
    yp = find(y)
    if(ranks[xp]>ranks[yp]): xp, yp = yp, xp
    parents[xp] = yp
    if(ranks[xp] == ranks[yp]): ranks[yp] += 1
c = []
for ni in range(n-1):
    s, e = [int(x) for x in input().strip().split()]
    s-=1
    e-=1
    sp = find(s)
    ep = find(e)
    if(sp==ep):
        c.append([s, e])
    else:
        union(s, e)
    #print(parents)
#print(parents)
for ni in range(n):
    find(ni)
ntc = list(set(parents))
#print(ntc)
print(len(ntc) - 1)
for i in range(1, len(ntc)):
    print(c[i-1][0]+1, c[i-1][1]+1, ntc[i]+1, ntc[i-1]+1)
