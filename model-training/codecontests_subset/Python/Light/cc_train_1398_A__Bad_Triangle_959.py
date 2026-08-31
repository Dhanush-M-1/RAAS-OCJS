t = int(input())
for _ in range(t):
    n=int(input())
    lis=list(map(int,input().split()))
    ai=lis[0]
    b=lis[1]
    c=ai+b
    fg=0
    d=0
    for i in range(2,n):
        if(c<=lis[i]):
            fg=1
            d=i+1
            break
    if fg==0:
        print(-1)
    else:
        print(1,2,d)


