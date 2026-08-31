read=lambda:map(int,input().split())
n,k=read()
ans=k
for a in list(read()):
    if k%a==0:
        ans=min(ans,k//a)
print(ans)