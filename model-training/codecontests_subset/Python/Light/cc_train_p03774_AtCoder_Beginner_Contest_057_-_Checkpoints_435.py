n,m=map(int,input().split())
ab=[list(map(int,input().split())) for i in range(n)]
cd=[list(map(int,input().split())) for i in range(m)]
ans=[-1]*n
i=0
for a,b in ab:
  t=10**12
  j=0
  for c,d in cd:
    if abs(a-c)+abs(b-d)<t:
      t=abs(a-c)+abs(b-d)
      ans[i]=j+1
    j+=1
  i+=1
print(*ans,sep='\n')


