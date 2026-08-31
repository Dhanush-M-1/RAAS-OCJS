import math
n,k = map(int,input().split())
l = list(map(int,input().split()))
l.sort()
d = {}
c = {}
for i in l:
    cnt = 0
    x = i
    while x != 0:
        if x in d:
            d[x] += 1

        else:
            d[x] = 1

        if x in c:
            if d[x] <= k:
                c[x] += cnt

        else:
            c[x] = cnt

        x = x//2
        cnt += 1

    if x in d:
        d[x] += 1

    else:
        d[x] = 1

    if x in c:
        if d[x] <= k:
            c[x] += cnt

    else:
        c[x] = cnt

ans = 10**18
# print(d)
for i in d:
    if d[i] >= k:
        ans = min(ans,c[i])

print(ans)