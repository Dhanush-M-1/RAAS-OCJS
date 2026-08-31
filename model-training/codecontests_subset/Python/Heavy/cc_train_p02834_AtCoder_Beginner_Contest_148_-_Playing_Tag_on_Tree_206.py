n,u,v=map(int,input().split())
u,v=u-1,v-1
e=[[] for i in range(n)]
for i in range(n-1):
  a,b=map(lambda x:int(x)-1,input().split())
  e[a].append(b)
  e[b].append(a)

mt=[-1 for i in range(n)]
de=[-1 for i in range(n)]
dpl=[]
s=[v]
t=0
while s:
  dpl.append([])
  ns=[]
  for i in s:
    de[i]=t
    dpl[-1].append(i)
    for j in e[i]:
      if de[j]!=-1:
        continue
      ns.append(j)
      mt[j]=i
  s=ns
  t+=1

maxd=[de[i] for i in range(n)]
for i in dpl[:0:-1]:
  for j in i:
    maxd[mt[j]]=max(maxd[mt[j]],maxd[j])

t=de[u]//2+1
while de[u]!=t:
  u=mt[u]
print(maxd[u]-1)