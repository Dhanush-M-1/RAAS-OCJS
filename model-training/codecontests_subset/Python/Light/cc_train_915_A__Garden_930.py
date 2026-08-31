n,k=map(int,input().split())
ans=99999
p=list(map(int,input().strip().split()))[:n]
for i in p:
    if (k%i) == 0 :
        ans=min(ans,k/i)
print(int(ans))