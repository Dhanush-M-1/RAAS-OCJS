t = int(input())
for _ in range(t):
    n=int(input())
    li=list(map(int,input().split()))
    a=li[0]
    b=li[1]
    c=a+b
    fg=0
    d=0
    for i in range(2,n):
        if(c<=li[i]):
            fg=1
            d=i+1
            break
    if fg==0:
        print(-1)
    else:
        print(1,2,d)


