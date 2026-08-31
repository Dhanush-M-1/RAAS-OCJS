t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    
    flag=0
    for i in range(n-1):
        x=a[i]
        y=a[i+1]
        if(a[-1]>=x+y):
            x=i+1
            y=i+2
            flag=1
            break

    if(flag==1):
        print(x,y,n)
    else:
        print(-1)
