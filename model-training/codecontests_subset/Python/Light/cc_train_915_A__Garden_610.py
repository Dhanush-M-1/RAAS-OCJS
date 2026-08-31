temp=list(map(int,input().split()))
k=temp[1]
v=list(map(int,input().split()))
ans=1000
for i in v:
  if(k%i==0):
    ans=min(ans,int(k/i))
    
print(ans)
