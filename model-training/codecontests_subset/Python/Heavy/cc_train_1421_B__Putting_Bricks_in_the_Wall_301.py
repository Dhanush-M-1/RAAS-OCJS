t = int(input())

import itertools
for _ in range(t):
    n = int(input())
    S = [list(str(input())) for _ in range(n)]
    flag = False

    s = []
    # 0
    s.append((0, 0))
    visit0 = [[-1]*n for _ in range(n)]
    while s:
        i, j = s.pop()
        for di, dj in (-1, 0), (1, 0), (0, -1), (0, 1):
            ni,nj = i+di, j+dj
            if 0 <= ni < n and 0 <= nj < n:
                if S[ni][nj] == '0' or S[ni][nj] == 'F':
                    if visit0[ni][nj] == -1:
                        visit0[ni][nj] = 0
                        s.append((ni, nj))
    #1
    s.append((0, 0))
    visit1 = [[-1]*n for _ in range(n)]
    while s:
        i, j = s.pop()
        for di, dj in (-1, 0), (1, 0), (0, -1), (0, 1):
            ni,nj = i+di, j+dj
            if 0 <= ni < n and 0 <= nj < n:
                if S[ni][nj] == '1' or S[ni][nj] == 'F':
                    if visit1[ni][nj] == -1:
                        visit1[ni][nj] = 0
                        s.append((ni, nj))
    if visit0[n-1][n-1] == -1 and visit1[n-1][n-1] == -1:
        print(0)
        continue

    if S[0][1] == '0' and S[1][0] == '0' and S[n-1][n-2] == '0' and S[n-2][n-1] == '0':
        print(2)
        print(1, 2)
        print(2, 1)
    elif S[0][1] == '0' and S[1][0] == '0' and S[n-1][n-2] == '1' and S[n-2][n-1] == '0':
        print(1)
        print(n-1, n)
    elif S[0][1] == '0' and S[1][0] == '0' and S[n-1][n-2] == '0' and S[n-2][n-1] == '1':
        print(1)
        print(n, n-1)
    elif S[0][1] == '0' and S[1][0] == '0' and S[n-1][n-2] == '1' and S[n-2][n-1] == '1':
        print(0)

    elif S[0][1] == '1' and S[1][0] == '0' and S[n-1][n-2] == '0' and S[n-2][n-1] == '0':
        print(1)
        print(2, 1)
    elif S[0][1] == '1' and S[1][0] == '0' and S[n-1][n-2] == '1' and S[n-2][n-1] == '0':
        print(2)
        print(1, 2)
        print(n-1, n)
    elif S[0][1] == '1' and S[1][0] == '0' and S[n-1][n-2] == '0' and S[n-2][n-1] == '1':
        print(2)
        print(1, 2)
        print(n, n-1)
    elif S[0][1] == '1' and S[1][0] == '0' and S[n-1][n-2] == '1' and S[n-2][n-1] == '1':
        print(1)
        print(1, 2)

    elif S[0][1] == '0' and S[1][0] == '1' and S[n-1][n-2] == '0' and S[n-2][n-1] == '0':
        print(1)
        print(1, 2)
    elif S[0][1] == '0' and S[1][0] == '1' and S[n-1][n-2] == '1' and S[n-2][n-1] == '0':
        print(2)
        print(2, 1)
        print(n-1, n)
    elif S[0][1] == '0' and S[1][0] == '1' and S[n-1][n-2] == '0' and S[n-2][n-1] == '1':
        print(2)
        print(2, 1)
        print(n, n-1)
    elif S[0][1] == '0' and S[1][0] == '1' and S[n-1][n-2] == '1' and S[n-2][n-1] == '1':
        print(1)
        print(2, 1)

    elif S[0][1] == '1' and S[1][0] == '1' and S[n-1][n-2] == '0' and S[n-2][n-1] == '0':
        print(0)
    elif S[0][1] == '1' and S[1][0] == '1' and S[n-1][n-2] == '1' and S[n-2][n-1] == '0':
        print(1)
        print(n, n-1)
    elif S[0][1] == '1' and S[1][0] == '1' and S[n-1][n-2] == '0' and S[n-2][n-1] == '1':
        print(1)
        print(n-1, n)
    elif S[0][1] == '1' and S[1][0] == '1' and S[n-1][n-2] == '1' and S[n-2][n-1] == '1':
        print(2)
        print(1, 2)
        print(2, 1)
