n,k=map(int,input().split())
tab=[list(map(int,input().split())) for  _ in range(n)]
x=[]
y=[]
z=[]
for i in range(n):
  if tab[i][1]==tab[i][2]==1:
    x.append(tab[i])
  elif tab[i][1]==1:
    y.append(tab[i])
  elif tab[i][2]==1:
    z.append(tab[i])
x.sort()
y.sort()
z.sort()
sx=[0]*(len(x)+1)
sy=[0]*(len(y)+1)
sz=[0]*(len(z)+1)
for i in range(1,len(x)+1):
  sx[i]=x[i-1][0]
for i in range(1,len(y)+1):
  sy[i]=y[i-1][0]
for i in range(1,len(z)+1):
  sz[i]=z[i-1][0]
for i in range(1,len(sx)):
  sx[i]+=sx[i-1]
for i in range(1,len(sy)):
  sy[i]+=sy[i-1]
for i in range(1,len(sz)):
  sz[i]+=sz[i-1]
ans=10**18
for i in range(k+1):
  if not (0<=i<=len(x) and 0<=k-i<=len(y) and 0<=k-i<=len(z)):
    continue
  res=sx[i]+sy[k-i]+sz[k-i]
  ans=min(ans,res)
if ans==10**18:
  print(-1)
else:
  print(ans)