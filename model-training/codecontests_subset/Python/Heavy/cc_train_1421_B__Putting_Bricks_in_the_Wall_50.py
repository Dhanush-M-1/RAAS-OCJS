def solv():
    x = int(input())
    s = [list(input()) for n in range(x)]

    ct = 0
    v = []
    if s[0][1] != '0':
        ct += 1
        v.append([1, 2])
    if s[1][0] != '0':
        ct += 1
        v.append([2, 1])
    if s[x-1][x-2] != '1':
        ct += 1
        v.append([x, x-1])
    if s[x-2][x-1] != '1':
        ct += 1
        v.append([x-1, x])
    if ct <= 2:
        print(ct)
        for n in v:
            print(*n)
        return

    ct = 0
    v = []
    if s[0][1] != '1':
        ct += 1
        v.append([1, 2])
    if s[1][0] != '1':
        ct += 1
        v.append([2, 1])
    if s[x-1][x-2] != '0':
        ct += 1
        v.append([x, x-1])
    if s[x-2][x-1] != '0':
        ct += 1
        v.append([x-1, x])
    if ct <= 2:
        print(ct)
        for n in v:
            print(*n)
        return


for _ in range(int(input())):
    solv()
