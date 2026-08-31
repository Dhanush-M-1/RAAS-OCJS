t=int(input())
for o in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    x=a[n-1]
    y=a[0]
    flag=0
    for i in range(1,n-1):
        if a[i]+y<=x:
            flag=1
            break
    if flag==1:
        print(1,i+1,n)
    else:
        print(-1)