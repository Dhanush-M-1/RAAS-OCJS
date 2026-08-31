while 1:
    n = int(input())
    if n == 0:
        break
    l = input().split()
    lup, rup, up = False, False, False
    res = 0
    for s in l:
        if s == 'lu':
            lup = True
        if s == 'ru':
            rup = True
        if s == 'ld':
            lup = False
        if s == 'rd':
            rup = False
        if lup and rup:
            if not up:
                res += 1
            up = True
        if not lup and not rup:
            if up:
                res += 1
            up = False
    print(res)
