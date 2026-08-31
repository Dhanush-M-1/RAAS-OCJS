n,k=map(int,input().split())
m=list(map(int,input().split()))
ans=0
for i in m:
    if k%i==0 and i>ans:
        ans=i
print(k//ans)