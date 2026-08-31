for _ in range(int(input())):
    n, l, r = map(int, input().split())
    cursum = 0
    curn = n - 1
    while curn > 0 and (cursum + (curn << 1)) < l:
        cursum += curn << 1
        curn -= 1
    fix = n - curn
    d = False
    i = fix
    nexti = fix + 1
    # print(cursum, l, i, nexti)
    for _ in range(cursum + 1, l):
        if d:
            nexti += 1
            if nexti > n:
                fix += 1
                nexti = fix + 1
            i = fix
        else:
            i = nexti
        d ^= True
    ans = [i]
    for _ in range(l, r):
        if d:
            nexti += 1
            if nexti > n:
                fix += 1
                nexti = fix + 1
            i = fix
        else:
            i = nexti
        ans.append(i)
        d ^= True

    if r == n * (n - 1) + 1:
        ans[-1] = 1
    elif nexti > n:
        ans[-1] = fix + 1
    print(' '.join(map(str, ans)))
