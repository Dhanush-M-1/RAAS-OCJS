
for _ in range(int(input())):
    a, b, n = map(int, input().split())
    a, b = bin(a)[2:], bin(b)[2:]
    m = max(len(a), len(b))
    a = '0' * (m - len(a)) + a
    b = '0' * (m - len(b)) + b
    res = ''
    if n == 0:
        res = a
    elif n == 1:
        res = b
    else:
        for i in range(m):
            # shift = {'01': 0, '10': 1, '11': 2}
            r = a[i] + b[i]
            if r == '00':
                res += '0'
            else:
                k = (n - (int(r, 2) - 1)) % 3
                res += "011"[k]

    print(int(res, 2))
