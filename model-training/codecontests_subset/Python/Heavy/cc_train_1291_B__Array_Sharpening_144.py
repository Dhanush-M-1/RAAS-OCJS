t=int(input())
for i2 in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    a1,a2,skip=0,n-1,0
    for i in range(n):
        if x[i]<i:
            a1=i-1
            break
        if i==n-1:
            skip=1
    for i in range(n-1,-1,-1):
        if x[i]<n-i-1:
            a2=i+1
            break
        if i==0:
            skip=1
    if skip==1:
        print("YES")
        continue
    if a2==a1+1:
        if x[a1]>a1 or x[a2]>a1:
            print("YES")
        else:
            print("NO")
    elif a2<=a1:
        print("YES")
    else:
        print("NO")