import sys
input=sys.stdin.readline
from collections import deque
n=int(input())
if n==2:
    print('YES')
    exit()
if n==3:
    print('NO')
    exit()
Edges=[[] for _ in range(n)]
for _ in range(n-1):
    u,v=map(lambda x: int(x)-1,input().split())
    Edges[u].append(v)
    Edges[v].append(u)
for i,E in enumerate(Edges):
    if len(E)>=3:
        root=i
        break
else:
    print('NO')
    exit()
Chi=[[] for _ in range(n)]
Par=[0]*n
q=deque()
q.append(root)
Used=[False]*n
Used[root]=True
while q:
    v=q.popleft()
    for c in Edges[v]:
        if Used[c]:
            continue
        Chi[v].append(c)
        Par[c]=v
        Used[c]=True
        q.append(c)
Leaf=[]
for v,l in enumerate(Chi):
    if not l:
        Leaf.append(v)
for l in Leaf:
    while True:
        p=Par[l]
        if p==root:
            break
        if len(Chi[p])==1:
            print('NO')
            exit()
        l=p
print('YES')