n,k=list(map(int,input().split()))
i=1
while i<=n:
    if(i%k==0):
        n=n+1
    i=i+1
print(n)