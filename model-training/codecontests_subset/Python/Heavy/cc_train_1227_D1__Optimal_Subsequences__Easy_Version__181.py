n = int(input())
s = list(map(int, input().split()))
for i in range(n):
    s[i] = (s[i], i)
mx = sorted(s, key=lambda y: y[0], reverse=True)
m = int(input())
for i in range(m):
    k, pos = map(int, input().split())
    pos -= 1
    a = 0
    last = mx[0][0]
    res = []
    d = dict()
    d2 = dict()
    for x in range(k):
        if mx[x][0] not in d:
            d[mx[x][0]] = 1
        else:
            d[mx[x][0]] += 1

    for x in range(n):
        if mx[x][0] != last:
            a += 1
            last = mx[x][0]
        if a == k:
            break

        if mx[x][0] not in d2:
            d2[mx[x][0]] = [mx[x][1]]
        else:
            d2[mx[x][0]].append(mx[x][1])

    for a in list(d.keys()):
        d2[a].sort()
        for j in range(d[a]):
            res.append((a, d2[a][j]))

    res = sorted(res, key=lambda y: y[1])
    print(res[pos][0])

