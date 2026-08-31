n,k=map(int,input().split())
l=[int(x) for x in input().split()]
ans=10**20
for i in range(n):
  if k%l[i]==0:
    ans=min(ans,k//l[i])
print(ans)