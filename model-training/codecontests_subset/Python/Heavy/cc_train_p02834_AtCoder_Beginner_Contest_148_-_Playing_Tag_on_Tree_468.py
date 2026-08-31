n,u,v=map(int,input().split())
u-=1
v-=1
e=[[]for _ in range(n)]
for i in range(n-1):
  a,b=map(int,input().split())
  a-=1
  b-=1
  e[a].append(b)
  e[b].append(a)
cho=[u]
cho_dis=[10**7]*n
cho_dis[u]=0
cho_visited={u}
countt=1
while cho:
  CHO=[]
  for i in cho:
    for j in e[i]:
      if j in cho_visited:continue
      cho_visited.add(j)
      CHO.append(j)
      cho_dis[j]=countt
  countt+=1
  cho=CHO
aok=[v]
aok_dis=[10**7]*n
aok_dis[v]=0
aok_visited={v}
countt=1
while aok:
  AOK=[]
  for i in aok:
    for j in e[i]:
      if j in aok_visited:continue
      aok_visited.add(j)
      AOK.append(j)
      aok_dis[j]=countt
  countt+=1
  aok=AOK
ans=0
for i in range(n):
  if cho_dis[i]<aok_dis[i]:ans=max(ans,aok_dis[i]-1)
print(ans)