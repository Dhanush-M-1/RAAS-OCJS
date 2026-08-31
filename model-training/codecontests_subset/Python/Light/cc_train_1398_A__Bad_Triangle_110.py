for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    mi = min(a)
    mii = a.index(mi)
    ma = max(a)
    mai = a.index(ma)
    fl = False
    i = -1
    for i in range(len(a)):
        if i != mai and i != mii and mi + a[i] <= ma:
            fl = True
            break
    b = [mii+1, mai+1, i+1]
    b.sort()
    if fl:
        print(b[0], b[1], b[2])
    else:
        print(-1)
