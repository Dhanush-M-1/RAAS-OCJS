n = int(input())
a = [int(i) for i in input().split()]
b = sorted(a)
b.reverse()
m = int(input())
for _ in range(m):
    k, pos = map(int, input().split())
    x = 0
    j = 0
    d = dict()
    ans = 0
    for i in b[:k]:
        d[i] = d.get(i, 0) + 1
    while x != pos:
        u = a[j]
        if u in d:
            d[u] -= 1
            x += 1
            if d[u] == 0:
                del d[u]
        j += 1
        ans = u
    print(ans)

