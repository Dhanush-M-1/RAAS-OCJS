tt = int(input())
for _ in range(tt):
    n = int(input())
    s = []
    for i in range(n):
        s += [input()]

    a = (s[0][1], (1, 2))
    b = (s[1][0], (2, 1))

    c = (s[n-2][n-1], (n-1, n))
    d = (s[n-1][n-2], (n, n-1))


    A = [a, b]
    B = [c, d]

    res = []

    if A[0][0] != A[1][0] and B[0][0] != B[1][0]:
        if A[0][0] == '0': res += [A[0][1]]
        else: res += [A[1][1]]

        if B[0][0] == '1': res += [B[0][1]]
        else: res += [B[1][1]]
    elif A[0][0] == A[1][0]:
        if B[0][0] == A[0][0]: res += [B[0][1]]
        if B[1][0] == A[0][0]: res += [B[1][1]]
    elif B[0][0] == B[1][0]:
        if A[0][0] == B[0][0]: res += [A[0][1]]
        if A[1][0] == B[0][0]: res += [A[1][1]]


    print(len(res))
    for x, y in res:
        print(x, y)
    