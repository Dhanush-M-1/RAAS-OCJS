from math import inf

n = int(input())

x1 = x2 = -inf
c1 = c2 = 0

for _ in range(n):
    x, h = map(int, input().split())

    if x2 + h < x:
        x1 = x2 = x
        c1 = c2 = max(c1, c2) + 1

    elif x1 + h < x:
        if x2 >= x:
            c2 = -10

        x1, x2 = x, x + h
        c1, c2 = max(c1 + 1, c2), max(c1, c2) + 1

    else:
        if x2 >= x:
            c2 = -10

        x1, x2 = x, x + h
        c1, c2 = max(c1, c2), max(c1, c2) + 1

print(max(c1, c2))
