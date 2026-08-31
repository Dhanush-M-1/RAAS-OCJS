from collections import deque 
import sys
input = sys.stdin.readline  #文字列入力では注意！

N,u,v = map(int,input().split())
u -= 1; v -= 1
tree = [[] for _ in range(N)]
for i in range(N-1):
    A,B = map(int,input().split())
    tree[A-1].append(B-1)
    tree[B-1].append(A-1)

def bfs(start):
    q = deque()
    q.append([start,0])
    visited = set()
    lis = [0]*N
    while q:
        now,dis = q.popleft()
        if now in visited:
            continue
        lis[now] = dis
        visited.add(now)
        for node in tree[now]:
            q.append([node,dis+1])    
    return lis
ut = bfs(u)
vt = bfs(v)

ans = 0
for i in range(N):
    if ut[i] <vt[i]:
        ans = max(ans,vt[i])
print(ans-1)
