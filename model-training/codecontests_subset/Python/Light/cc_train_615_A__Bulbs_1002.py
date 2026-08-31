n,m=map(int,input().split())
a=[0]*m
for i in range(n):
    q=list(map(int,input().split()))
    for j in range(1,q[0]+1):
        if a[q[j]-1]==0:
            a[q[j]-1]=1
k=0
s=0
while k!=m and a[k]!=0:
    s+=1
    k+=1
if s==m:
    print('YES')
else:
    print('NO')
