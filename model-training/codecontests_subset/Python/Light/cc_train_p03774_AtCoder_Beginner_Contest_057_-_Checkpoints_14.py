n,m=map(int,input().split())
a=[list(map(int,input().split()))for i in range(n)]
b=[list(map(int,input().split()))for i in range(m)]
for i in a:
  t=10**18
  ans=0
  c=1
  for j in b:
    k=abs(i[0]-j[0])+abs(i[1]-j[1])
    if t>k:
      ans=c
      t=k
    c+=1
  print(ans)