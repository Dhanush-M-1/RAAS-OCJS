n,m=map(int,input().split())
now=[tuple(map(int,input().split())) for i in range(n)]
p=[tuple(map(int,input().split())) for i in range(m)]
for a in now:
  ans=10**10
  for i in range(m):
    if ans>abs(p[i][0]-a[0])+abs(p[i][1]-a[1]):
      ind=i
      ans=abs(p[i][0]-a[0])+abs(p[i][1]-a[1])
  print(ind+1)
