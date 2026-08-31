n, k = map(int, input().split())
a = list(map(int, input().split()))

poss = []
for i in range(n):
    x = a[i]
    while x > 0:
        if x in poss:
            pass
        else:
            poss.append(x)
        x = x // 2

Ans = float('inf')
for res in poss:
    cnt = []
    ans = 0
    for x in a:
        cur = 0
        while x > res:
            x = x // 2
            cur += 1
        if x == res:
            cnt.append(cur)
    if len(cnt) < k:
        continue
    else:
        cnt = sorted(cnt)
        i = 0
        while i < k:
            ans += cnt[i]
            i += 1
    Ans = min(ans, Ans)
print(Ans)
