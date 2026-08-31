N,U,V=map(int,input().split())
if U==V:
    print(0)
    exit()

G=[[]*N for _ in range(N)]
for i in range(N-1):
    a,b=map(int,input().split())
    G[a-1].append(b-1)
    G[b-1].append(a-1)


from collections import deque
def calc(s):
    que=deque()
    que.append(s-1)
    visited=[-1]*N
    visited[s-1]=0
    while que:
        v=que.pop()
        for u in G[v]:
            if visited[u]==-1:
                que.appendleft(u)
                visited[u]=visited[v]+1
    return visited
taka=calc(U)
aoki=calc(V)
#print(taka)
#print(aoki)
ans=0
for i in range(N):
    if taka[i]<=aoki[i]:
        ans=max(ans,aoki[i])

print(ans-1)
