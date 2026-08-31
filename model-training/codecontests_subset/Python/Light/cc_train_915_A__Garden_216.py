n,k=map(int,input().split())
vs,m=list(map(int,input().split())),k
for i in vs:
    if k//i==k/i and k//i<m:
        m=k//i
print(m)