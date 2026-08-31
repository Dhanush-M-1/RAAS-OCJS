buckets,length = map(int,input().split())
x=list(map(int,input().split()))
x=sorted(x)
ans=0
for i in x:
    if length%i==0:
        ans=length//i

print(ans)
