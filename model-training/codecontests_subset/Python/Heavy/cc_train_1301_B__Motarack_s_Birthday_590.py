t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    mx=-1
    b=0
    mn=1000000000
    for i in range(1,n-1):
        if a[i]>mx and (a[i-1]==-1 or a[i+1]==-1):
            mx=a[i]
            b=1
        if a[i]!=-1 and mn>a[i] and (a[i-1]==-1 or a[i+1]==-1):
            mn=a[i]
            b=1
    if a[0]>mx and n>1:
        if a[1]==-1:
            mx=a[0]
            b=1
    if a[n-1]>mx and n>1:
        if a[n-2]==-1:
            mx=a[n-1]
            b=1
    if a[0]<mn and n>1:
        if a[1]==-1 and a[0]!=-1:
            mn=a[0]
            b=1
    if a[n-1]<mn and n>1:
        if a[n-2]==-1 and a[n-1]!=-1:
            mn=a[n-1]
            b=1
    k=int((mx+mn)/2)
    max2=0
    for i in range(n):
        if a[i]==-1:
            a[i]=k 
    for i in range(n-1):
        max2=max(max2,abs(a[i]-a[i+1]))
    if b==0:
        print(0,0,sep=" ")
    else:
        print(max2,k,sep=" ")