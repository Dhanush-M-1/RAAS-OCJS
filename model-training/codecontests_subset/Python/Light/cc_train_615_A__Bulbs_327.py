n,m=list(map(int,input().split()))
a=[0]*m
for i in range(n):
    b=list(map(int,input().split()))
    for j in range(1,b[0]+1):
        a[b[j]-1]=1
e=0
for i in range(m):
    if a[i]==0:
        e=1
        break
if e==0:
    print("YES")
else:
    print("NO")