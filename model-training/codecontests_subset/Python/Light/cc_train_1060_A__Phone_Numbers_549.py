n = int(input())
s = list(map(int, list(input())))
e = s.count(8)
y = n - e
if e <= y // 10:
    print(e)
elif e == 0:
    print(0)
else:
    u = 0
    for i in range(0, e):
        a = e - i
        x = y + i
        if a >= x // 10:
            if x > u:
                u = x // 10
        else:
            if a > u:
                u = a
    print(u)