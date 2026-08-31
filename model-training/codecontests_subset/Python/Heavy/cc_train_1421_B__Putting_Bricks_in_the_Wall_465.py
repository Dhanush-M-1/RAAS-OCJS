t = int(input())
for i in range(t):
    n = int(input())
    a = [['.'] * n for j in range(n)]
    res = 0
    ans = []
    for k in range(n):
        a[k] = list(input())
    if a[0][1] == '0' and a[1][0] == '0':
        if a[-2][-1] == '0':
            res += 1
            ans.append((n - 1, n))
        if a[-1][-2] == '0':
            res += 1
            ans.append((n, n - 1))
    if a[0][1] == '1' and a[1][0] == '1':
        if a[-2][-1] == '1':
            res += 1
            ans.append((n - 1, n))
        if a[-1][-2] == '1':
            res += 1
            ans.append((n, n - 1))
    if a[0][1] == '0' and a[1][0] == '1':
        if a[-2][-1] == '0' and a[-1][-2] == '0':
            res += 1
            ans.append((1, 2))
        if a[-2][-1] == '1' and a[-1][-2] == '1':
            res += 1
            ans.append((2, 1))
        if a[-2][-1] == '0' and a[-1][-2] == '1':
            res += 1
            ans.append((2, 1))
            res += 1
            ans.append((n - 1, n))
        if a[-2][-1] == '1' and a[-1][-2] == '0':
            res += 1
            ans.append((2, 1))
            res += 1
            ans.append((n, n - 1))
    if a[0][1] == '1' and a[1][0] == '0':
        if a[-2][-1] == '0' and a[-1][-2] == '0':
            res += 1
            ans.append((2, 1))
        if a[-2][-1] == '1' and a[-1][-2] == '1':
            res += 1
            ans.append((1, 2))
        if a[-2][-1] == '0' and a[-1][-2] == '1':
            res += 1
            ans.append((1, 2))
            res += 1
            ans.append((n - 1, n))
        if a[-2][-1] == '1' and a[-1][-2] == '0':
            res += 1
            ans.append((1, 2))
            res += 1
            ans.append((n, n - 1))
    print(res)
    for x in ans:
        print(*x)
