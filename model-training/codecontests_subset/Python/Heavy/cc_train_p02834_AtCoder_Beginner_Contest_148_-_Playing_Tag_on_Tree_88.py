import sys

sys.setrecursionlimit(200000)
n,u,v = map(int,input().split())
edge = [[] for i in range(n+1)]
distt = [0 for i in range(n+1)]
dista = [0 for i in range(n+1)]

for i in range(n-1):
    a, b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

def tdfs(x, last = -1):
    for to in edge[x]:
        if(to == last):continue
        distt[to] = distt[x] + 1
        tdfs(to, x)

def adfs(x, last = -1):
    for to in edge[x]:
        if(to == last):continue
        dista[to] = dista[x] + 1
        adfs(to, x)

tdfs(u)
adfs(v)
ans = 0

for i in range(1, n+1):
    if distt[i] >= dista[i]:continue
    l = distt[i]
    k = dista[i] - distt[i]
    ans = max(ans, k - 1 + l)

print(ans)