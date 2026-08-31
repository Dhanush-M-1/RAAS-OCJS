from collections import defaultdict
from collections import deque
n,m=list(map(int,input().split()))
d=defaultdict(list)
for i in range(m):
    x,y=map(int,input().split())
    d[x].append(y)
    d[y].append(x)
c={}
f=0
visited=[0]*(n+1)
for i in range(1,n+1):
    if visited[i]==0:
        q=deque()
        q.append(i)
        visited[i]=1
        while q:
            j=q.popleft()
            co=c.get(j,0)
            if co==0:
                c[j]='a'
                co='a'
            for k in d[j]:
                if visited[k]==0:
                    coo=c.get(k,0)
                    if coo==0:
                        c[k]='a' if co=='b' else 'b'
                    q.append(k)
                    visited[k]=1
for i in d:
    co=c[i]
    for j in d[i]:
        coo=c[j]
        if co==coo:
            f=1
            break
    if f:
        break
if f:
    print(-1)
else:
    a,b=[],[]
    for i in range(1,n+1):
        co=c.get(i,0)
        if co=='a':
            a.append(i)
        elif co=='b':
            b.append(i)
    print(len(a))
    print(*a)
    print(len(b))
    print(*b)