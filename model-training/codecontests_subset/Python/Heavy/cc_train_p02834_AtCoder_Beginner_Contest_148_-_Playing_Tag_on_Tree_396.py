N,u,v=map(int,input().split())
G=[set() for i in range(N)]
for i in range(N-1):
  A,B=map(int,input().split())
  G[A-1].add(B-1)
  G[B-1].add(A-1)
disA=[-1]*N
disB=[-1]*N
disA[u-1]=0
disB[v-1]=0
import collections

q=collections.deque([u-1])
while(q):
  x=q.popleft()
  for y in G[x]:
    if disA[y]==-1:
      disA[y]=disA[x]+1
      q.append(y)

q.append(v-1)      
while(q):
  x=q.popleft()
  for y in G[x]:
    if disB[y]==-1:
      disB[y]=disB[x]+1
      q.append(y)
ans=0
for i in range(N):
  if disA[i]<disB[i]:
    ans=max(ans,disB[i]-1)
print(ans)