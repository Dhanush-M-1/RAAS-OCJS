def bfs(k):
    flag=[-1]*(n+1)
    que=[k]
    flag[k]=0
    cnt=1
    while que:
        h=[]
        for uu in que:
            for vv in data[uu]:
                if flag[vv]==-1:
                    flag[vv]=cnt
                    h.append(vv)
        que=h
        cnt+=1
    return flag

n,u,v=map(int,input().split())
data=[[] for i in range(n+1)]
for _ in range(n-1):
    a,b=map(int,input().split())
    data[a].append(b)
    data[b].append(a)
T=bfs(u)
A=bfs(v)
ans=0
for i in range(1,n+1):
    if T[i]<A[i]:
        ans=max(ans,A[i]-1)
print(ans)