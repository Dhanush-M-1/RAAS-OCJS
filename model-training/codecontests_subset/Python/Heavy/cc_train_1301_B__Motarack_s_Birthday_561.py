for _ in range(int(input())) :
    n = int(input())
    a = list(map(int, input().split()))
    tot, cnt = 0, 0
    ans = -1000000009
    ma, mi = -1000000009, 1000000009
    for i in range(n) :
        if a[i] != -1 :
            if (i and a[i - 1] == -1) or (i + 1 < n and a[i + 1] == -1) :
                tot += a[i]
                cnt += 1
            if i and a[i - 1] != -1 :
                ans = max(ans, abs(a[i] - a[i - 1]))
            if i + 1 < n and a[i + 1] != -1 :
                ans = max(ans, abs(a[i] - a[i + 1]))
        else :
            if i and a[i - 1] != -1 :
                mi = min(mi, a[i - 1])
                ma = max(ma, a[i - 1])
            if i + 1 < n and a[i + 1] != -1 :
                mi = min(mi, a[i + 1])
                ma = max(ma, a[i + 1])
                
    if cnt : tot = (ma + mi) // 2
    else : tot, ma, mi = 0, 0, 0
    print(max(ans, ma - tot, tot - mi), tot)
