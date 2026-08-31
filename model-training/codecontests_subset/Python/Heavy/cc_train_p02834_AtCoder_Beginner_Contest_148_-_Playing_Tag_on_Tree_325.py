import sys
sys.setrecursionlimit(10**5)
n,u,v=map(int,input().split())
u=u-1
v=v-1
root=[[] for i in range(n)]

for i in range(n-1):
    a,b=map(int,input().split())
    root[a-1].append(b-1)
    root[b-1].append(a-1)

dp=[[-1]*n for i in range(2)]
dp[0][u]=0
dp[1][v]=0
def dfs(node,depth,par,flag):
    for vertex in root[node]:
        if vertex == par or dp[flag][vertex]!=-1:
            continue
        dp[flag][vertex]=depth+1
        dfs(vertex,depth+1,node,flag)
    return
dfs(u,0,u,0)
dfs(v,0,v,1)
buf=-1
buf1=0
#print(dp1,dp2,root)
for i in range(n):
    if dp[0][i]<dp[1][i] and dp[1][i]>buf:
        buf=dp[1][i]
        buf1=dp[0][i]
print(buf-1)
