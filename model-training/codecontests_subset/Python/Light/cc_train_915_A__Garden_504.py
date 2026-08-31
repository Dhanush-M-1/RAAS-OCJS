n,k=map(int,input().split())
a=list(map(int,input().split()))
m=k
for i in range(len(a)):
    if k%a[i]==0 and k//a[i]<=m:
        m=k//a[i]
print(m)