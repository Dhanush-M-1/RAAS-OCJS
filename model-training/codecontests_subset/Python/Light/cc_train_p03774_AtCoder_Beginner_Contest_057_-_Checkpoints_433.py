n,m=map(int,input().split())
a=[]
b=[]
for i in range(n):
  a.append(list(map(int,input().split())))
for i in range(m):
  b.append(list(map(int,input().split())))
for i in range(n):
  tmp=10**9
  for j in range(m):
    man=abs(a[i][0]-b[j][0]) + abs(a[i][1]-b[j][1])
    if man < tmp:
      tmp=man
      ans=j+1
  print(ans)