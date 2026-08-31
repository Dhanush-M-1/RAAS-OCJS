from collections import deque
 
n,m=map(int,input().split())
v=[[]for i in range(n+2)]
ans=[[] for i in range(3)]
vs=[0 for i in range(n+2)]
while m:
  x,y=map(int,input().split())
  v[x].append(y)
  v[y].append(x)
  m-=1
 
def bfs(nod,colr):
 q=deque([nod])
 vs[nod]=1
 while q:
  node=q.popleft()
  colr=vs[node]
  ans[colr].append(node)
  for ch in v[node]:
    if(not vs[ch]):
      q.append(ch)
      vs[ch]=3-vs[node]
    elif(vs[ch]==vs[node]):
        print(-1)
        exit()
 
for i in range(1,n+1):
  if not vs[i]:
    bfs(i,1)
    
print(len(ans[1]))
print(*ans[1])
print(len(ans[2]))
print(*ans[2])