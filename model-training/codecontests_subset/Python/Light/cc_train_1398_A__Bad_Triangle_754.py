for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    s = a[0]+a[1]
    t = a[-1]
    if s <= t:
        print(1,2,n)
    else:
        print(-1)
