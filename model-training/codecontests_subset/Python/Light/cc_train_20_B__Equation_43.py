a, b, c = [int(a) for a in input().split()]
if a == 0:
    if b == 0:
        if c == 0:
            print(-1)
        else:
            print(0)
    else:
        print(1)
        print(-c / b)
else:
    D = b ** 2 - 4 * a * c
    if D == 0:
        print(1)
        print(-b / (2 * a))
    elif D < 0:
        print(0)
    else:
        print(2)
        ans = sorted([(-b - D ** 0.5) / (2 * a), (-b + D ** 0.5) / (2 * a)])
        print(*ans, sep="\n")