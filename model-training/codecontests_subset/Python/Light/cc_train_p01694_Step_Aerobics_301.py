while True:
    if input() == '0':
        break
    actions = input().split()
    r, l = False, False
    floor = True
    n = 0
    for a in actions:
        if a[0] == 'r':
            r = not r
        elif a[0] == 'l':
            l = not l
        if r == l == floor:
            n += 1
            floor = not floor
    print(n)