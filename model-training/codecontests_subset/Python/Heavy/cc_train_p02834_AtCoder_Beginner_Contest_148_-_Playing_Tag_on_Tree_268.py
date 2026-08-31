n,u,v=map(int,input().split())
u-=1
v-=1
edge=[[]for _ in range(n)]
for _ in range(n-1):
  a,b=map(int,input().split())
  a-=1
  b-=1
  edge[a].append(b)
  edge[b].append(a)
aoki=[10**10]*n
taka=[10**10]*n
aoki[v]=0
taka[u]=0
Q=[v]
visited={v}
co=1
while Q:
  P=[]
  for i in Q:
    for j in edge[i]:
      if j in visited:continue
      aoki[j]=co
      visited.add(j)
      P.append(j)
  Q=P
  co+=1
Q=[u]
visited={u}
co=1
while Q:
  P=[]
  for i in Q:
    for j in edge[i]:
      if j in visited:continue
      taka[j]=co
      visited.add(j)
      P.append(j)
  Q=P
  co+=1
ans=0
for i in range(n):
  if taka[i]<aoki[i]:ans=max(ans,aoki[i]-1)
print(ans)