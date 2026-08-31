from heapq import *
from collections import deque
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

t = int(input())

ans = [0]*t
for i in range(t):
    n = int(input())
    plus = [[] for i in range(n)]
    minus = [[] for i in range(n)]
    delta = 0
    for _ in range(n):
        k,l,r = map(int,input().split())
        k -= 1
        ans[i] += r
        if l-r > 0:
            plus[k].append(l-r)
        elif l-r < 0:
            minus[k].append(l-r)
            delta += l-r
    can = 0
    pq = []
    for j in range(n-1,-1,-1):
        while plus[j]:
            heappush(pq,-plus[j].pop())
        if pq:
            delta += -heappop(pq)
            can += 1
    pqm = []
    for j in range(n):
        if j >= can and pqm:
            delta += -heappop(pqm)
        while minus[j]:
            heappush(pqm,minus[j].pop())
    ans[i] += delta
print("\n".join(str(i) for i in ans))
