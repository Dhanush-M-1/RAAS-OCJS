from itertools import chain

for _ in range(int(input())):
    n = int(input())
    a = []
    cur_p = -1
    cur_a = 1
    for p in chain(map(int, reversed(input().split())), (-1,)):
        if cur_p == p:
            cur_a += 1
        else:
            a.append(cur_a)
            cur_a = 1
            cur_p = p
    a.reverse()
    assert a.pop() == 1
    g = a[0]
    i = 1
    s = 0
    try:
        while s <= g:
            s += a[i]
            i += 1
        b = 0
        while (g + s + b + a[i]) * 2 <= n:
            b += a[i]
            i += 1
        if (g + s + b) * 2 > n or g >= b:
            a = [][0]
        print(g, s, b)
    except IndexError:
        print('0 0 0')
