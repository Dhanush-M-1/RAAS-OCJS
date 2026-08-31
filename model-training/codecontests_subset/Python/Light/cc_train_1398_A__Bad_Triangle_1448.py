t = int(input())
for tt in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    ok = True
    res = (0,0,0)
    i = 0
    while i+1 < n-1-i:
        if a[i] + a[i+1] <= a[n-1-i]:
            ok = False
            res = (i+1, i+2, n-1-i+1)
        if i < n-2-i:
            if a[n-1-i] >= a[i] + a[n-2-i]:
                ok = False
                res = (i+1, n-2-i+1, n-1-i+1)
        i += 1
    
    if ok:
        print(-1)
    else:
        print(res[0], res[1], res[2])