# -*- coding: utf-8 -*-
from collections import  deque
def inpl(): return tuple(map(int, input().split()))
 
N, M = inpl()
 
adj = [[] for _ in range(N+1)]  
 
for _ in range(M):
    l, r, d = inpl()
    adj[l].append([r, d])
    adj[r].append([l, -d])
 
X = [-1 for _ in range(N+1)]
searched = [False for _ in range(N+1)]
S = 0 # == sum(searched)
res = True
g = 1
Q = deque([])
for g in range(1, N+1):
    if searched[g]:
        continue
    X[g] = 0
    Q.append(g)
    searched[g] = True
    while Q:
        p = Q.popleft()
        for np, d in adj[p]:
            if searched[np]:
                if X[np] != X[p] + d:
                    Q = []
                    res = False
                    break
            else:
                X[np] = X[p] + d
                Q.append(np)
                searched[np] = True
    if not res:
        break
 
if res:
    print("Yes")
else:
    print("No")