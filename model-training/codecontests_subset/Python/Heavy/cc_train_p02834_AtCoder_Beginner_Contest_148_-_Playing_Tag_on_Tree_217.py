from collections import deque

n,u,v=map(int, input().split())
G=[[] for _ in range(n+1)] # 隣接リスト

for i in range(n-1):
    a,b=map(int, input().split())
    G[a].append(b)
    G[b].append(a)
    
def dfs(x,n): # 再帰じゃない DFS かく(DFSでもBFSでもどっちでも同じか)
    stack=deque([x])
    dist=[-1]*(n+1)
    dist[x]=0
    
    while len(stack)>0:
        a=stack.pop()
        for k in G[a]:
            if dist[k]<0:
                dist[k]=dist[a]+1
                stack.append(k)
    return dist # リストを返している

distt=dfs(u,n) # u高橋くんからの最短距離
dista=dfs(v,n) # v青木くんからの最短距離

ans=0
for i in range(1,n+1):
    if distt[i] < dista[i]:
        ans=max(ans,dista[i]-1)
print(ans)