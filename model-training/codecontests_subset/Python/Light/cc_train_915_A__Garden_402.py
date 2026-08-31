n,k=map(int,input().split())
a=list(map(int,input().split()))
m=k
for i in a:
    if k%i==0 and k//i<m:
        m=k//i
print(m)