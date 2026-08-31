from math import ceil

n,p,w,d = map(int, input().split())
e = x = n
s = 0
y = None
for i in range(64):
    a = x * w
    y = ceil((p - a) / d)
    if y < 0:
        e = x
        x = (s + x) // 2
        continue
    b = y * d
    ss = a + b
    if ss == p and x+y <= n:
        break
    if (a < p) or x + y > n:
        s = x
        x = (e + x) // 2
    else:
        e = x
        x = (s + x) // 2
else:
    dir_ = 1 if p - ss > 0 else -1
    for i in range(100000):
        x += dir_
        a = x * w
        y = (p - a) // d
        b = y * d
        ss = a + b
        if ss == p and x+y <= n:
            break
    else:
        print(-1)
        exit()
if x < 0 or y < 0:
    print(-1)
else:
    print(x, y, n - x - y)
