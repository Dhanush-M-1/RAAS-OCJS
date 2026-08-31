for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    minn = 10**9
    maxx = 0
    t = 0
    for i in range(n-1):
        if a[i] != -1 and a[i+1] == -1:
            minn = min(a[i], minn)
            maxx = max(a[i], maxx)
        elif a[i] == -1 and a[i+1] != -1:
            minn = min(a[i+1], minn)
            maxx = max(a[i+1], maxx)
        elif a[i] != -1 and a[i+1] != -1:
            t = max(t, abs(a[i]-a[i+1]))
    if minn == 10**9:
        minn = 0


    mm = float("inf")
    kk = -1
    #for k in range(minn, maxx+1):
    k = (maxx+minn)//2
    m = max(abs(maxx-k), abs(minn-k), t)
    if m < mm:
        mm = m
        kk = k
    print(mm, kk)
