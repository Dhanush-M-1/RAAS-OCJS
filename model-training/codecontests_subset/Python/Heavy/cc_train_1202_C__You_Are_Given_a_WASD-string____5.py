from sys import setrecursionlimit as SRL, stdin

SRL(10 ** 7)
rd = stdin.readline
rrd = lambda: map(int, rd().strip().split())

n = int(input())

while n:
    s = map(str,rd().strip())

    l = 0
    pl = 1
    r = 0
    pr = 1
    u = 0
    pu = 1
    b = 0
    pb = 1
    curx = 0
    cury = 0

    for x in s:
        if x == 'S':
            cury -= 1
            if cury < b:
                b = cury
                if u-b > 1:
                    pu = 0
            elif cury == b:
                pb = 1
        elif x == 'W':
            cury += 1
            if cury > u:
                u = cury
                if u - b > 1:
                    pb = 0
            elif cury == u:
                pu = 1
        elif x == 'A':
            curx -= 1
            if curx < l:
                l = curx
                if r - l > 1:
                    pr = 0
            elif curx == l:
                pl = 1
        elif x == 'D':
            curx += 1
            if curx > r:
                r = curx
                if r - l > 1:
                    pl = 0
            elif curx == r:
                pr = 1

    ans = (r-l+1)*(u-b+1)
    if not pl or not pr:
        ans = min(ans,(r-l)*(u-b+1))
    if not pb or not pu:
        ans = min(ans,(r-l+1)*(u-b))
    print(ans)

    n -= 1

