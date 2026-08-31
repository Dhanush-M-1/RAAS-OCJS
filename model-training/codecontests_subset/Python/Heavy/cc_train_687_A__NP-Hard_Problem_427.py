f = lambda: map(int, input().split())
n, m = f()
s = [[] for i in range(n)]
t = [0] * n
for j in range(m):
    x, y = f()
    x -= 1
    y -= 1
    s[x].append(y)
    s[y].append(x)
for j in range(n):
    if t[j]: continue
    p, t[j] = [j], 1
    while p:
        x = p.pop()
        for y in s[x]:
            if t[y]:
                if t[y] == t[x]:
                    print(-1)
                    exit(0)
            else:
                t[y] = 3 - t[x]
                p.append(y)
for h in [1, 2]:
    s = [str(k) for k, q in enumerate(t, 1) if q == h]
    print(len(s))
    print(' '.join(s))
