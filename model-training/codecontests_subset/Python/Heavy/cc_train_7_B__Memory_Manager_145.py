t, m = map(int, input().split())
a, cnt, idx = [], 0, 0
for _ in range(t):
    s = input()
    if s[0] != 'd':
        s, n = s.split()
        n = int(n)
    if s[0] == 'a':
        f = False
        for i, item in enumerate(a):
            if not item[1] and item[0] >= n:
                f = True
                idx += 1
                a[i][0] -= n
                a.insert(i, [n, idx])
                break
        if not f and cnt + n <= m:
            idx += 1
            cnt += n
            a.append([n, idx])
            f = True
        if f:
            print(idx)
        else:
            print('NULL')
    elif s[0] == 'e':
        f = False
        for i, item in enumerate(a):
            if item[1] == n:
                if i == len(a) - 1:
                    cnt -= item[0]
                    a.pop()
                else:
                    item[1] = 0
                f = True
                break
        if not f:
            print('ILLEGAL_ERASE_ARGUMENT')
    else:
        for i, item in enumerate(a):
            if item[1] == 0:
                cnt -= item[0]
                del a[i]