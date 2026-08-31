
q = int(input())

for i in range(q):
    l, r, d = map(int, input().split())
    if d == 1 and l == 1:
        print(r + 1)
    elif l == 1 and d < 1000:
        slag = 1
        while (r + slag) % d != 0:
            slag += 1
        print(r + slag)
    elif d <= 100 and d >= l:
        slag = 1
        while (r + slag) % d != 0:
            slag += 1
        print(slag + r)
    else:
        base = 1
        while l <= d * base <= r:
            base += 1
        print(base*d)
