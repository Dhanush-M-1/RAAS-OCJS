n,k=map(int,input().split())
ans=1000000090990
a=list(map(int,input().split()))
for i in a:
    if k%i==0 and k//i < ans:
        ans = k//i
print(ans)
