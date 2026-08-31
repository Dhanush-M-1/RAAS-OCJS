n,k=map(int,input().split())
a=list(map(int,input().split()))
ans=0
for i in a:
    if k%i==0 and i>ans:
        ans=i
print(k//ans)
