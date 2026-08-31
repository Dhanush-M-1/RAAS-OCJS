t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    x=a[0]
    y=a[1]
    z=a[-1]
    c=len(a)
    if(x+y>z):
        print(-1)
    else:
        print(1,2,c)