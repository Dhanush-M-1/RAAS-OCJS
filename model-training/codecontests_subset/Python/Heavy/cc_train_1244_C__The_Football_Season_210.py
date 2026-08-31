#!/usr/bin/env python3
import sys

n, p, w, d = map(int, next(sys.stdin).split(" "))


def solution():
    a = min(p // d, p // w)
    b = max(p // d + 1, p // w + 1)

    z = max(n - b, 0)
    if n - a < 0:
        print(-1)
        return

    divider = w - d

    if (d % divider == 0 or w % divider == 0) and p % divider != 0:
        print(-1)
        return

    while z <= n - a:
        z2 = n - z

        xdiv = (p - d * z2) // divider
        ydiv = (w * z2 - p) // divider

        xmod = (p - d * z2) % divider
        ymod = (w * z2 - p) % divider

        if xmod == 0 and ymod == 0 and xdiv >= 0 and ydiv >= 0:
            print(xdiv, ydiv, z)
            return
        z += 1

    print(-1)


solution()
