from sys import stdin
from sys import setrecursionlimit as SRL; SRL(10**7)
rd = stdin.readline
rrd = lambda: map(int, rd().strip().split())


t = int(input())

while t:
    s = str(rd().strip())
    s = '0' + s + '0'
    g = s[::-1]

    posx = [0] *len(s)
    posy = [0] *len(s)
    l = [0] *len(s)
    r = [0] *len(s)
    tp = [0] *len(s)
    b = [0] * len(s)

    rposx = [0] * len(s)
    rposy = [0] * len(s)
    rl = [0] * len(s)
    rr = [0] * len(s)
    rt = [0] * len(s)
    rb = [0] * len(s)


    posx[0] = posy[0] = l[0] = r[0] = tp[0] = b[0]  = 2*10**5+50

    for i in range(1,len(s)-1):
        if s[i] == 'W':
            posy[i] = posy[i-1] + 1

        elif s[i] == 'S':
            posy[i] = posy[i-1] - 1

        elif s[i] == 'A':
            posx[i] = posx[i-1] - 1

        elif s[i] == 'D':
            posx[i] = posx[i-1] + 1

        if not posx[i]:
            posx[i] = posx[i-1]
        if not posy[i]:
            posy[i] = posy[i-1]

        l[i] = min(l[i-1], posx[i])
        r[i] = max(r[i-1], posx[i])
        b[i] = min(b[i - 1], posy[i])
        tp[i] = max(tp[i - 1], posy[i])


    rt[0] = rb[0] = rposy[0] = posy[len(s) - 2]
    rl[0] = rr[0] = rposx[0] = posx[len(s) - 2]



    for i in range(1, len(g) -1):
        if g[i] == 'W':
            rposy[i] = rposy[i - 1] - 1

        elif g[i] == 'S':
            rposy[i] = rposy[i - 1] + 1

        elif g[i] == 'A':
            rposx[i] = rposx[i-1] + 1

        elif g[i] == 'D':
            rposx[i] = rposx[i-1] - 1

        if not rposx[i]:
            rposx[i] = rposx[i - 1]
        if not rposy[i]:
            rposy[i] = rposy[i - 1]

        rl[i] = min(rl[i-1], rposx[i])
        rr[i] = max(rr[i-1], rposx[i])
        rb[i] = min(rb[i - 1], rposy[i])
        rt[i] = max(rt[i - 1], rposy[i])

    dx = False
    dy = False
    ls = len(s) - 2


    for i in range (1,len(s)-1):

        if (l[i] - rl[ls-i])*(r[i] - rr[ls-i]) > 0:
            dx = True
        if (tp[i] - rt[ls-i])*(b[i] - rb[ls-i]) > 0:
            dy = True


    wd = r[ls]-l[ls] + 1
    ht = tp[ls] - b[ls] +1

    ans = wd*ht

    if dx:
        ans = min(ans,(wd-1)*ht)
    if dy:
        ans = min(ans,(ht-1)*wd)

    print(ans)

    t -= 1
