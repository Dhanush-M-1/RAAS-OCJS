n,u,v=[int(j) for j in input().split()]
u,v=u-1,v-1
l=[[] for i in range(n)]
for i in range(n-1):
    a,b=[int(j)-1 for j in input().split()]
    l[a].append(b)
    l[b].append(a)
k=[10**18 for i in range(n)]
from collections import deque
q=deque([u])
k[u]=0
s=set()
while q:
    p=q.popleft()
    s.add(p)
    for i in l[p]:
        if i not in s:
            q.append(i)
            k[i]=k[p]+1

k2=[10**18 for i in range(n)]
from collections import deque
q=deque([v])
k2[v]=0
s=set()
while q:
    p=q.popleft()
    s.add(p)
    for i in l[p]:
        if i not in s:
            q.append(i)
            k2[i]=k2[p]+1
ans=0
for i in range(n):
    if k[i]<=k2[i]:
        if ans<k2[i]:
            ans=k2[i]

print(ans-1)
