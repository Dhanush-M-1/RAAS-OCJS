n,m=map(int,input().split())
ans=[]
ab=[list(map(int,input().split()))for _ in range(n)]
cd=[list(map(int,input().split()))for _ in range(m)]
for a,b in ab:
  anss=0
  mm=10**20
  for i in range(m):
    mmm=abs(a-cd[i][0])+abs(b-cd[i][1])
    if mm>mmm:
      anss=i+1
      mm=mmm
  ans.append(anss)
print(*ans)