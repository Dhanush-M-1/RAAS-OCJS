r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

x1 = (c1 + d2 - r1)
if x1 % 2 == 1:
    print(-1)
else:
    x = x1 // 2
    y = r2 - x
    v = d1 - y
    w = r1 - v

    daf = [x, y, v, w]

    set_gem = {1, 2, 3, 4, 5, 6, 7, 8, 9}

    flag = True

    for gem in daf:
        if gem in set_gem:
            set_gem.remove(gem)
        else:
            flag = False
            break

    if not flag:
        print(-1)
    else:
        print(v, w)
        print(x, y)
