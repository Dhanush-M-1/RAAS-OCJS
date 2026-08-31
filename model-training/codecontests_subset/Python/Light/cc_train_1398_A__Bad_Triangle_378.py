for _ in range (int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    a1,a2,a3=a[0],a[1],a[-1]
    if a1+a2>a3:
        print(-1)
    else:
        print(1,2,n)