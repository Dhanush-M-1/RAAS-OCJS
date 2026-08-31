t = int (input())
ans = [0] * t
for j in range(t):
    n = int (input())
    a, b = map (int, input().split())
    r = []
    l = []
    r.append(b)
    l.append(a)
    x = a
    y = b
    for i in range(n - 1):
        a, b = map (int, input().split())
        r.append(b)
        l.append(a)
        if a > x:
            x = a
        if b < y:
            y = b
    k = True
    if x > y:
        x, y = y, x
    for i in range(n):
        if (y <= r[i]) and (x >= l[i]):
            continue
        else:
            k = False
            break
    if k:
        print(0)
    else:
        print(abs(y - x))