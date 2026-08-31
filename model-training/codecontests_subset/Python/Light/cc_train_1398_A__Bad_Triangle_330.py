for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    c=1
    if a[-1]>=a[0]+a[1]:
        print(1,2,n)
    else:print(-1)