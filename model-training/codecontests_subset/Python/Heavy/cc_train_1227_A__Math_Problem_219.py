t = int(input())
for _ in range(t):
    n = int(input())
    x, y, f = *[int(x) for x in input().split()], True
    for _ in range(n-1):
        a, b = [int(x) for x in input().split()]
        if f:
            if a > y:
                x, y, f = y, a, False
            elif b < x:
                x, y, f = b, x, False
            else:
                x, y = max(x, a), min(y, b)
        else:
            if a > y:
                y = a
            elif b < x:
                x = b
    print(0 if f else y - x)