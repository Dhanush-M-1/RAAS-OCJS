n,m=map(int,input().split())
a=[1]*m
for _ in range(0,n):
    b=list(map(int,input().split()))
    for i in range(1,b[0]+1):
        if(a[b[i]-1]==1):
            a[b[i]-1]=0
if(not sum(a)):
    print("YES")
else:
    print("NO")