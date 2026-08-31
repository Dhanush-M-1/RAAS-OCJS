import bisect
from sys import stdin
q = int(stdin.readline())
for _ in range(q):
    l, r, d = map(int, stdin.readline().split())
    if l <= d:
        if d > r:
            print(d)
        elif d == r:
            print(2 * d)
        else:
            x, y = divmod(r + 1, d)
            if y == 0:
                print(r + 1)
            else:
                print(d * (x + 1))

    else:
        print(d)
