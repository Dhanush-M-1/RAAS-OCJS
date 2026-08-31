n, x, y = map(int, input().split())

p = 0
for i in range(10**6 + 1):
    if ( (x + p) / n) >= y / 100:
        print(p)
        break

    p += 1

