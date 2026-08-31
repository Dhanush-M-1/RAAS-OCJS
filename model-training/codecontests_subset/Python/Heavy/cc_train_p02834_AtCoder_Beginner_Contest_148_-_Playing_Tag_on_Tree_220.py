def dfs(g,root,ds):
    q = [root]
    ds[root] = 0
    while q:
        v = q.pop()
        for c in g[v]:
            if ds[c] == -1:
                ds[c] = ds[v] + 1
                q.append(c)
        



# coding: utf-8
# Your code here!
import sys
sys.setrecursionlimit(10**6)
readline = sys.stdin.readline
 
#n = int(input())
n,u,v = [int(i) for i in readline().split()]
u -= 1
v -= 1
 
g = [[] for _ in range(n)]
for i in range(n-1):
    a,b = [int(i) for i in readline().split()]
    g[a-1].append(b-1)
    g[b-1].append(a-1)
 
ds = [-1]*n
dg = [-1]*n

dfs(g,u,ds)
dfs(g,v,dg)

#print(ds,dg)

ans = 0
for i,j in zip(ds,dg):
    if i < j: ans = max(j-1,ans)
    
print(ans)





