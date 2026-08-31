a, b, c = map(float, input().split())
d = b ** 2 - 4 * a * c
if d < 0:
    print(0)
elif a == 0 and b == 0:
    if c == 0:
        print(-1)
    else:
        print(0)
elif a == 0:
    print(1)
    print(-c / b)
else:
    x = [float((-b + d ** 0.5) / 2 / a)]
    v1 = float((-b - d ** 0.5) / 2 / a)
    if not v1 in x:
        x += [v1]
    x.sort()
    print(len(x))
    for v in x:
        print("%.6f" % float(v))

