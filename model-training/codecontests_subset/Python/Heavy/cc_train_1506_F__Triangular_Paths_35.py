import math
for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    c = []
    for i in range(n):
        c.append((a[i], b[i]))
    c.sort()
    if c[0] != (1, 1):
        c.insert(0, (1, 1))
        n += 1
    cost = 0
    for u in range(n - 1):
        p, q = c[u][0], c[u][1]
        r, s = c[u + 1][0], c[u + 1][1]
        if abs(p - q) == abs(r - s):
            if abs(p - q) % 2:
                continue
            else:
                cost += abs(p - r)
        else:
            x = abs(p - q)
            y = abs(r - s)
            if y % 2:
                cost += abs(x - y) // 2
            else:
                cost += int(math.ceil(abs(x - y) / 2))
    print(cost)